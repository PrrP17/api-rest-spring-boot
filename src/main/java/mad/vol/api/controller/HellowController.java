package mad.vol.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellow")
public class HellowController {

    @GetMapping
    public String olaMundo(){
        return "Hellow World!";
    }    

}
