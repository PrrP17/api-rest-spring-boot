package mad.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mad.vol.api.Medico.DadosCadastradosMedicos;
import mad.vol.api.Medico.Medico;
import mad.vol.api.Medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    /* Essa maneira recebe a requisição de maneira literal */
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastradosMedicos dados){
        repository.save(new Medico(dados));
    }
}
