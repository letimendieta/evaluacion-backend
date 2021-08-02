package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="escalacalifacion")
public class Escalacalifacion implements Serializable {
    private static final long serialVersionID=1L;

    private int idescalacalificacion;
    private int valor;
    private String descripcion;
    private String observacion;
    private int minimo;
    private int maximo;

    @Id
    @Column(name = "idescalacalificacion")
    public int getIdescalacalificacion() {
        return idescalacalificacion;
    }

    public void setIdescalacalificacion(int idescalacalificacion) {
        this.idescalacalificacion = idescalacalificacion;
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
    @Column(name = "minimo")
    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    @Basic
    @Column(name = "maximo")
    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escalacalifacion that = (Escalacalifacion) o;
        return idescalacalificacion == that.idescalacalificacion &&
                valor == that.valor &&
                minimo == that.minimo &&
                maximo == that.maximo &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(observacion, that.observacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idescalacalificacion, valor, descripcion, observacion, minimo, maximo);
    }
}
