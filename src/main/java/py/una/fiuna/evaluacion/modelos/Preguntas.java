package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "preguntas")
public class Preguntas implements Serializable {
    private static final long serialVersionID=1L;

    private int idpregunta;
    private String pregunta;
    private int nroorden;
    private String tipo;
    private int seccion;

    @Id
    @Column(name = "idpregunta")
    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    @Basic
    @Column(name = "pregunta")
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Basic
    @Column(name = "nroorden")
    public int getNroorden() {
        return nroorden;
    }

    public void setNroorden(int nroorden) {
        this.nroorden = nroorden;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "seccion")
    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idrespuesta", referencedColumnName = "idrespuesta")
    private Respuestas respuestas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preguntas preguntas = (Preguntas) o;
        return idpregunta == preguntas.idpregunta &&
                nroorden == preguntas.nroorden &&
                seccion == preguntas.seccion &&
                Objects.equals(pregunta, preguntas.pregunta) &&
                Objects.equals(tipo, preguntas.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpregunta, pregunta, nroorden, tipo, seccion);
    }
}
