package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="sucursal_servicio")
public class SucursalServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sucursal_servicio")
    @GeneratedValue(generator="surcursalServicioSec")
    @SequenceGenerator(name="surcursalServicioSec",sequenceName="sucursal_servicio_sec",allocationSize=0)
    private Integer idSucursalServicio;
    
    @Basic(optional = false)
    @Column(name = "duracion")
    private Integer duracion;
    
    @Basic(optional = false)
    @Column(name = "precio",precision=10, scale=2)
    private BigInteger precio;
    
    @Basic(optional = false)
    @Column(name = "capacidad")
    private Integer capacidad;
    
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Sucursal sucursal;
    
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Servicio servicio;
    
    public SucursalServicio() {

    }

    public Integer getIdSucursalServicio() {
        return idSucursalServicio;
    }

    public void setIdSucursalServicio(Integer idSucursalServicio) {
        this.idSucursalServicio = idSucursalServicio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }


    
    

    
}
