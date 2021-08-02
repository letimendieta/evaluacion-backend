package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "observaciones")
public class Observaciones implements Serializable {
    private static final long serialVersionID=1L;


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="observaciones_idobservacion_seq")
    @SequenceGenerator(name="observaciones_idobservacion_seq",sequenceName="observaciones_idobservacion_seq",allocationSize=1)
    private Integer idobservacion;



    @Basic
    @Column(name = "observacion")
    private String observacion;

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

    @OneToOne
    @JoinColumn(name = "idfactor")
    private  Factores factores;



    @PrePersist
    private void create() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private void update() {
        this.fechaModificacion = LocalDateTime.now();
    }


    public Evaluaciones getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(Evaluaciones evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Factores getFactores() {
        return factores;
    }

    public void setFactores(Factores factores) {
        this.factores = factores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observaciones that = (Observaciones) o;
        return idobservacion == that.idobservacion &&
                Objects.equals(observacion, that.observacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idobservacion, observacion);
    }

}
