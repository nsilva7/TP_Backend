package py.com.prueba.ejb;


import py.com.prueba.modelo.Categoria;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class CategoriaEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Categoria get(Integer id) {
        return em.find(Categoria.class, id);
    }

    public void persist(Categoria entity){
        getEm().persist(entity);
    }
    
    public Categoria merge(Categoria entity){
        return (Categoria) getEm().merge(entity);
    }
    public void delete(Integer id){
        Categoria entity = this.get(id);
        this.getEm().remove(entity);
    }
    public void delete(Categoria entity){
        this.delete(entity.getIdCategoria());
    }
    @SuppressWarnings("unchecked")
    public List<Categoria> lista() {
        Query q = getEm().createQuery(
                "SELECT c FROM Categoria c");
        return (List<Categoria>) q.getResultList();
    }
   
}
