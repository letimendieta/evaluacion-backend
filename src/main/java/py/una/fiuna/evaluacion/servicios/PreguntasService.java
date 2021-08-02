package py.una.fiuna.evaluacion.servicios;

import org.springframework.data.domain.Pageable;

import py.una.fiuna.evaluacion.dto.PreguntasGrupoFactorDto;
import py.una.fiuna.evaluacion.modelos.Preguntas;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PreguntasService {
    public List<Preguntas> getAllPreguntas(Pageable pageable);
    public List<PreguntasGrupoFactorDto> getPreguntasBygrupoAndfactor(Integer idgrupo, Integer idfactor) throws SQLException;
    public void deletePreguntas(int idpreguntas);
    public String createPreguntas(Preguntas preguntas);
    public String updatePreguntas(Preguntas preguntas);
    public String verPreguntasporGrupo(String idgrupo) throws SQLException;

}
