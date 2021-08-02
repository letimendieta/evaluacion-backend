package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "puestos")
public class Puestos implements Serializable {
    private static final long serialVersionID=1L;

    private int idpuesto;
    private String codpuesto;
    private String puesto;

    @Id
    @Column(name = "idpuesto")
    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    @Basic
    @Column(name = "codpuesto")
    public String getCodpuesto() {
        return codpuesto;
    }

    public void setCodpuesto(String codpuesto) {
        this.codpuesto = codpuesto;
    }

    @Basic
    @Column(name = "puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puestos puestos = (Puestos) o;
        return idpuesto == puestos.idpuesto &&
                Objects.equals(codpuesto, puestos.codpuesto) &&
                Objects.equals(puesto, puestos.puesto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpuesto, codpuesto, puesto);
    }
}
