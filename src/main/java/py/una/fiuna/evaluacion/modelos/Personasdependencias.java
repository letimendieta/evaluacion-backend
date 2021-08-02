package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "personasdependencias")
public class Personasdependencias implements Serializable {
    private static final long serialVersionID=1L;

    private int idpersonadependencia;
    private String cargo;
    private int antiguedad;
    private int nivelpuesto;
    private Date fechaingreso;
    private Date fechasalida;

    @Id
    @Column(name = "idpersonadependencia")
    public int getIdpersonadependencia() {
        return idpersonadependencia;
    }

    public void setIdpersonadependencia(int idpersonadependencia) {
        this.idpersonadependencia = idpersonadependencia;
    }

    @Basic
    @Column(name = "cargo")
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Basic
    @Column(name = "antiguedad")
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Basic
    @Column(name = "nivelpuesto")
    public int getNivelpuesto() {
        return nivelpuesto;
    }

    public void setNivelpuesto(int nivelpuesto) {
        this.nivelpuesto = nivelpuesto;
    }

    @Basic
    @Column(name = "fechaingreso")
    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    @Basic
    @Column(name = "fechasalida")
    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personasdependencias that = (Personasdependencias) o;
        return idpersonadependencia == that.idpersonadependencia &&
                antiguedad == that.antiguedad &&
                nivelpuesto == that.nivelpuesto &&
                Objects.equals(cargo, that.cargo) &&
                Objects.equals(fechaingreso, that.fechaingreso) &&
                Objects.equals(fechasalida, that.fechasalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpersonadependencia, cargo, antiguedad, nivelpuesto, fechaingreso, fechasalida);
    }
}
