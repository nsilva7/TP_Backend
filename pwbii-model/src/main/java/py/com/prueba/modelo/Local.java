package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="local")
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_local")
    @GeneratedValue(generator="localSec")
    @SequenceGenerator(name="localSec",sequenceName="local_sec",allocationSize=0)
    private Integer idLocal;
    @Basic(optional = false)
    @Column(name = "nombre",length=50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion",length=200)
    private String descripcion;
    @Basic(optional = false)

    @Transient
    private Persona persona;
    public Local() {

    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
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
}
