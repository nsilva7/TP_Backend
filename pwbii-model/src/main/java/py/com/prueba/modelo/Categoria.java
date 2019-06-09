package py.com.prueba.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer id_categoria;
    @Basic(optional = false)
    @Column(name = "nombre",length=50)
    private String nombre;

    @ManyToMany(mappedBy = "localCategorias")
    Set<Local> localCategorias;
    public Categoria() {

    }

    public Integer getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.id_categoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
