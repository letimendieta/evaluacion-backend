package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Personas;

public interface PersonasRepository extends JpaRepository<Personas, Long> {

}
