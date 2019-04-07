package py.com.prueba.ejb;


import py.com.prueba.modelo.Persona;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class PersonaEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Persona get(Integer id) {
        return em.find(Persona.class, id);
    }

    public void persist(Persona entity){
        getEm().persist(entity);
    }
    public Persona merge(Persona entity){
        return (Persona) getEm().merge(entity);
    }
    public void delete(Integer id){
        Persona entity = this.get(id);
        this.getEm().remove(entity);
    }
    public void delete(Persona entity){
        this.delete(entity.getIdPersona());
    }
    @SuppressWarnings("unchecked")
    public List<Persona> lista() {
        Query q = getEm().createQuery(
                "SELECT p FROM Persona p");
        return (List<Persona>) q.getResultList();
    }
    public Long total() {
        Query q = getEm().createQuery(
                "Select Count(p) from Persona p");
        return (Long) q.getSingleResult();
    }
}
