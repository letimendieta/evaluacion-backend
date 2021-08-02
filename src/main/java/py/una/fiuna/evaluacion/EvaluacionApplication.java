package py.una.fiuna.evaluacion;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "py.una.fiuna.evaluacion")
@SpringBootApplication
public class EvaluacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvaluacionApplication.class, args);
    }

}
