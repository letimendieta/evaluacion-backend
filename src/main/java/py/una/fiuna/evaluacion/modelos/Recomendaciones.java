package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "recomendaciones")
public class Recomendaciones implements Serializable {
    private static final long serialVersionID=1L;
    private String accionmejora;
    private String accionpropuesta;
    private String observacion;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="recomendaciones_idrecomendacion_seq")
    @SequenceGenerator(name="recomendaciones_idrecomendacion_seq",sequenceName="recomendaciones_idrecomendacion_seq",allocationSize=1)
    private Integer idrecomendacion;

    @Basic
    @Column(name = "accionmejora")
    public String getAccionmejora() {
        return accionmejora;
    }

    public void setAccionmejora(String accionmejora) {
        this.accionmejora = accionmejora;
    }

    @Basic
    @Column(name = "accionpropuesta")
    public String getAccionpropuesta() {
        return accionpropuesta;
    }

    public void setAccionpropuesta(String accionpropuesta) {
        this.accionpropuesta = accionpropuesta;
    }

    @Basic
    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToOne
    @JoinColumn(name = "idevaluacion")
    private  Evaluaciones evaluaciones;

    public Evaluaciones getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(Evaluaciones evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    @PrePersist
    private void create() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private void update() {
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recomendaciones that = (Recomendaciones) o;
        return idrecomendacion == that.idrecomendacion &&
                Objects.equals(accionmejora, that.accionmejora) &&
                Objects.equals(accionpropuesta, that.accionpropuesta) &&
                Objects.equals(observacion, that.observacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrecomendacion, accionmejora, accionpropuesta, observacion);
    }
}
