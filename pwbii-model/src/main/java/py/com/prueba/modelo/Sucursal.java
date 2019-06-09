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
    private Time lunesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "lunes_hora_cierre")
    private Time lunesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "martes_hora_apertura")
    private Time martesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "martes_hora_cierre")
    private Time martesHoracierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "miercoles_hora_apertura")
    private Time miercolesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "miercoles_hora_cierre")
    private Time miercolesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "jueves_hora_apertura")
    private Time juevesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "jueves_hora_cierre")
    private Time juevesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "viernes_hora_apertura")
    private Time viernesHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "viernes_hora_cierre")
    private Time viernesHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "sabado_hora_apertura")
    private Time sabadoHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "sabado_hora_cierre")
    private Time sabadoHoraCierre;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "domingo_hora_apertura")
    private Time domingoHoraApertura;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "domingo_hora_cierre")
    private Time domingoHoraCierre;
    
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

    public Time getLunesHoraApertura() {
        return lunesHoraApertura;
    }

    public void setLunesHoraApertura(Time lunesHoraApertura) {
        this.lunesHoraApertura = lunesHoraApertura;
    }

    public Time getLunesHoraCierre() {
        return lunesHoraCierre;
    }

    public void setLunesHoraCierre(Time lunesHoraCierre) {
        this.lunesHoraCierre = lunesHoraCierre;
    }

    public Time getMartesHoraApertura() {
        return martesHoraApertura;
    }

    public void setMartesHoraApertura(Time martesHoraApertura) {
        this.martesHoraApertura = martesHoraApertura;
    }

    public Time getMartesHoracierre() {
        return martesHoracierre;
    }

    public void setMartesHoracierre(Time martesHoracierre) {
        this.martesHoracierre = martesHoracierre;
    }

    public Time getMiercolesHoraApertura() {
        return miercolesHoraApertura;
    }

    public void setMiercolesHoraApertura(Time miercolesHoraApertura) {
        this.miercolesHoraApertura = miercolesHoraApertura;
    }

    public Time getMiercolesHoraCierre() {
        return miercolesHoraCierre;
    }

    public void setMiercolesHoraCierre(Time miercolesHoraCierre) {
        this.miercolesHoraCierre = miercolesHoraCierre;
    }

    public Time getJuevesHoraApertura() {
        return juevesHoraApertura;
    }

    public void setJuevesHoraApertura(Time juevesHoraApertura) {
        this.juevesHoraApertura = juevesHoraApertura;
    }

    public Time getJuevesHoraCierre() {
        return juevesHoraCierre;
    }

    public void setJuevesHoraCierre(Time juevesHoraCierre) {
        this.juevesHoraCierre = juevesHoraCierre;
    }

    public Time getViernesGoraApertura() {
        return viernesHoraApertura;
    }

    public void setViernesHoraApertura(Time viernesHoraApertura) {
        this.viernesHoraApertura = viernesHoraApertura;
    }

    public Time getViernesHoraCierre() {
        return viernesHoraCierre;
    }

    public void setViernesHoraCierre(Time viernesHoraCierre) {
        this.viernesHoraCierre = viernesHoraCierre;
    }

    public Time getSabadoHoraApertura() {
        return sabadoHoraApertura;
    }

    public void setSabadoHoraApertura(Time sabadoHoraApertura) {
        this.sabadoHoraApertura = sabadoHoraApertura;
    }

    public Time getSabadoHoraCierre() {
        return sabadoHoraCierre;
    }

    public void setSabadoHoraCierre(Time sabadoHoraCierre) {
        this.sabadoHoraCierre = sabadoHoraCierre;
    }

    public Time getDomingoHoraCierre() {
        return domingoHoraCierre;
    }

    public void setDomingoHoraCierre(Time domingoHoraCierre) {
        this.domingoHoraCierre = domingoHoraCierre;
    }

    public List<SucursalServicio> getSucursalServicioList() {
        return sucursalServicioList;
    }

    public void setSucursalServicioList(List<SucursalServicio> sucursalServicioList) {
        this.sucursalServicioList = sucursalServicioList;
    }

   
}
