package py.una.fiuna.evaluacion.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.modelos.Escalacalifacion;
import py.una.fiuna.evaluacion.modelos.Personas;
import py.una.fiuna.evaluacion.repositorios.EscalacalificacionRepository;
import py.una.fiuna.evaluacion.repositorios.PersonasRepository;
import py.una.fiuna.evaluacion.servicios.EscalacalificacionService;

import java.util.List;

@Service
@RequestScope
public class EscalacalificacionServiceImpl implements EscalacalificacionService {
    @Autowired
    private EscalacalificacionRepository escalacalificacionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Escalacalifacion> findAll() {
        return (List<Escalacalifacion>) escalacalificacionRepository.findAll();
    }

}
