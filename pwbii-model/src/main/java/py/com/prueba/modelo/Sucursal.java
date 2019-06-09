package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "lunes_hora_apertura")
    private String lunesHoraApertura;
    
    @Basic(optional = false)
    @Column(name = "lunes_hora_cierre")
    private String lunesHoraCierre;
    
    @Basic(optional = false)
    @Column(name = "martes_hora_apertura")
    private String martesHoraApertura;
    
    @Basic(optional = false)
    @Column(name = "martes_hora_cierre")
    private String martesHoracierre;
    
    @Basic(optional = false)
    @Column(name = "miercoles_hora_apertura")
    private String miercolesNoraapertura;
    
    @Basic(optional = false)
    @Column(name = "miercoles_hora_cierre")
    private String miercolesHoraCierre;
    
    @Basic(optional = false)
    @Column(name = "jueves_hora_apertura")
    private String juevesHoraApertura;
    
    @Basic(optional = false)
    @Column(name = "jueves_hora_cierre")
    private String juevesGoraCierre;
    
    @Basic(optional = false)
    @Column(name = "viernes_hora_apertura")
    private String viernesGoraApertura;
    
    @Basic(optional = false)
    @Column(name = "viernes_hora_cierre")
    private String viernesHoraCierre;
    
    @Basic(optional = false)
    @Column(name = "sabado_hora_apertura")
    private String sabadoHoraApertura;
    
    @Basic(optional = false)
    @Column(name = "sabado_hora_cierre")
    private String sabadoHoraCierre;
    
    @Basic(optional = false)
    @Column(name = "domingo_hora_cierre")
    private String domingoHoraCierre;
    
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

    public String getLunesHoraApertura() {
        return lunesHoraApertura;
    }

    public void setLunesHoraApertura(String lunesHoraApertura) {
        this.lunesHoraApertura = lunesHoraApertura;
    }

    public String getLunesHoraCierre() {
        return lunesHoraCierre;
    }

    public void setLunesHoraCierre(String lunesHoraCierre) {
        this.lunesHoraCierre = lunesHoraCierre;
    }

    public String getMartesHoraApertura() {
        return martesHoraApertura;
    }

    public void setMartesHoraApertura(String martesHoraApertura) {
        this.martesHoraApertura = martesHoraApertura;
    }

    public String getMartesHoracierre() {
        return martesHoracierre;
    }

    public void setMartesHoracierre(String martesHoracierre) {
        this.martesHoracierre = martesHoracierre;
    }

    public String getMiercolesNoraapertura() {
        return miercolesNoraapertura;
    }

    public void setMiercolesNoraapertura(String miercolesNoraapertura) {
        this.miercolesNoraapertura = miercolesNoraapertura;
    }

    public String getMiercolesHoraCierre() {
        return miercolesHoraCierre;
    }

    public void setMiercolesHoraCierre(String miercolesHoraCierre) {
        this.miercolesHoraCierre = miercolesHoraCierre;
    }

    public String getJuevesHoraApertura() {
        return juevesHoraApertura;
    }

    public void setJuevesHoraApertura(String juevesHoraApertura) {
        this.juevesHoraApertura = juevesHoraApertura;
    }

    public String getJuevesGoraCierre() {
        return juevesGoraCierre;
    }

    public void setJuevesGoraCierre(String juevesGoraCierre) {
        this.juevesGoraCierre = juevesGoraCierre;
    }

    public String getViernesGoraApertura() {
        return viernesGoraApertura;
    }

    public void setViernesGoraApertura(String viernesGoraApertura) {
        this.viernesGoraApertura = viernesGoraApertura;
    }

    public String getViernesHoraCierre() {
        return viernesHoraCierre;
    }

    public void setViernesHoraCierre(String viernesHoraCierre) {
        this.viernesHoraCierre = viernesHoraCierre;
    }

    public String getSabadoHoraApertura() {
        return sabadoHoraApertura;
    }

    public void setSabadoHoraApertura(String sabadoHoraApertura) {
        this.sabadoHoraApertura = sabadoHoraApertura;
    }

    public String getSabadoHoraCierre() {
        return sabadoHoraCierre;
    }

    public void setSabadoHoraCierre(String sabadoHoraCierre) {
        this.sabadoHoraCierre = sabadoHoraCierre;
    }

    public String getDomingoHoraCierre() {
        return domingoHoraCierre;
    }

    public void setDomingoHoraCierre(String domingoHoraCierre) {
        this.domingoHoraCierre = domingoHoraCierre;
    }

    public List<SucursalServicio> getSucursalServicioList() {
        return sucursalServicioList;
    }

    public void setSucursalServicioList(List<SucursalServicio> sucursalServicioList) {
        this.sucursalServicioList = sucursalServicioList;
    }

   
}
