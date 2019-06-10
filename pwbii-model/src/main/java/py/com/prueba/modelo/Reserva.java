package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Reserva {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reserva")
    @GeneratedValue(generator="reservaSec")
    @SequenceGenerator(name="reservaSec",sequenceName="reserva_sec",allocationSize=0)
    private Integer idReserva;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_inicio")
    private Date horaInicio;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_fin")
    private Date horaFin;
    
    @JoinColumn(name = "id_sucursal_servicio", referencedColumnName = "id_sucursal_servicio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private SucursalServicio sucursalServicio;  
    
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Persona empleado;  
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Persona cliente; 
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_hora_creacion")
    private Date fechaHoraCreacion;
    
    @Basic(optional = false)
    @Column(name = "flag_estado",length=1)
    private char flagEstado;
    
    @Basic(optional = false)
    @Column(name = "flag_asistido",length=1)
    private char flagAsistido;
    
    @Basic(optional = false)
    @Column(name = "observacion",length=200)
    private String observacion;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public SucursalServicio getSucursalServicio() {
        return sucursalServicio;
    }

    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    public Persona getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Persona persona) {
        this.empleado = persona;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public char getFlagEstado() {
        return flagEstado;
    }

    public void setFlagEstado(char flagEstado) {
        this.flagEstado = flagEstado;
    }

    public char getFlagAsistido() {
        return flagAsistido;
    }

    public void setFlagAsistido(char flagAsistido) {
        this.flagAsistido = flagAsistido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
