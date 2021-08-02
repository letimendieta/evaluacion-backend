package py.una.fiuna.evaluacion.servicios;


import py.una.fiuna.evaluacion.modelos.Factores;

import java.sql.SQLException;
import java.util.List;

public interface FactoresService {

    public List<Factores> getFactoresByGrupo(int idgrupoevaluacion) throws SQLException;

}
