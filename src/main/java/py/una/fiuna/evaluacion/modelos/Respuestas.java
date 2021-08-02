package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "respuestas")
public class Respuestas implements Serializable {
    private static final long serialVersionID=1L;


    private String observacion;
    private BigDecimal notaporcentaje;
    private BigDecimal notaponderada;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="recomendaciones_idevaluacion_seq")
    @SequenceGenerator(name="recomendaciones_idevaluacion_seq",sequenceName="recomendaciones_idevaluacion_seq",allocationSize=1)
    private Integer idrespuesta;

    public void setIdrespuesta(int idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    @Basic
    @Column(name = "respuesta")
    private int respuesta;
    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
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
    @Column(name = "notaporcentaje")
    public BigDecimal getNotaporcentaje() {
        return notaporcentaje;
    }

    public void setNotaporcentaje(BigDecimal notaporcentaje) {
        this.notaporcentaje = notaporcentaje;
    }

    @Basic
    @Column(name = "notaponderada")
    public BigDecimal getNotaponderada() {
        return notaponderada;
    }

    public void setNotaponderada(BigDecimal notaponderada) {
        this.notaponderada = notaponderada;
    }

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToOne
    @JoinColumn(name = "idevaluacion")
    private  Evaluaciones evaluaciones;

    @OneToOne
    @JoinColumn(name = "idpregunta")
    private  Preguntas preguntas;

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

    public Preguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Respuestas respuesta1 = (Respuestas) o;
        return idrespuesta == respuesta1.idrespuesta &&
                respuesta == respuesta1.respuesta &&
                Objects.equals(observacion, respuesta1.observacion) &&
                Objects.equals(notaporcentaje, respuesta1.notaporcentaje) &&
                Objects.equals(notaponderada, respuesta1.notaponderada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrespuesta, respuesta, observacion, notaporcentaje, notaponderada);
    }
}

