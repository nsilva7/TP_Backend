/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.prueba.modelo.Sucursal;

/**
 *
 * @author jose
 */
public class SucursalEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Sucursal get(Integer id) {
        return em.find(Sucursal.class, id);
    }

    public void persist(Sucursal entity){
        getEm().persist(entity);
    }
    
    public Sucursal merge(Sucursal entity){
        return (Sucursal) getEm().merge(entity);
    }
    public void delete(Integer id){
        Sucursal entity = this.get(id);
        this.getEm().remove(entity);
    }
    public void delete(Sucursal entity){
        this.delete(entity.getIdSucursal());
    }
    @SuppressWarnings("unchecked")
    public List<Sucursal> lista() {
        Query q = getEm().createQuery(
                "SELECT s FROM Sucursal s");
        return (List<Sucursal>) q.getResultList();
    }
}
