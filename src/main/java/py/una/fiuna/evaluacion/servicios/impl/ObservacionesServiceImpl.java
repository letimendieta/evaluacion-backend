package py.una.fiuna.evaluacion.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Observaciones;
import py.una.fiuna.evaluacion.repositorios.ObservacionesRepository;
import py.una.fiuna.evaluacion.servicios.ObservacionesService;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Service
@RequestScope
public class ObservacionesServiceImpl implements ObservacionesService {

    @Autowired
    ObservacionesRepository observacionesRepository;



    @Override
    public List<Observaciones> listar() throws EvaluacionException {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Observaciones obtener(int id) throws EvaluacionException {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public Observaciones guardar(Observaciones observaciones) throws EvaluacionException {
        return observacionesRepository.save(observaciones);
    }

    @Override
    public Observaciones actualizar(Observaciones observaciones) throws EvaluacionException {
        return null;
    }

    @Override
    public void eliminar(int id) throws EvaluacionException {

    }

    @Override
    public List<Observaciones> buscar(Date fromDate, Date toDate, Observaciones consulta, String orderBy, String orderDir, Pageable pageable) throws DataAccessException {
        return null;
    }
}

