package py.una.fiuna.evaluacion.servicios;

import java.sql.SQLException;
import java.util.Map;

public interface GruposService {
    public Map<String,Object> getGrupoById(Integer grupo) throws SQLException;
}
