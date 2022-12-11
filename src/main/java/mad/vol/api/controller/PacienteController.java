package mad.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mad.vol.api.Paciente.DadosCadastroPaciente;
import mad.vol.api.Paciente.PacientRepository;
import mad.vol.api.Paciente.Paciente;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacientRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }
}
