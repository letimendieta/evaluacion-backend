package py.una.fiuna.evaluacion.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.exceptions.EvaluacionException;
import py.una.fiuna.evaluacion.modelos.Respuestas;
import py.una.fiuna.evaluacion.servicios.RespuestaService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/respuesta")
public class RespuestaController {



    @Autowired
    private RespuestaService respuestaService;


    @PostMapping
    @ResponseBody
    public Map<String,String> crear(@RequestBody List<Respuestas> respuestasList, BindingResult result) throws EvaluacionException, SQLException {
        Map<String,String> resultado = new HashMap<>();

        if( result.hasErrors() ) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new EvaluacionException.BusinessException(errors.toString());
        }

        resultado = respuestaService.guardarRespuestas(respuestasList);

        return  resultado;

    }
}
