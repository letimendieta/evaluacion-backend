package py.una.fiuna.evaluacion.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.dto.PreguntasGrupoFactorDto;
import py.una.fiuna.evaluacion.modelos.Grupos;
import py.una.fiuna.evaluacion.modelos.Preguntas;

import py.una.fiuna.evaluacion.repositorios.PreguntasRepository;
import py.una.fiuna.evaluacion.repositorios.impl.EvaluacionRepositoryImpl;
import py.una.fiuna.evaluacion.servicios.PreguntasService;
import py.una.fiuna.evaluacion.util.ApplicationContextProvider;
import py.una.fiuna.evaluacion.util.xml.ConsultaSQL;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequestScope
public class PreguntasServiceImpl implements PreguntasService {

    @Autowired
    private PreguntasRepository preguntasRepository;

    @Autowired
    DataSource dataSourceProperties;

    ConsultaSQL consultaSQL = new ConsultaSQL();

    private static final Logger logger = LoggerFactory.getLogger(Grupos.class);



    @Override
    @Transactional(readOnly = true)
    public List<Preguntas> getAllPreguntas(Pageable pageable) {
        return (List<Preguntas>) preguntasRepository.findAll();
    }

    @Override
    public List<PreguntasGrupoFactorDto> getPreguntasBygrupoAndfactor(Integer idgrupo, Integer idfactor) throws SQLException {
        logger.info("----------Obteniendo Grupo de evaluacion----------");
        Connection con = dataSourceProperties.getConnection();
        String sql = " select f.descripcion as factordescripcion , g1.descripcion as grupo, g2.descripcion as grupoevaluacion, p.pregunta,p.peso,p.idpregunta from\n" +
                "                grupos g1\n" +
                "                join gruposevaluacion g2 on g1.idgrupo=g2.idgrupo\n" +
                "                join factores f on g2.idgrupoevaluacion=f.idgrupoevaluacion\n" +
                "                join variables v on f.idfactor=v.idfactor\n" +
                "                join preguntas p on v.idvariable=p.idvariable\n" +
                "                where g1.idgrupo=? and f.idfactor=?\n" +
                "                order by p.nroorden asc";
        PreparedStatement preparedStatement = con.prepareStatement(sql);


        preparedStatement.setInt(1, idgrupo);
        preparedStatement.setInt(2,idfactor);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<PreguntasGrupoFactorDto> preguntasGrupoFactorDtoList = new ArrayList<>();
        PreguntasGrupoFactorDto preguntasGrupoFactorDto;
        while (resultSet.next()){
            preguntasGrupoFactorDto = new PreguntasGrupoFactorDto();
            preguntasGrupoFactorDto.setFactordescripcion(resultSet.getString("factordescripcion"));
            preguntasGrupoFactorDto.setGrupo(resultSet.getString("grupo"));
            preguntasGrupoFactorDto.setGrupoevaluacion(resultSet.getString("grupoevaluacion"));
            preguntasGrupoFactorDto.setPregunta(resultSet.getString("pregunta"));
            preguntasGrupoFactorDto.setPeso(resultSet.getInt("peso"));
            preguntasGrupoFactorDto.setIdpregunta(resultSet.getInt("idpregunta"));

            preguntasGrupoFactorDtoList.add(preguntasGrupoFactorDto);

        }

        return preguntasGrupoFactorDtoList;

    }


    @Override
    public void deletePreguntas(int idpreguntas) {
        preguntasRepository.deleteById((long) idpreguntas);

    }

    @Override
    public String createPreguntas(Preguntas preguntas) {

        preguntasRepository.save(preguntas);
        return "creado";
    }

    @Override
    public String updatePreguntas(Preguntas preguntas) {
        preguntasRepository.save(preguntas);
        return "modificado";
    }

    @Override
    public String verPreguntasporGrupo(String idgrupo) throws SQLException {
        String dataSourceName = EvaluacionRepositoryImpl.EVALUACION_DS ;
      /*  String sql = ConsultaSQL
        DataSource ds = (DataSource) ApplicationContextProvider.
                getApplicationContext().getBean("evaluacionDS");
        Connection c = ds.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(" ");
*/


        return dataSourceName;

          }


}
