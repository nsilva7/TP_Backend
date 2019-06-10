package py.com.prueba.ejb;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import py.com.prueba.modelo.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.TemporalType;
import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode;
import py.com.prueba.modelo.Persona;
import py.com.prueba.modelo.Sucursal;
import py.com.prueba.modelo.SucursalServicio;


@Stateless
public class ReservaEJB {
    
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    @Inject
    private PersonaEJB personaEJB;
    
    @Inject
    private ServicioEJB servicioEJB;
    
    @Inject
    private SucursalEJB sucursalEJB;
    
    public EntityManager getEm() {
        return em;
    }

    public Reserva get(Integer id) {
        return em.find(Reserva.class, id);
    }

    public void persist(Reserva entity){
        Persona cliente = personaEJB.get(entity.getCliente().getIdPersona());
        if (cliente==null) {
            throw new RuntimeException("El cliente no existe");
        }
        entity.setCliente(cliente);
        Persona empleado = personaEJB.get(entity.getEmpleado().getIdPersona());
        if (empleado==null) {
            throw new RuntimeException("El empleado no existe");
        }
        entity.setCliente(empleado);
        SucursalServicio sc = servicioEJB.getSucursalServicio(entity.getSucursalServicio().getIdSucursalServicio());
        if (empleado==null) {
            throw new RuntimeException("No existe la relación SucursalServicio");
        }
        entity.setSucursalServicio(sc);
        Date today = Date.from(java.time.ZonedDateTime.now().toInstant());
        entity.setFechaHoraCreacion(today);
        entity.setFlagAsistio('N');
        entity.setFlagEstado('R');
        getEm().persist(entity);
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<Map<String,String>> listaDisponibles(int idSucursalServicio,String fecha, int idEmpleado) throws ParseException{
        Locale spanishLocale=new Locale("es", "ES");
        SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
        Date date = formatoFecha.parse(fecha);
        DateFormat formatoFechaDia  = new SimpleDateFormat("EEEE",spanishLocale);
        String diaDeSemana = formatoFechaDia.format(date);
        
        if(diaDeSemana.equals("sábado"))diaDeSemana="sabado";
        if(diaDeSemana.equals("miércoles"))diaDeSemana="miercoles";
        
        SucursalServicio sucursalServicio = sucursalEJB.getSucursalServicio(idSucursalServicio);
        Sucursal sucursal = sucursalServicio.getSucursal();
        
        Time horaApertura = (Time) getEm().createQuery("SELECT s."+diaDeSemana+"HoraApertura from Sucursal s WHERE s=:sucursal").setParameter("sucursal", sucursal).getSingleResult();
        Time horaCierre = (Time) getEm().createQuery("SELECT s."+diaDeSemana+"HoraCierre from Sucursal s WHERE s=:sucursal").setParameter("sucursal", sucursal).getSingleResult();
        
        int duracionServicio = sucursalServicio.getDuracion();
        int capacidad = sucursalServicio.getCapacidad();
        
        LocalTime horaAperturaLocal = horaApertura.toLocalTime();
        LocalTime horaCierreLocal = horaCierre.toLocalTime();
        LocalTime  iteracionLocalTime = horaAperturaLocal;
        ArrayList<Map<String,String>> map = new  ArrayList<Map<String,String>>();
        
        Persona empleado = null;
        if(idEmpleado != 0){
            empleado = personaEJB.get(idEmpleado);
            if(empleado == null)
                throw new RuntimeException("El empleado no existe");
            if(empleado.getFlagEmpleado() == '0')
                throw new RuntimeException("La persona no es empleado");
        }
            
        
        
        while ((iteracionLocalTime.plusMinutes( duracionServicio )).compareTo(horaCierreLocal) <= 0 ) {
            System.out.println("Iteracion Local Time"+ sucursalServicio);
            Long cantidadReservasRegistradas =(Long) getEm().createQuery("SELECT Count(r) FROM Reserva r WHERE  r.fecha=:fecha and r.horaInicio=:horaApertura and r.horaFin=:horaCierre and r.flagEstado='R'and  r.idSucursalServicio=:sucursalServicio")
	        						.setParameter("sucursalServicio", sucursalServicio)
	        						.setParameter("fecha", date,TemporalType.DATE)
	        						.setParameter("horaApertura", Time.valueOf(iteracionLocalTime))
	        						.setParameter("horaCierre", Time.valueOf(iteracionLocalTime.plusMinutes(duracionServicio))).getSingleResult();

            Long cantidadReservasRegistradasEmpleado = new Long(0);
            if(empleado != null){
                cantidadReservasRegistradasEmpleado =(Long) getEm().createQuery("SELECT Count(reserva) FROM Reserva reserva WHERE reserva.idSucursalServicio=:sucursalServicio and reserva.empleado=:empleado and reserva.fecha=:fecha and reserva.horaInicio=:horaApertura and reserva.horaFin=:horaCierre and reserva.flagEstado='R'")
	        						.setParameter("sucursalServicio", sucursalServicio)
                                                                .setParameter("empleado",empleado)
	        						.setParameter("fecha", date,TemporalType.DATE)
	        						.setParameter("horaApertura", Time.valueOf(iteracionLocalTime))
	        						.setParameter("horaCierre", Time.valueOf(iteracionLocalTime.plusMinutes(duracionServicio))).getSingleResult();
            }
            
            Long excepcionHorario=(Long) getEm().createQuery("SELECT Count(h) FROM HorarioExcepcion h WHERE h.idSucursal=:sucursal and h.fecha=:fecha and h.horaApertura=:horaApertura and h.horaCierre=:horaCierre")
		.setParameter("sucursal", sucursal)
		.setParameter("fecha", date,TemporalType.DATE)
		.setParameter("horaApertura", Time.valueOf(iteracionLocalTime))
		.setParameter("horaCierre", Time.valueOf(iteracionLocalTime.plusMinutes(duracionServicio))).getSingleResult();
                
            boolean checkEmpleado = true;
            if(empleado != null){
                if(cantidadReservasRegistradasEmpleado >= 1)
                    checkEmpleado = false;
                
            }
            if(excepcionHorario==0 && cantidadReservasRegistradas< capacidad && checkEmpleado) {
                    Map<String,String> temporal=new HashMap<String,String>();
                    temporal.put("fecha",fecha);
                    temporal.put("horaInicio", iteracionLocalTime.toString());
                    iteracionLocalTime=iteracionLocalTime.plusMinutes(duracionServicio);
                    temporal.put("horaSalida", iteracionLocalTime.toString());
                    map.add(temporal);
            }else {
                iteracionLocalTime=iteracionLocalTime.plusMinutes(duracionServicio);
            }
        }
        return map;
    }
    
    @SuppressWarnings("unchecked")
    public List<Reserva> lista(String fecha_desde, String fecha_hasta, String hora_desde, String hora_hasta,
            Integer id_servicio, Integer id_especialidad, Integer id_empleado, Integer id_local,
            Integer id_sucursal, String estado, String asistio, Integer from, Integer to 
    ) {
        System.out.println(fecha_desde);
        System.out.println(fecha_hasta);
        System.out.println(hora_desde);
        System.out.println(hora_hasta);
        System.out.println(id_servicio);
        System.out.println(id_servicio);
        System.out.println(id_especialidad);
        System.out.println(id_empleado);
        System.out.println(id_sucursal);
        System.out.println(estado);
        System.out.println(asistio);
        System.out.println(from);
        System.out.println(to);
        String query = "SELECT r FROM Reserva r "
                + " JOIN r.idSucursalServicio ss "
                + " JOIN ss.servicio ser "
                + " JOIN ss.sucursal suc "
                + " LEFT JOIN r.empleado emp "
                + " JOIN suc.local l "
                + " JOIN ser.especialidad esp "
                + "WHERE 1 = 1 ";
        if (fecha_desde != null)
            query += "and r.fecha >= '"+fecha_desde + "' ";
        if (fecha_hasta != null)
            query += "and r.fecha <= '"+fecha_hasta + "' ";
        if (hora_desde != null)
            query += "and r.horaInicio >= '"+hora_desde + "' ";
        if (hora_hasta != null)
            query += "and r.horaInicio <= '"+hora_hasta + "' ";
        
        if (id_servicio != null)
            query += "and ser.servicio = '"+id_servicio + "' ";
        if (id_especialidad != null)
            query += "and esp.idEspecialidad = '"+id_especialidad + "' ";
        if (id_empleado != null)
            query += "and emp.idPersona = '"+id_empleado + "' ";
        if (id_local != null)
            query += "and l.idLocal = '"+id_local + "' ";
        if (id_sucursal != null)
            query += "and suc.idSucursal = '"+id_sucursal + "' ";
        
        if (estado != null)
            query += "and r.flagEstado = '"+estado + "' ";
        if (asistio != null)
            query += "and r.flagAsistio = '"+asistio + "' ";
        
        Query q = getEm().createQuery(query);
        if(from!=null){
            q=q.setFirstResult(from);
        }
        if(to!=null){
            q=q.setMaxResults(to);
        }
        return (List<Reserva>) q.getResultList();
    }
    
    public Reserva actualizar(Reserva r) throws ParseException{
        boolean changed = false;
        Integer id = r.getIdReserva();
        Reserva reserva = this.get(id);
        String query = "Update Reserva SET ";
        if(r.getFlagEstado() != 0){
            SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String date =reserva.getFecha().toString() + " " +reserva.getHoraInicio().toString() ;
            Date start = dateFormat.parse(date);
            Date now = new Date();
            
            boolean ok = true;
            if(r.getFlagEstado() == 'C'){//Actualizacion a C
                ok = false;
                if(now.after(start) && r.getObservacion() != null)
                    ok = true;
                else
                    throw new RuntimeException("Error con parámetros");
            }
            query+="flagEstado = '"+r.getFlagEstado()+"' ";
            changed = true;
        }        
        if(r.getFlagAsistio()!= 0){
            if(reserva.getFlagAsistio() == 'S' || reserva.getFlagAsistio() == 'N')
                throw new RuntimeException("La reserva ya tiene estado");
            if(changed)query+=", ";
            query+="flagAsistio = '"+r.getFlagAsistio()+"' ";
            changed = true;
        }
        if(r.getObservacion()!= null){
            if(changed)query+=", ";
            query+="observacion = '"+r.getObservacion() +"' ";
            changed = true;
        }
        if(changed){
            query += "WHERE idReserva = "+id;
            getEm().createQuery(query).executeUpdate();
        }
        
        return this.get(id);
    }


}
