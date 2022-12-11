package mad.vol.api.Medico;

import jakarta.validation.constraints.NotNull;
import mad.vol.api.Endereco.DadosEndereco;

public record DadosAtualizacaoMedicos(
    
    @NotNull
    Long id, 
    String telefone, 
    String nome, 
    DadosEndereco endereco) {

}
