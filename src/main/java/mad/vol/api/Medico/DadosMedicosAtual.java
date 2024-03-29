package mad.vol.api.Medico;

public record DadosMedicosAtual(Long id, String nome, String email, String crm, String telefone ,Especialidade especialidade, Endereco endereco) {

    public DadosMedicosAtual(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone() ,medico.getEspecialidade(), medico.getEndereco());
    }
}
