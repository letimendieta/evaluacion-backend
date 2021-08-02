package py.una.fiuna.evaluacion.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.modelos.Escalaevaluacion;

import py.una.fiuna.evaluacion.repositorios.EscalaevaluacionRepository;
import py.una.fiuna.evaluacion.servicios.EscalaevaluacionService;
import py.una.fiuna.evaluacion.util.xml.ConsultaSQL;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequestScope
public class EscalaevaluacionServiceImpl implements EscalaevaluacionService {

    @Autowired
    DataSource dataSourceProperties;

    @Autowired
    private EscalaevaluacionRepository escalaevaluacionRepository;

    ConsultaSQL consultaSQL = new ConsultaSQL();

    private static final Logger logger = LoggerFactory.getLogger(Escalaevaluacion.class);


    @Transactional(readOnly = true)
    public List<Escalaevaluacion> getEscalaEvaluacion() throws SQLException {
        logger.info("----------Obteniendo Escala Evaluacion----------");

      return  escalaevaluacionRepository.findAll();
    }



}
