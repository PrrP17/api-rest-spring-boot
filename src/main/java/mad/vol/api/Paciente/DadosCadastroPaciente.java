package mad.vol.api.Paciente;

import mad.vol.api.Endereco.DadosEndereco;

public record DadosCadastroPaciente(
    String nome,
    String email,
    String telefone,
    String cpf,
    DadosEndereco endereco
) {

}
