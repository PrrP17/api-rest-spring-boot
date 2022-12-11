package mad.vol.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mad.vol.api.Medico.DadosCadastradosMedicos;
import mad.vol.api.Medico.DadosListagemMedicos;
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

    @GetMapping
    public List<DadosListagemMedicos> listar(){
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }
}
