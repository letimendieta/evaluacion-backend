package py.una.fiuna.evaluacion.servicios;

import org.springframework.dao.DataAccessException;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Respuestas;

import java.awt.print.Pageable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RespuestaService {

    Map<String,String> guardarRespuestas(List<Respuestas> respuestaList) throws SQLException;


    public List<Respuestas> listar() throws EvaluacionException;

    public int count();

    public Respuestas obtener(int id) throws EvaluacionException;

    public Respuestas guardar(Respuestas respuestas) throws EvaluacionException;

    public Respuestas actualizar(Respuestas respuestas) throws EvaluacionException;

    public void eliminar(int id) throws EvaluacionException;

    public List<Respuestas> buscar(Date fromDate, Date toDate, Respuestas consulta,
                                   String orderBy, String orderDir, Pageable pageable) throws DataAccessException;

   /* public List<ConsultasResult> buscarConsultas(Date fromDate, Date toDate, Consultas consulta,
                                                 String orderBy, String orderDir, Pageable pageable) throws DataAccessException;
*/
}
