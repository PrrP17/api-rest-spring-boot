package mad.vol.api.controller;

import mad.vol.api.Medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    /* Essa maneira recebe a requisição de maneira literal */

    /*Aqui comeca o CRUD*/
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastradosMedicos dados, UriComponentsBuilder uribuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uribuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosMedicosAtual(medico));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemMedicos>> listar(@PageableDefault(size = 10, sort = {"nome"}) org.springframework.data.domain.Pageable pagina){
        var page = repository.findAllByAtivoTrue(pagina).map(DadosListagemMedicos::new);
        return  ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosMedicosAtual(medico));

    }

    /*Excluzão de fato do banco de dados */
    @DeleteMapping("/{id}")
    @Transactional
    //devolvendo o codigo 204
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    /*Aqui termina o CRUD*/
}
