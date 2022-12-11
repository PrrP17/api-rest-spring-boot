package mad.vol.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mad.vol.api.Paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados){
        System.out.println("Dados recbidos -> " +dados);
    }
}
