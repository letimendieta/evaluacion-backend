package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="escalaevaluacion")
public class Escalaevaluacion implements Serializable {
    private static final long serialVersionID=1L;

    private int idescalaevaluacion;
    private int valor;
    private String descripcion;
    private String observacion;
    private Boolean justificar;

    @Id
    @Column(name = "idescalaevaluacion")
    public int getIdescalaevaluacion() {
        return idescalaevaluacion;
    }

    public void setIdescalaevaluacion(int idescalaevaluacion) {
        this.idescalaevaluacion = idescalaevaluacion;
    }

    @Basic
    @Column(name = "valor")
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "justificar")
    public Boolean getJustificar() {
        return justificar;
    }

    public void setJustificar(Boolean justificar) {
        this.justificar = justificar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escalaevaluacion that = (Escalaevaluacion) o;
        return idescalaevaluacion == that.idescalaevaluacion &&
                valor == that.valor &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(observacion, that.observacion) &&
                Objects.equals(justificar, that.justificar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idescalaevaluacion, valor, descripcion, observacion, justificar);
    }
}
