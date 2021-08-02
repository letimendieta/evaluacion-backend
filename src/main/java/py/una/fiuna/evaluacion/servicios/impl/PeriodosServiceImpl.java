package py.una.fiuna.evaluacion.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Evaluaciones;
import py.una.fiuna.evaluacion.modelos.Periodos;
import py.una.fiuna.evaluacion.repositorios.EvaluacionRepository;
import py.una.fiuna.evaluacion.repositorios.PeriodosRepository;
import py.una.fiuna.evaluacion.servicios.PeriodosService;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Service
public class PeriodosServiceImpl implements PeriodosService {

    @Autowired
    private PeriodosRepository periodosRepository;


    public PeriodosServiceImpl() {
    }

    public PeriodosServiceImpl(PeriodosRepository periodosRepository) {
        this.periodosRepository = periodosRepository;
    }



    @Override
    @Transactional(readOnly = true)
    public Periodos obtener(int id) throws EvaluacionException {
        return periodosRepository.findById((long) id).orElse(null);
    }

    @Override
    public Periodos guardar(Periodos periodo) throws EvaluacionException {
        return periodosRepository.save(periodo);
    }

    @Override
    @Transactional
    public Periodos actualizar(Periodos periodo) throws EvaluacionException {
        return periodosRepository.save(periodo);
    }

    @Override
    @Transactional
    public void eliminar(int id) throws EvaluacionException {
        periodosRepository.deleteById((long) id);
    }

}
