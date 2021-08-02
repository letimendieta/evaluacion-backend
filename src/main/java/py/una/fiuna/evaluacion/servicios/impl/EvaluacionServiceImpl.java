package py.una.fiuna.evaluacion.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Evaluaciones;
import py.una.fiuna.evaluacion.repositorios.EvaluacionRepository;
import py.una.fiuna.evaluacion.servicios.EvaluacionService;

import org.springframework.transaction.annotation.Transactional;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;


    public EvaluacionServiceImpl() {
    }

    public EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Evaluaciones> listar() throws EvaluacionException {
        return (List<Evaluaciones>) evaluacionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public int count() {
        return (int) evaluacionRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Evaluaciones obtener(int id) throws EvaluacionException {
        return evaluacionRepository.findById(id).orElse(null);
    }

    @Override
    public Evaluaciones guardar(Evaluaciones evaluacion) throws EvaluacionException {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    @Transactional
    public Evaluaciones actualizar(Evaluaciones evaluacion) throws EvaluacionException {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    @Transactional
    public void eliminar(int id) throws EvaluacionException {
        evaluacionRepository.deleteById(id);
    }

    @Override
    public List<Evaluaciones> buscar(Date fromDate, Date toDate, Evaluaciones consulta, String orderBy, String orderDir, Pageable pageable) throws DataAccessException {
        return null;
    }
}
