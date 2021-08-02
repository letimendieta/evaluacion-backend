package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Variables;

public interface VariablesRepository  extends JpaRepository<Variables, Long> {
}
