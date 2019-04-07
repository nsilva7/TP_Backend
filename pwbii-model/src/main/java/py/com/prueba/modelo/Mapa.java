package py.com.prueba.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="mapa")
public class Mapa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mapa")
    @GeneratedValue(generator="mapaSec")
    @SequenceGenerator(name="mapaSec",sequenceName="mapa_sec",allocationSize=0)
    private Integer idMapa;
    @Basic(optional = false)
    @Column(name = "nombre",length=50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion",length=200)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "latitud")
    private Integer latitud;
    @Basic(optional = false)
    @Column(name = "longitud")
    private Integer longitud;
    


    public Mapa() {

    }

    public Integer getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(Integer idMapa) {
        this.idMapa = idMapa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    
}
