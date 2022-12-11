package mad.vol.api.Medico;

public record DadosListagemMedicos(
    String nome,
    String email,
    String crm,
    Long id,
    Especialidade especialidade

) {
    public DadosListagemMedicos(Medico medico){
        this(medico.getNome(),medico.getEmail(), medico.getCrm(), medico.getId(), medico.getEspecialidade());
    }
}
