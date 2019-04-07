package py.com.prueba.ejb;

import py.com.prueba.modelo.Ciudad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CiudadEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Ciudad get(Integer id) {
        return em.find(Ciudad.class, id);
    }
}
