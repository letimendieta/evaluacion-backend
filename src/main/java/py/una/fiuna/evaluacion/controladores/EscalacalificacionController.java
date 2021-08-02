package py.una.fiuna.evaluacion.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.modelos.Escalacalifacion;
import py.una.fiuna.evaluacion.modelos.Personas;
import py.una.fiuna.evaluacion.servicios.EscalacalificacionService;
import py.una.fiuna.evaluacion.servicios.PersonasService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class EscalacalificacionController {
    @Autowired
    private EscalacalificacionService escalacalificacionService;

    private static final Logger logger = LoggerFactory.getLogger(Escalacalifacion.class);
    @GetMapping("/escalacalificacion")
    @ResponseBody
    public ResponseEntity<List<Escalacalifacion>> findAll() {

        logger.info("Listado de escala calificacion ");
        return ResponseEntity.ok(escalacalificacionService.findAll());

    }


}