package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="agenda")
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_agenda")
    @GeneratedValue(generator="agendaSec")
    @SequenceGenerator(name="agendaSec",sequenceName="agenda_sec",allocationSize=0)
    private Integer idAgenda;
    @Basic(optional = false)
    @Column(name = "actividad",length=200)
    private String actividad;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Integer idPersona;

    @Transient
    private Persona persona;
    public Agenda() {

    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
