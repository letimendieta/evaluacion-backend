package py.una.fiuna.evaluacion.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.fiuna.evaluacion.modelos.Grupos;
import py.una.fiuna.evaluacion.servicios.GruposService;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class GruposController {


    @Autowired
    private GruposService gruposService;

    private static final Logger logger = LoggerFactory.getLogger(Grupos.class);
    @GetMapping("/grupos/{idgrupo}")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> findAll(@PathVariable String idgrupo) throws SQLException {


        return ResponseEntity.ok(gruposService.getGrupoById(Integer.parseInt(idgrupo)));

    }
}
