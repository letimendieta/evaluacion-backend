package py.una.fiuna.evaluacion.servicios;

import py.una.fiuna.evaluacion.modelos.Escalaevaluacion;

import java.sql.SQLException;
import java.util.List;

public interface EscalaevaluacionService {

    public List<Escalaevaluacion> getEscalaEvaluacion() throws SQLException;
}
