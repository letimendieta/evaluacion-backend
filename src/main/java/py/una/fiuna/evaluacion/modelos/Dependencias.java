package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="dependencias")
public class Dependencias implements Serializable {

    private static final long serialVersionID=1L;


    private Long iddependencia;
    private String descripcion;
    private String telefono;

    @Id
    @Column(name = "iddependencia")
    public Long getIddependencia() {
        return iddependencia;
    }

    public void setIddependencia(Long iddependencia) {
        this.iddependencia = iddependencia;
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
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependencias that = (Dependencias) o;
        return iddependencia == that.iddependencia &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddependencia, descripcion, telefono);
    }


}
