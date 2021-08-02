package py.una.fiuna.evaluacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Recomendaciones;
import py.una.fiuna.evaluacion.servicios.RecomendacionesService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/recomendacion")
public class RecomendacionesController {

    @Autowired
    private RecomendacionesService recomendacionesService;

    public RecomendacionesController(RecomendacionesService recomendacionesService) {
        this.recomendacionesService = recomendacionesService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> crear(@RequestBody Recomendaciones datoRecomendacion, BindingResult result) throws EvaluacionException {
        Map<String, Object> response = new HashMap<>();
        Recomendaciones recomendacionesNew = null;
        if( result.hasErrors() ) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new EvaluacionException.BusinessException(errors.toString());
        }

       recomendacionesNew = recomendacionesService.guardar(datoRecomendacion);

        response.put("mensaje", "la recomendacion ha sido creada con extio");
        response.put("recomendaciones",recomendacionesNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
