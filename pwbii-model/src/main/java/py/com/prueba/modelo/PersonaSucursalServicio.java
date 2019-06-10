package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="persona_sucursal_servicio")
public class PersonaSucursalServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona_sucursal_servicio")
    @GeneratedValue(generator="personaSucursalServicioSec")
    @SequenceGenerator(name="personaSucursalServicioSec",sequenceName="persona_sucursal_servicio_sec",allocationSize=0)
    private Integer idSucursalServicio;
    
    @Basic(optional = false)
    @Column(name = "precio",precision=10, scale=2)
    private BigInteger precio;
    
    @JoinColumn(name = "id_sucursal_servicio", referencedColumnName = "id_sucursal_servicio")
    @ManyToOne(fetch = FetchType.EAGER)
    private SucursalServicio sucursalServicio;
    
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona empleado;
    
    public PersonaSucursalServicio() {

    }

    public Integer getIdSucursalServicio() {
        return idSucursalServicio;
    }

    public void setIdSucursalServicio(Integer idSucursalServicio) {
        this.idSucursalServicio = idSucursalServicio;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    public void setPersona(Persona persona) {
        this.empleado = persona;
    }

   

   


    
    

    
}
