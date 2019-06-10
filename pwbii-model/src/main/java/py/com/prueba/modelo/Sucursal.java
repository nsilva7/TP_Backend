package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="sucursal")
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    @GeneratedValue(generator="sucursalSec")
    @SequenceGenerator(name="sucursalSec",sequenceName="sucursal_sec",allocationSize=0)
    private Integer idSucursal;

    @Basic(optional = false)
    @Column(name = "nombre",length=50)
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "descripcion",length=200)
    private String descripcion;
    
    @JoinColumn(name = "id_local", referencedColumnName = "id_local")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Local local;
    
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Ciudad ciudad;
            
    @JoinColumn(name = "id_mapa", referencedColumnName = "id_mapa")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Mapa mapa;     
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "lunes_hora_apertura")
    private Date lunesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "lunes_hora_cierre")
    private Date lunesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "martes_hora_apertura")
    private Date martesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "martes_hora_cierre")
    private Date martesHoracierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "miercoles_hora_apertura")
    private Date miercolesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "miercoles_hora_cierre")
    private Date miercolesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "jueves_hora_apertura")
    private Date juevesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "jueves_hora_cierre")
    private Date juevesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "viernes_hora_apertura")
    private Date viernesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "viernes_hora_cierre")
    private Date viernesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "sabado_hora_apertura")
    private Date sabadoHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "sabado_hora_cierre")
    private Date sabadoHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "domingo_hora_apertura")
    private Date domingoHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "domingo_hora_cierre")
    private Date domingoHoraCierre;
    
    @OneToMany(mappedBy = "sucursal",fetch = FetchType.EAGER)
    private List<SucursalServicio> sucursalServicioList;
    
    public Sucursal() {

    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Date getLunesHoraApertura() {
        return lunesHoraApertura;
    }

    public void setLunesHoraApertura(Date lunesHoraApertura) {
        this.lunesHoraApertura = lunesHoraApertura;
    }

    public Date getLunesHoraCierre() {
        return lunesHoraCierre;
    }

    public void setLunesHoraCierre(Date lunesHoraCierre) {
        this.lunesHoraCierre = lunesHoraCierre;
    }

    public Date getMartesHoraApertura() {
        return martesHoraApertura;
    }

    public void setMartesHoraApertura(Date martesHoraApertura) {
        this.martesHoraApertura = martesHoraApertura;
    }

    public Date getMartesHoracierre() {
        return martesHoracierre;
    }

    public void setMartesHoracierre(Date martesHoracierre) {
        this.martesHoracierre = martesHoracierre;
    }

    public Date getMiercolesHoraApertura() {
        return miercolesHoraApertura;
    }

    public void setMiercolesHoraApertura(Date miercolesHoraApertura) {
        this.miercolesHoraApertura = miercolesHoraApertura;
    }

    public Date getMiercolesHoraCierre() {
        return miercolesHoraCierre;
    }

    public void setMiercolesHoraCierre(Date miercolesHoraCierre) {
        this.miercolesHoraCierre = miercolesHoraCierre;
    }

    public Date getJuevesHoraApertura() {
        return juevesHoraApertura;
    }

    public void setJuevesHoraApertura(Date juevesHoraApertura) {
        this.juevesHoraApertura = juevesHoraApertura;
    }

    public Date getJuevesHoraCierre() {
        return juevesHoraCierre;
    }

    public void setJuevesHoraCierre(Date juevesHoraCierre) {
        this.juevesHoraCierre = juevesHoraCierre;
    }

    public Date getViernesGoraApertura() {
        return viernesHoraApertura;
    }

    public void setViernesHoraApertura(Date viernesHoraApertura) {
        this.viernesHoraApertura = viernesHoraApertura;
    }

    public Date getViernesHoraCierre() {
        return viernesHoraCierre;
    }

    public void setViernesHoraCierre(Date viernesHoraCierre) {
        this.viernesHoraCierre = viernesHoraCierre;
    }

    public Date getSabadoHoraApertura() {
        return sabadoHoraApertura;
    }

    public void setSabadoHoraApertura(Date sabadoHoraApertura) {
        this.sabadoHoraApertura = sabadoHoraApertura;
    }

    public Date getSabadoHoraCierre() {
        return sabadoHoraCierre;
    }

    public void setSabadoHoraCierre(Date sabadoHoraCierre) {
        this.sabadoHoraCierre = sabadoHoraCierre;
    }

    public Date getDomingoHoraCierre() {
        return domingoHoraCierre;
    }

    public void setDomingoHoraCierre(Date domingoHoraCierre) {
        this.domingoHoraCierre = domingoHoraCierre;
    }

    public List<SucursalServicio> getSucursalServicioList() {
        return sucursalServicioList;
    }

    public void setSucursalServicioList(List<SucursalServicio> sucursalServicioList) {
        this.sucursalServicioList = sucursalServicioList;
    }

   
}
