package py.una.fiuna.evaluacion.servicios;

import org.springframework.dao.DataAccessException;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Observaciones;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface ObservacionesService {


    public List<Observaciones> listar() throws EvaluacionException;

    public int count();

    public Observaciones obtener(int id) throws EvaluacionException;

    public Observaciones guardar(Observaciones observaciones) throws EvaluacionException;

    public Observaciones actualizar(Observaciones observaciones) throws EvaluacionException;

    public void eliminar(int id) throws EvaluacionException;

    public List<Observaciones> buscar(Date fromDate, Date toDate, Observaciones consulta,
                                      String orderBy, String orderDir, Pageable pageable) throws DataAccessException;

   /* public List<ConsultasResult> buscarConsultas(Date fromDate, Date toDate, Consultas consulta,
                                                 String orderBy, String orderDir, Pageable pageable) throws DataAccessException;
*/
}
