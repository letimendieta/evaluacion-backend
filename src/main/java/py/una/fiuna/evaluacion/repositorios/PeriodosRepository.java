package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.una.fiuna.evaluacion.modelos.Periodos;


public interface PeriodosRepository extends JpaRepository<Periodos, Long>, JpaSpecificationExecutor<Periodos> {
}
