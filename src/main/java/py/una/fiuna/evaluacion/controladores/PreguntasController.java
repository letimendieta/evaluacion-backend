package py.una.fiuna.evaluacion.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.dto.PreguntasGrupoFactorDto;
import py.una.fiuna.evaluacion.modelos.Escalaevaluacion;
import py.una.fiuna.evaluacion.modelos.Preguntas;
import py.una.fiuna.evaluacion.servicios.PreguntasService;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/preguntas")
public class PreguntasController {

    @Autowired
    private PreguntasService preguntasService;

    private static final Logger logger = LoggerFactory.getLogger(Preguntas.class);

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Preguntas>> getAllPreguntas(@RequestParam(required = false, defaultValue = "0") Integer page) {

        Pageable pageable = PageRequest.of(page, 10000);

        logger.info("Preguntas listado");
        return ResponseEntity.ok(preguntasService.getAllPreguntas(pageable));

    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, String>> createPreguntas(Preguntas preguntas) {
        Map<String, String> resultado = new HashMap<>();
        preguntasService.createPreguntas(preguntas);

        logger.info("Preguntas crear");

        resultado.put("mensaje", "Pregunta creada");
        return ResponseEntity.ok(resultado);

    }

    @PutMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, String>> updatePreguntas(Preguntas preguntas) {
        Map<String, String> resultado = new HashMap<>();
        preguntasService.updatePreguntas(preguntas);

        logger.info("Preguntas modificada");

        resultado.put("mensaje", "Pregunta modificada");
        return ResponseEntity.ok(resultado);

    }

    @DeleteMapping("/borrar")
    public ResponseEntity<Map<String, String>> deletePreguntas(@RequestBody int idpregunta ) {
        Map<String, String> resultado = new HashMap<>();
        preguntasService.deletePreguntas(idpregunta);

        logger.info("Preguntas eliminada");

        resultado.put("mensaje", "Pregunta eliminada");
        return ResponseEntity.ok(resultado);

    }


    @GetMapping("/grupofactor")
    @ResponseBody
    public ResponseEntity<?> findAll(@RequestParam String idgrupo, @RequestParam String idfactor) throws SQLException {

        Map<String, Object> response = new HashMap<>();
        List<PreguntasGrupoFactorDto> preguntasGrupoFactorDtoList  = null;

        try {
            preguntasGrupoFactorDtoList = preguntasService.getPreguntasBygrupoAndfactor(Integer.parseInt(idgrupo),Integer.parseInt(idfactor));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch( Exception ex ){
            response.put("mensaje", "Ocurrio un error ");
            response.put("error", ex.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if( preguntasGrupoFactorDtoList.isEmpty()) {
            response.put("mensaje", "No se encontraron datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PreguntasGrupoFactorDto>>(preguntasGrupoFactorDtoList, HttpStatus.OK);

    }


}






