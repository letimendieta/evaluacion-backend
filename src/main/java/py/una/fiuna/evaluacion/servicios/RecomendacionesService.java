package py.una.fiuna.evaluacion.servicios;

import org.springframework.dao.DataAccessException;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Recomendaciones;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface RecomendacionesService {


    public List<Recomendaciones> listar() throws EvaluacionException;

    public int count();

    public Recomendaciones obtener(int id) throws EvaluacionException;

    public Recomendaciones guardar(Recomendaciones recomendaciones) throws EvaluacionException;

    public Recomendaciones actualizar(Recomendaciones recomendaciones) throws EvaluacionException;

    public void eliminar(int id) throws EvaluacionException;

    public List<Recomendaciones> buscar(Date fromDate, Date toDate, Recomendaciones recomendaciones,
                                        String orderBy, String orderDir, Pageable pageable) throws DataAccessException;

   /* public List<ConsultasResult> buscarConsultas(Date fromDate, Date toDate, Consultas consulta,
                                                 String orderBy, String orderDir, Pageable pageable) throws DataAccessException;
*/
}
