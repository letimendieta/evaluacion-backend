package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.una.fiuna.evaluacion.modelos.Evaluaciones;

public interface EvaluacionRepository extends JpaRepository<Evaluaciones,Integer>, JpaSpecificationExecutor<Evaluaciones> {
}
