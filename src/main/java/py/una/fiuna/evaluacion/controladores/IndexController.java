package py.una.fiuna.evaluacion.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/inicio")
public class IndexController {

@GetMapping("/")
@ResponseBody
    public Map<String, String> index(){
    Map<String,String> mp = new HashMap<>();
    mp.put("index", "index");
    return mp;
}


}
