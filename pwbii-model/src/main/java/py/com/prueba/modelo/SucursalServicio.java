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
import java.util.List;

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
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idSucursal")
    @JsonIdentityReference(alwaysAsId=true)
    private Sucursal sucursal;
    
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(fetch = FetchType.EAGER)
    private Servicio servicio;
    
    @OneToMany(mappedBy = "sucursalServicio",fetch = FetchType.EAGER)
    private List<PersonaSucursalServicio> personaSucursalServicioList;
    public SucursalServicio() {

    }

    public Integer getIdSucursalServicio() {
        return idSucursalServicio;
    }

    public void setIdSucursalServicio(Integer idSucursalServicio) {
        this.idSucursalServicio = idSucursalServicio;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

   


    
    

    
}
