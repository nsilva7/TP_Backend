package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    @GeneratedValue(generator="personaSec")
    @SequenceGenerator(name="personaSec",sequenceName="persona_sec",allocationSize=0)
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "nombre",length=50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido",length=50)
    private String apellido;
    @Basic(optional = false)
    @Column(name = "numero_documento",length=50)
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "email",length=50)
    private String email;
    @Basic(optional = false)
    @Column(name = "usuario",length=50)
    private String usuario;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Basic(optional = false)
    @Column(name = "flag_empleado",length=1)
    private char flagEmpleado;
    
    @JoinColumn(name = "id_local", referencedColumnName = "id_local")
    @ManyToOne(fetch = FetchType.EAGER)
    private Local local;
    
    @OneToMany(mappedBy = "empleado",fetch = FetchType.EAGER)
    private Set<PersonaSucursalServicio> personaSucursalServicioList;
    
    @OneToMany(mappedBy = "persona",fetch = FetchType.EAGER)
    private Set<Agenda> agendaList;
    
    public Persona() {

    }
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(Set<Agenda> agendaList) {
        this.agendaList = agendaList;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getFlagEmpleado() {
        return flagEmpleado;
    }

    public void setFlagEmpleado(char flagEmpleado) {
        this.flagEmpleado = flagEmpleado;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Set<PersonaSucursalServicio> getPersonaSucursalServicioList() {
        return personaSucursalServicioList;
    }

    public void setPersonaSucursalServicioList(Set<PersonaSucursalServicio> personaSucursalServicioList) {
        this.personaSucursalServicioList = personaSucursalServicioList;
    }
    
}
