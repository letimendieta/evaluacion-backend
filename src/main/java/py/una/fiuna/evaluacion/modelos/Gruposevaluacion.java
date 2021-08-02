package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "gruposevaluacion")
public class Gruposevaluacion implements Serializable {
    private static final long serialVersionID=1L;

    private int idgrupoevaluacion;
    private String descripcion;

    @Id
    @Column(name = "idgrupoevaluacion")
    public int getIdgrupoevaluacion() {
        return idgrupoevaluacion;
    }

    public void setIdgrupoevaluacion(int idgrupoevaluacion) {
        this.idgrupoevaluacion = idgrupoevaluacion;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(mappedBy = "gruposevaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluaciones> evaluacionesList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gruposevaluacion that = (Gruposevaluacion) o;
        return idgrupoevaluacion == that.idgrupoevaluacion &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgrupoevaluacion, descripcion);
    }
}
