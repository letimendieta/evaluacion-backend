package py.una.fiuna.evaluacion.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.una.fiuna.evaluacion.modelos.Usuario;
import py.una.fiuna.evaluacion.seguridad.repository.UsuarioRepository;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }


    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
