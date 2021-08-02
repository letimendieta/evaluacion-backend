package py.una.fiuna.evaluacion.servicios;

import org.springframework.dao.DataAccessException;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Evaluaciones;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface EvaluacionService {

    public List<Evaluaciones> listar() throws EvaluacionException;

    public int count();

    public Evaluaciones obtener(int id) throws EvaluacionException;

    public Evaluaciones guardar(Evaluaciones consulta) throws EvaluacionException;

    public Evaluaciones actualizar(Evaluaciones consulta) throws EvaluacionException;

    public void eliminar(int id) throws EvaluacionException;

    public List<Evaluaciones> buscar(Date fromDate, Date toDate, Evaluaciones consulta,
                                  String orderBy, String orderDir, Pageable pageable) throws DataAccessException;

   /* public List<ConsultasResult> buscarConsultas(Date fromDate, Date toDate, Consultas consulta,
                                                 String orderBy, String orderDir, Pageable pageable) throws DataAccessException;
*/
}
