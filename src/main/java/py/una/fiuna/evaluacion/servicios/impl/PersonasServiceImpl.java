package py.una.fiuna.evaluacion.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.una.fiuna.evaluacion.config.JpaConfig;
import py.una.fiuna.evaluacion.dto.PersonasDto;
import py.una.fiuna.evaluacion.modelos.Personas;
import py.una.fiuna.evaluacion.repositorios.PersonasRepository;
import py.una.fiuna.evaluacion.servicios.PersonasService;

import org.springframework.data.domain.Pageable;
import py.una.fiuna.evaluacion.util.xml.ConsultaSQL;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasServiceImpl implements PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Autowired
    JpaConfig jpaConfig;

    ConsultaSQL consultaSQL = new ConsultaSQL();

    private static final Logger logger = LoggerFactory.getLogger(PersonasDto.class);

    @Override
    @Transactional(readOnly = true)
    public List<Personas> findAll(Pageable pageable) {
        return (List<Personas>) personasRepository.findAll();
    }

    @Override
    public List<PersonasDto> listaPersonasRH(String descripcion) throws SQLException {
        logger.info("----------Obteniendo personas vinculo laboral----------");
        Connection con = jpaConfig.secondDataSource().getConnection();
        String sql = "select p.nrodoc,p.apellidos,p.nombres,p.sexo,p.fecingreso,a.descripcion,\n" +
                "case\n" +
                "when rubro='P' then 'PER'\n" +
                "when rubro='C' then 'CON'\n" +
                "else\n" +
                "'COM'\n" +
                "end as vinculolaboral\n" +
                "from rh.personal p join rh.areatrab a\n" +
                "on p.codarea=a.codarea\n" +
                " where a.descripcion like '%VICE%';";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        //preparedStatement.setString(1, descripcion);


        ResultSet resultSet = preparedStatement.executeQuery();
        List<PersonasDto> personasDtoList = new ArrayList<>();
        PersonasDto personasDto;
        while (resultSet.next()) {
            personasDto = new PersonasDto();
            personasDto.setNrodoc(resultSet.getString("nrodoc"));
            personasDto.setApellidos(resultSet.getString("apellidos"));
            personasDto.setNombres(resultSet.getString("nombres"));
            personasDto.setSexo(resultSet.getString("sexo"));
            personasDto.setFecingreso(resultSet.getDate("fecingreso"));
            personasDto.setDescripcion(resultSet.getString("descripcion"));
            personasDto.setVinculolaboral(resultSet.getString("vinculolaboral"));

            personasDtoList.add(personasDto);
        }
        con.close();

        return personasDtoList;
    }
}
