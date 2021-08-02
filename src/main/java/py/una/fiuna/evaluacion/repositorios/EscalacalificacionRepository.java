package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Escalacalifacion;


public interface EscalacalificacionRepository extends JpaRepository<Escalacalifacion, Long> {
}
