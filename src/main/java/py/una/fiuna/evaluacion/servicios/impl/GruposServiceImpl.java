package py.una.fiuna.evaluacion.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import py.una.fiuna.evaluacion.modelos.Grupos;

import py.una.fiuna.evaluacion.repositorios.impl.EvaluacionRepositoryImpl;
import py.una.fiuna.evaluacion.servicios.GruposService;
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
public class GruposServiceImpl implements GruposService {

    @Autowired
    DataSource dataSourceProperties;

    ConsultaSQL consultaSQL = new ConsultaSQL();

    private static final Logger logger = LoggerFactory.getLogger(Grupos.class);



    public Map<String, Object> getGrupoById(Integer grupo) throws SQLException {
        logger.info("----------Obteniendo Grupo de evaluacion----------");
        Connection con = dataSourceProperties.getConnection();
        String sql = consultaSQL.getSQL("select_grupo_id");
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, grupo);

        ResultSet resultSet = preparedStatement.executeQuery();
        Map<String,Object> resultado = new HashMap<>();
        while (resultSet.next()){
            resultado.put("grupo",resultSet.getInt("idgrupo"));
            resultado.put("descripcion",resultSet.getString("descripcion"));
        }
        return resultado;
    }

}
