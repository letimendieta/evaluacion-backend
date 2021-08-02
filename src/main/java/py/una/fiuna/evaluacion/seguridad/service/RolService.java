package py.una.fiuna.evaluacion.seguridad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.una.fiuna.evaluacion.modelos.Rol;
import py.una.fiuna.evaluacion.seguridad.enums.RolNombre;
import py.una.fiuna.evaluacion.seguridad.repository.RolRepository;


@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
