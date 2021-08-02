package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "grupos")
public class Grupos implements Serializable {
    private static final long serialVersionID=1L;

    private int idgrupo;
    private String descripcion;

    @Id
    @Column(name = "idgrupo")
    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupos grupos = (Grupos) o;
        return idgrupo == grupos.idgrupo &&
                Objects.equals(descripcion, grupos.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgrupo, descripcion);
    }
}
