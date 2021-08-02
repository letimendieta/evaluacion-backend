package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Preguntas;


public interface PreguntasRepository extends JpaRepository<Preguntas, Long> {
}
