package py.una.fiuna.evaluacion.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import py.una.fiuna.evaluacion.dto.PersonasDto;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Respuestas;
import py.una.fiuna.evaluacion.repositorios.RespuestaRepository;
import py.una.fiuna.evaluacion.servicios.RespuestaService;
import py.una.fiuna.evaluacion.util.xml.ConsultaSQL;

import javax.sql.DataSource;
import java.awt.print.Pageable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
@RequestScope
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    DataSource dataSourceProperties;

    ConsultaSQL consultaSQL = new ConsultaSQL();

    private static final Logger logger = LoggerFactory.getLogger(Respuestas.class);
    @Override
    public Map<String, String> guardarRespuestas(List<Respuestas> respuestaList) throws SQLException {
        Map<String, String> resultado= new HashMap<>();
        String insertar = "";
        for (int i = 0; i < respuestaList.size(); i++) {
            insertar = insertar +  "(nextval('respuesta_idrespuesta_seq')," + respuestaList.get(i).getEvaluaciones().getIdevaluacion() +
                    ","+respuestaList.get(i).getPreguntas().getIdpregunta()+
                    "," + respuestaList.get(i).getRespuesta()+
                    ",'"+respuestaList.get(i).getObservacion().trim()
                    +"',"+respuestaList.get(i).getNotaporcentaje()+
                    ","+ respuestaList.get(i).getNotaponderada()+",now(),now()) ";

            if(i==respuestaList.size()-1){
                insertar = insertar + ";";
            }else{
                insertar = insertar + ",";
            }

        }



        logger.info("----------Obteniendo personas vinculo laboral----------");
        logger.info(insertar);
        Connection con = dataSourceProperties.getConnection();
        PreparedStatement p = null;

        try {
            String sql = "INSERT INTO public.respuestas(\n" +
                    "            idrespuesta,idevaluacion, idpregunta, respuesta, observacion, \n" +
                    "            notaporcentaje, notaponderada,fecha_creacion,fecha_modificacion)\n" +
                    "    VALUES" + insertar;
            logger.info(sql);

            con = dataSourceProperties.getConnection();
            con.setAutoCommit(false);
            p = con.prepareStatement(sql);


            p.executeUpdate();
            con.commit();

            resultado.put("mensaje", "Registrado correctamente!");



        } catch (SQLException e) {

            logger.info("Error insercion respuesta " + e.getMessage());

            resultado.put("mensaje", "Error.");
        } finally {
            con.close();
        }

        return resultado;
    }

    @Override
    public List<Respuestas> listar() throws EvaluacionException {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Respuestas obtener(int id) throws EvaluacionException {
        return null;
    }

    @Override
    public Respuestas guardar(Respuestas respuestas) throws EvaluacionException {
        return null;
    }

    @Override
    public Respuestas actualizar(Respuestas respuestas) throws EvaluacionException {
        return null;
    }

    @Override
    public void eliminar(int id) throws EvaluacionException {

    }

    @Override
    public List<Respuestas> buscar(Date fromDate, Date toDate, Respuestas consulta, String orderBy, String orderDir, Pageable pageable) throws DataAccessException {
        return null;
    }
}
