package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Integer idLocal;
    @Transient
    private Local local;
    
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Integer idCiudad;
    @Transient
    private Ciudad ciudad;
            
    @JoinColumn(name = "id_mapa", referencedColumnName = "id_mapa")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Integer idMapa;
    @Transient
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
    public Sucursal() {

    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }
}
