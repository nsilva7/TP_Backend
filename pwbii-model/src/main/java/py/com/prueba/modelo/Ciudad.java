package py.com.prueba.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ciudad")
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ciudad")
    @GeneratedValue(generator="ciudadSec")
    @SequenceGenerator(name="ciudadSec",sequenceName="ciudad_sec",allocationSize=0)
    private Integer idCiudad;
    @Basic(optional = false)
    @Column(name = "nombre",length=50)
    private String nombre;

    public Ciudad() {

    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
