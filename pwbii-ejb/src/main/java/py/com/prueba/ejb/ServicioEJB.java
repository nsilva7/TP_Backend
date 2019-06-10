package py.com.prueba.ejb;


import py.com.prueba.modelo.Servicio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import py.com.prueba.modelo.SucursalServicio;


@Stateless
public class ServicioEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Servicio get(Integer id) {
        return em.find(Servicio.class, id);
    }
    
    public SucursalServicio getSucursalServicio(Integer id){
        return em.find(SucursalServicio.class, id);
        
    }

    public void persist(Servicio entity){
        getEm().persist(entity);
    }
    
    public Servicio merge(Servicio entity){
        return (Servicio) getEm().merge(entity);
    }
    public void delete(Integer id){
        Servicio entity = this.get(id);
        this.getEm().remove(entity);
    }
    public void delete(Servicio entity){
        this.delete(entity.getIdServicio());
    }
    @SuppressWarnings("unchecked")
    public List<Servicio> lista() {
        Query q = getEm().createQuery(
                "SELECT s FROM Servicio s");
        return (List<Servicio>) q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Servicio> listaSucursal(int idSucursal) {
        Query q = getEm().createQuery(
                "SELECT s.id_servicio,s.nombre, ss.id_sucursal FROM Servicio s JOIN SucursalServicio ss WHERE s.id_servicio == ss.id_servicio AND ss.id_sucursal = "+ idSucursal);
        return (List<Servicio>) q.getResultList();
    }
   
}
