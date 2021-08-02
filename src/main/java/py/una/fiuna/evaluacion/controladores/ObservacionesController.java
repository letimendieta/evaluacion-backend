package py.una.fiuna.evaluacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Observaciones;
import py.una.fiuna.evaluacion.modelos.Recomendaciones;
import py.una.fiuna.evaluacion.servicios.ObservacionesService;
import py.una.fiuna.evaluacion.servicios.RecomendacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/observacion")
public class ObservacionesController {

    @Autowired
    private ObservacionesService observacionesService;


    @PostMapping
    @ResponseBody
    public void crear(@RequestBody Observaciones datoObservacion, BindingResult result) throws EvaluacionException {

        if( result.hasErrors() ) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new EvaluacionException.BusinessException(errors.toString());
        }

        observacionesService.guardar(datoObservacion);
    }
}