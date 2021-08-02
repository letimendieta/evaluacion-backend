package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "periodos")
public class Periodos implements Serializable {
    private static final long serialVersionID=1L;

    private int anho;
    private int semestre;
    private String descripcion;
    private Timestamp fechainicio;
    private Timestamp fechafin;
    private String estado;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="periodos_idperiodo_seq")
    @SequenceGenerator(name="periodos_idperiodo_seq",sequenceName="periodos_idperiodo_seq",allocationSize=1)
    private Integer idperiodo;


    public Integer getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    @Basic
    @Column(name = "anho")
    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Basic
    @Column(name = "semestre")
    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
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
    @Column(name = "fechainicio")
    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Basic
    @Column(name = "fechafin")
    public Timestamp getFechafin() {
        return fechafin;
    }

    public void setFechafin(Timestamp fechafin) {
        this.fechafin = fechafin;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

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
        Periodos periodos = (Periodos) o;
        return idperiodo == periodos.idperiodo &&
                anho == periodos.anho &&
                semestre == periodos.semestre &&
                Objects.equals(descripcion, periodos.descripcion) &&
                Objects.equals(fechainicio, periodos.fechainicio) &&
                Objects.equals(fechafin, periodos.fechafin) &&
                Objects.equals(estado, periodos.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idperiodo, anho, semestre, descripcion, fechainicio, fechafin, estado);
    }
}
