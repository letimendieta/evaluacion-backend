package py.una.fiuna.evaluacion.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.modelos.Escalaevaluacion;
import py.una.fiuna.evaluacion.modelos.Factores;
import py.una.fiuna.evaluacion.repositorios.FactoresRepository;
import py.una.fiuna.evaluacion.servicios.FactoresService;
import py.una.fiuna.evaluacion.util.xml.ConsultaSQL;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
@RequestScope
public class FactoresServiceImpl implements FactoresService {
    @Autowired
    DataSource dataSourceProperties;

    @Autowired
    private FactoresRepository factoresRepository;

    ConsultaSQL consultaSQL = new ConsultaSQL();

    private static final Logger logger = LoggerFactory.getLogger(Escalaevaluacion.class);




    @Transactional(readOnly = true)
    @Override
    public List<Factores> getFactoresByGrupo(int idgrupoevaluacion) throws SQLException {
        logger.info("----------Obteniendo Escala Evaluacion----------");

        return null;
    }
}
