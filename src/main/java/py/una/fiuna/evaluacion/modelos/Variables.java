package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "variables")
public class Variables implements Serializable {
    private static final long serialVersionID=1L;


    private int idvariable;
    private String descripcion;
    private int peso;

    @Id
    @Column(name = "idvariable")
    public int getIdvariable() {
        return idvariable;
    }

    public void setIdvariable(int idvariable) {
        this.idvariable = idvariable;
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
    @Column(name = "peso")
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variables variables = (Variables) o;
        return idvariable == variables.idvariable &&
                peso == variables.peso &&
                Objects.equals(descripcion, variables.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvariable, descripcion, peso);
    }
}
