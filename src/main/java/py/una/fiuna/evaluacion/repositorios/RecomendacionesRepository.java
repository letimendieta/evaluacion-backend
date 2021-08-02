package py.una.fiuna.evaluacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.fiuna.evaluacion.modelos.Recomendaciones;


public interface RecomendacionesRepository extends JpaRepository<Recomendaciones, Long> {
}
