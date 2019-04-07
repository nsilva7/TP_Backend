package py.com.prueba.ejb;


import py.com.prueba.modelo.Agenda;
import py.com.prueba.modelo.Persona;
import py.com.prueba.modelo.Categoria;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class AgendaEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    @Inject
    private PersonaEJB personaEJB;
    
    @Inject
    private CategoriaEJB CategoriaEJB;

    protected EntityManager getEm() {
        return em;
    }

    public Agenda get(Integer id) {
        return em.find(Agenda.class, id);
    }

    public void persist(Agenda entity){
        if (personaEJB.get(entity.getPersona().getIdPersona())==null) {
            throw new RuntimeException("La persona no existe");
        }
        entity.setIdPersona(new Persona());
        entity.getIdPersona().setIdPersona(entity.getPersona().getIdPersona());
        getEm().persist(entity);
    }
    public Agenda merge(Agenda entity){
        return (Agenda) getEm().merge(entity);
    }
    public void delete(Integer id){
        Agenda entity = this.get(id);
        this.getEm().remove(entity);
    }
    public void delete(Agenda entity){
        this.delete(entity.getIdAgenda());
    }
    @SuppressWarnings("unchecked")
    public List<Agenda> lista() {
        Query q = getEm().createQuery(
                "SELECT p FROM Agenda p");
        return (List<Agenda>) q.getResultList();
    }
    public Long total() {
        Query q = getEm().createQuery(
                "Select Count(p) from Agenda p");
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Categoria> listaCategorias() {
        return (List<Categoria>) CategoriaEJB.lista();
    }
    
}
