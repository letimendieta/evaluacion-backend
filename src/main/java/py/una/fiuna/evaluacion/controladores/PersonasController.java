package py.una.fiuna.evaluacion.controladores;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.dto.PersonasDto;
import py.una.fiuna.evaluacion.modelos.Personas;
import py.una.fiuna.evaluacion.servicios.PersonasService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/personas")
public class PersonasController {
    @Autowired
    private PersonasService personasService;

    private static final Logger logger = LoggerFactory.getLogger(Personas.class);
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Personas>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page) {

        Pageable pageable = PageRequest.of(page, 10000);

        logger.info("Listado de personas ");
        return ResponseEntity.ok(personasService.findAll(pageable));

    }

    @GetMapping("/lista")
    @ResponseBody
    public List<PersonasDto> listaPersonasRH(@RequestParam String descripcion) throws SQLException {

        List<PersonasDto> personasDtoList;
        personasDtoList= personasService.listaPersonasRH(descripcion);
        return  personasDtoList;



    }



}
