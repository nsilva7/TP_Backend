package py.com.prueba.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import py.com.prueba.modelo.Sucursal;

@Entity
@Table(name="horario_excepcion")
public class HorarioExcepcion {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_horario_excepcion")
    private Integer idHorarioExcepcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora_apertura")
    @Temporal(TemporalType.TIME)
    private Date horaApertura;
    @Basic(optional = false)
    @Column(name = "hora_cierre")
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal idSucursal;

    public Integer getIdHorarioExcepcion() {
        return idHorarioExcepcion;
    }

    public void setIdHorarioExcepcion(Integer idHorarioExcepcion) {
        this.idHorarioExcepcion = idHorarioExcepcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    

}
