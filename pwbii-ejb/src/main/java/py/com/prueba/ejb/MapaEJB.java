package py.com.prueba.ejb;

import py.com.prueba.modelo.Mapa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MapaEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Mapa get(Integer id) {
        return em.find(Mapa.class, id);
    }
}
