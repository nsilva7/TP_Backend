package py.com.prueba.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.prueba.modelo.Sucursal;
import py.com.prueba.modelo.SucursalServicio;

@Stateless
public class SucursalEJB {
    @PersistenceContext(unitName="pwbiiPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }

    public Sucursal get(Integer id) {
        return em.find(Sucursal.class, id);
    }
    
    public SucursalServicio getSucursalServicio(Integer id) {
        return em.find(SucursalServicio.class, id);
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
    public List lista(Integer categoria_id) {
        Query q = getEm().createNativeQuery(
                "select l.nombre as local, s.nombre as sucursal, c.nombre as categoria" +
                "    from sucursal s" +
                "    inner join local l on (s.id_local = l.id_local)" +
                "    join categoria_local cl on (cl.id_local = l.id_local)" +
                "    join categoria c on(cl.id_categoria = c.id_categoria)" +
                "    where c.id_categoria = " + categoria_id);
        return (List) q.getResultList();
    }
}
