package py.una.fiuna.evaluacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Evaluaciones;
import py.una.fiuna.evaluacion.servicios.EvaluacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    @ResponseBody
    public void crear(@RequestBody Evaluaciones datoEvaluacion, BindingResult result) throws EvaluacionException {

        if( result.hasErrors() ) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new EvaluacionException.BusinessException(errors.toString());
        }

        evaluacionService.guardar(datoEvaluacion);
    }
}
