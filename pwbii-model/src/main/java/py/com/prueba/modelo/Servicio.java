package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="servicio")
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_servicio")
    @GeneratedValue(generator="servicioSec")
    @SequenceGenerator(name="servicioSec",sequenceName="servicio_sec",allocationSize=0)
    private Integer idServicio;
    @Basic(optional = false)
    @Column(name = "nombre",length=50, unique = true)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "duracion_referencia")
    private Integer duracion_referencia;
    
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Especialidad especialidad;
    
    @OneToMany(mappedBy = "servicio",fetch = FetchType.EAGER)
    private List<SucursalServicio> sucursalServicioList;
    
     public Servicio() {

    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion_referencia() {
        return duracion_referencia;
    }

    public void setDuracion_referencia(Integer duracion_referencia) {
        this.duracion_referencia = duracion_referencia;
    }
    
    
}
