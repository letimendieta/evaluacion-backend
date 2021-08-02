package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Dependencias;


public interface DepedenciasRepository extends JpaRepository<Dependencias, Long> {
}
