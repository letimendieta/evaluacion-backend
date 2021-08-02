package py.una.fiuna.evaluacion.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.modelos.Escalaevaluacion;
import py.una.fiuna.evaluacion.servicios.EscalaevaluacionService;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/escalaevaluacion")
public class EscalaevaluacionController {

    @Autowired
    private EscalaevaluacionService escalaevaluacionService;

    private static final Logger logger = LoggerFactory.getLogger(Escalaevaluacion.class);
    @GetMapping
    public ResponseEntity<?> findAll() throws SQLException {

        Map<String, Object> response = new HashMap<>();
        List<Escalaevaluacion> escalaevaluacionList = null;
        try {
            escalaevaluacionList = escalaevaluacionService.getEscalaEvaluacion();
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch( Exception ex ){
            response.put("mensaje", "Ocurrio un error ");
            response.put("error", ex.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if( escalaevaluacionList.isEmpty()) {
            response.put("mensaje", "No se encontraron datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Escalaevaluacion>>(escalaevaluacionList, HttpStatus.OK);

    }
}
