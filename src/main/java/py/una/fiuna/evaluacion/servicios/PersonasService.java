package py.una.fiuna.evaluacion.servicios;

import py.una.fiuna.evaluacion.dto.PersonasDto;
import py.una.fiuna.evaluacion.modelos.Personas;

import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface PersonasService {
    public List<Personas> findAll(Pageable pageable);

    public List<PersonasDto> listaPersonasRH(String descripcion) throws SQLException;

}
