package py.com.prueba.ejb;
import java.util.Calendar;
import java.util.Date;
import py.com.prueba.modelo.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.TemporalType;
import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode;
import py.com.prueba.modelo.Persona;
import py.com.prueba.modelo.SucursalServicio;


@Stateless
public class ReservaEJB {
    
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    @Inject
    private PersonaEJB personaEJB;
    
    @Inject
    private ServicioEJB servicioEJB;
    
    protected EntityManager getEm() {
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
        entity.setFlagAsistido('N');
        entity.setFlagEstado('R');
        getEm().persist(entity);
    }
    
    @SuppressWarnings("unchecked")
    public List listaDisponibles(int idSucursalServicio, Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int dia = c.get(Calendar.DAY_OF_WEEK);
        String diaColumn = "";
        switch(dia) {
            case 1:
                diaColumn = "domingo";
                break;
            case 2:
                diaColumn = "lunes";
                break;
            case 3:
                diaColumn = "martes";
                break;
            case 4:
                diaColumn = "miercoles";
                break;
            case 5:
                diaColumn = "jueves";
                break;
            case 6:
                diaColumn = "viernes";
                break;
            case 7:
                diaColumn = "sabado";
                break;
            default:
        }
        
        Query q = getEm().createQuery(
                "SELECT ss.sucursal."+diaColumn+"_hora_apertura,ss.sucursal."+diaColumn+"_hora_cierre FROM SucursalServicio ss JOIN ss.sucursal su WHERE ss.idSucursalServicio = "+idSucursalServicio);
        List horarios = (List) q.getResultList();
        
        Query qReserva = getEm().createQuery(
                "SELECT r FROM Reserva r WHERE r.fecha != "+fecha);
        List horariosReservados = (List) qReserva.getResultList();
        
        return (List<Persona>) q.getResultList();
    }
}
