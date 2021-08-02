package py.una.fiuna.evaluacion.servicios;


import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Periodos;

public interface PeriodosService {


    public Periodos obtener(int id) throws EvaluacionException;

    public Periodos guardar(Periodos periodo) throws EvaluacionException;

    public Periodos actualizar(Periodos periodo) throws EvaluacionException;

    public void eliminar(int id) throws EvaluacionException;


}
