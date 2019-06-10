package py.com.prueba.ejb;
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
}
