package mad.vol.api.Medico;

public record DadosListagemMedicos(
    String nome,
    String email,
    String crm,
    Especialidade especialidade

) {
    public DadosListagemMedicos(Medico medico){
        this(medico.getCrm(),medico.getNome(), medico.getEmail(), medico.getEspecialidade());
    }
}
