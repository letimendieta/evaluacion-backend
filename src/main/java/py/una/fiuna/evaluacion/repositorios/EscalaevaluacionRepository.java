package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Escalaevaluacion;


public interface EscalaevaluacionRepository extends JpaRepository<Escalaevaluacion, Long> {
}
