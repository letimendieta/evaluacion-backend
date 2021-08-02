package py.una.fiuna.evaluacion.servicios;

import org.springframework.data.domain.Pageable;
import py.una.fiuna.evaluacion.modelos.Escalacalifacion;
import py.una.fiuna.evaluacion.modelos.Personas;

import java.util.List;

public interface EscalacalificacionService {

    public List<Escalacalifacion> findAll();
}
