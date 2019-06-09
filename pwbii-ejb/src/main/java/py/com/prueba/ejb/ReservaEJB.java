package py.com.prueba.ejb;
import py.com.prueba.modelo.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class ReservaEJB {
    
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Reserva get(Integer id) {
        return em.find(Reserva.class, id);
    }

    public void persist(Reserva entity){
        getEm().persist(entity);
    }
}
