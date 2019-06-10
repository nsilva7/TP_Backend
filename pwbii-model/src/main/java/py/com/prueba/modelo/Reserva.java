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
    private Time horaFin;
    
    @JoinColumn(name = "id_sucursal_servicio", referencedColumnName = "id_sucursal_servicio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private SucursalServicio sucursalServicio;  
    
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Persona idPersona;  
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Persona idCliente; 
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_hora_creacion")
    private Date fechaHoraCreacion;
    
    @Basic(optional = false)
    @Column(name = "flag_estado",length=1)
    private char flasEstado;
    
    @Basic(optional = false)
    @Column(name = "flag_asistido",length=1)
    private char flasAsistido;
    
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

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public SucursalServicio getSucursalServicio() {
        return sucursalServicio;
    }

    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Persona idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public char getFlasEstado() {
        return flasEstado;
    }

    public void setFlasEstado(char flasEstado) {
        this.flasEstado = flasEstado;
    }

    public char getFlasAsistido() {
        return flasAsistido;
    }

    public void setFlasAsistido(char flasAsistido) {
        this.flasAsistido = flasAsistido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
