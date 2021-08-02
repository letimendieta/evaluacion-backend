package py.una.fiuna.evaluacion.dto;

public class PreguntasGrupoFactorDto {

    Integer idpregunta;
    String factordescripcion;
    String grupo;
    String grupoevaluacion;
    String pregunta;
    Integer peso;

    public Integer getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public String getFactordescripcion() {
        return factordescripcion;
    }

    public void setFactordescripcion(String factordescripcion) {
        this.factordescripcion = factordescripcion;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupoevaluacion() {
        return grupoevaluacion;
    }

    public void setGrupoevaluacion(String grupoevaluacion) {
        this.grupoevaluacion = grupoevaluacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
