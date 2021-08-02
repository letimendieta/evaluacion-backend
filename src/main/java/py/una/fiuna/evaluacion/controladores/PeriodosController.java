package py.una.fiuna.evaluacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Periodos;
import py.una.fiuna.evaluacion.servicios.PeriodosService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/periodo")
public class PeriodosController {

    @Autowired
    private PeriodosService periodosService;

    @PostMapping
    @ResponseBody
    public void crear(@RequestBody Periodos datoPeriodo, BindingResult result) throws EvaluacionException {

        if( result.hasErrors() ) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new EvaluacionException.BusinessException(errors.toString());
        }

        periodosService.guardar(datoPeriodo);
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Periodos datoPeriodo, BindingResult result) throws EvaluacionException {
        Map<String, Object> response = new HashMap<>();

        Periodos periodoUpdated = null;

        if( result.hasErrors() ) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            throw new EvaluacionException.BusinessException(errors.toString());
        }

        periodoUpdated = periodosService.actualizar(datoPeriodo);;

        response.put("mensaje", "El periodo ha sido actualizada con éxito!");
        response.put("periodo", periodoUpdated);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtener(@PathVariable("id") Integer id) throws EvaluacionException {
        Periodos periodos = null;

        periodos = periodosService.obtener(id);

        return new ResponseEntity<Periodos>(periodos, HttpStatus.OK);
    }



}
