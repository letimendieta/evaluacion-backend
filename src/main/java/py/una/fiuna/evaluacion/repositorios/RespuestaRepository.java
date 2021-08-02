package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Respuestas;


public interface RespuestaRepository extends JpaRepository<Respuestas, Long> {
}
