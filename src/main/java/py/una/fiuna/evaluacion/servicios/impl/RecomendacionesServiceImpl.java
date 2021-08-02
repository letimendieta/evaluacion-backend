package py.una.fiuna.evaluacion.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Recomendaciones;
import py.una.fiuna.evaluacion.repositorios.RecomendacionesRepository;
import py.una.fiuna.evaluacion.servicios.RecomendacionesService;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Service
@RequestScope
public class RecomendacionesServiceImpl implements RecomendacionesService {

    @Autowired
    RecomendacionesRepository recomendacionesRepository;

    @Override
    public List<Recomendaciones> listar() throws EvaluacionException {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Recomendaciones obtener(int id) throws EvaluacionException {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public Recomendaciones guardar(Recomendaciones recomendaciones) throws EvaluacionException {
        return recomendacionesRepository.save(recomendaciones);
    }

    @Override
    public Recomendaciones actualizar(Recomendaciones recomendaciones) throws EvaluacionException {
        return null;
    }

    @Override
    public void eliminar(int id) throws EvaluacionException {

    }

    @Override
    public List<Recomendaciones> buscar(Date fromDate, Date toDate, Recomendaciones recomendaciones, String orderBy, String orderDir, Pageable pageable) throws DataAccessException {
        return null;
    }
}