package mad.vol.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mad.vol.api.Endereco.DadosEndereco;

public record DadosCadastradosMedicos(

    @NotBlank
    String nome,
    
    @NotBlank
    @Email
    String email, 

    @NotBlank
    String telefone,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm, 

    @NotNull
    Especialidade especialidade,
    
    @NotNull
    @Valid DadosEndereco endereco) {
}