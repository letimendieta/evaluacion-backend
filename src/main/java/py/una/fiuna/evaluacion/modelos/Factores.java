package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="factores")
public class Factores implements Serializable {
    private static final long serialVersionID=1L;

    private int idfactor;
    private String descripcion;

    @Id
    @Column(name = "idfactor")
    public int getIdfactor() {
        return idfactor;
    }

    public void setIdfactor(int idfactor) {
        this.idfactor = idfactor;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idobservacion", referencedColumnName = "idobservacion")
    private Observaciones observaciones;

    public Observaciones getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(Observaciones observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factores factores = (Factores) o;
        return idfactor == factores.idfactor &&
                Objects.equals(descripcion, factores.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfactor, descripcion);
    }
}
