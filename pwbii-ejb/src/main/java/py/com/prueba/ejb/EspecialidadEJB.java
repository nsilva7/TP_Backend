package py.com.prueba.ejb;


import py.com.prueba.modelo.Especialidad;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class EspecialidadEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Especialidad get(Integer id) {
        return em.find(Especialidad.class, id);
    }

    public void persist(Especialidad entity){
        getEm().persist(entity);
    }
    
    public Especialidad merge(Especialidad entity){
        return (Especialidad) getEm().merge(entity);
    }
    public void delete(Integer id){
        Especialidad entity = this.get(id);
        this.getEm().remove(entity);
    }
    public void delete(Especialidad entity){
        this.delete(entity.getIdEspecialidad());
    }
    @SuppressWarnings("unchecked")
    public List<Especialidad> lista() {
        Query q = getEm().createQuery(
                "SELECT e FROM Especialidad e ");
        return (List<Especialidad>) q.getResultList();
    }
   
}
