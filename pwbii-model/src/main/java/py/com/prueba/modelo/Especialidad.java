package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="especialidad")
public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    @GeneratedValue(generator="especialidadSec")
    @SequenceGenerator(name="especialidadSec",sequenceName="especialidad_sec",allocationSize=0)
    private Integer idEspecialidad;
    @Basic(optional = false)
    @Column(name = "nombre",length=50,unique=true)
    private String nombre;
    
    @OneToMany(mappedBy = "especialidad",fetch = FetchType.EAGER)
    private List<Servicio> servicioList;

    public Especialidad() {

    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }
    
    
    
}