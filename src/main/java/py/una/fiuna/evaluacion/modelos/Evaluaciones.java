package py.una.fiuna.evaluacion.modelos;

import org.apache.regexp.RE;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "evaluaciones")
public class Evaluaciones  implements Serializable {
    private static final long serialVersionID=1L;


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="evaluaciones_idevaluacion_seq")
    @SequenceGenerator(name="evaluaciones_idevaluacion_seq",sequenceName="evaluaciones_idevaluacion_seq",allocationSize=1)
    private Integer idevaluacion;

    @Column(name = "calificacion")
    private BigDecimal calificacion;

    @Column(name = "finalizado")
    private String finalizado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne
  @JoinColumn(name = "idevaluador")
  private  Personas personas;

    @ManyToOne
    @JoinColumn(name = "idevaluado")
    private  Personas personasp;

    @ManyToOne
    @JoinColumn(name = "idgrupoevaluacion")
    private  Gruposevaluacion gruposevaluacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idrecomendacion", referencedColumnName = "idrecomendacion")
    private Recomendaciones recomendaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idrespuesta", referencedColumnName = "idrespuesta")
    private Respuestas respuestas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idobservacion", referencedColumnName = "idobservacion")
    private Observaciones observaciones;


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
        Evaluaciones that = (Evaluaciones) o;
        return idevaluacion == that.idevaluacion &&
                Objects.equals(calificacion, that.calificacion) &&
                Objects.equals(finalizado, that.finalizado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idevaluacion, calificacion, finalizado);
    }


    public Integer getIdevaluacion() {
        return idevaluacion;
    }

    public void setIdevaluacion(Integer idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

   public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Personas getPersonasp() {
        return personasp;
    }

    public void setPersonasp(Personas personasp) {
        this.personasp = personasp;
    }

    public Gruposevaluacion getGruposevaluacion() {
        return gruposevaluacion;
    }

    public void setGruposevaluacion(Gruposevaluacion gruposevaluacion) {
        this.gruposevaluacion = gruposevaluacion;
    }

    public Recomendaciones getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(Recomendaciones recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public Respuestas getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Respuestas respuestas) {
        this.respuestas = respuestas;
    }

    public Observaciones getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(Observaciones observaciones) {
        this.observaciones = observaciones;
    }
}
