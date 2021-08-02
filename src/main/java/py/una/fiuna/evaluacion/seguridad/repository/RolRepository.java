package py.una.fiuna.evaluacion.seguridad.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.una.fiuna.evaluacion.modelos.Rol;
import py.una.fiuna.evaluacion.seguridad.enums.RolNombre;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
