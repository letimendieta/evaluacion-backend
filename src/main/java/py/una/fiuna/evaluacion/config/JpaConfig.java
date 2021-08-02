package py.una.fiuna.evaluacion.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties springDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.configuration")
    public DataSource springDataSource() {
        return springDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Bean(name="rhDS")
    public DataSource secondDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://10.1.5.225:5432/rh_ing");


        dataSource.setUsername("consultaweb");

        dataSource.setPassword(".fiun@10");

        return dataSource;
    }

}
