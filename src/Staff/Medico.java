package Staff;
import Pessoas.Pessoa;

public class Medico extends Pessoa{
    // atributos //
    private String CRM;
    private String especialidade;
    // funções //
    public Medico(String nome, String cpf, String dataNascimento, String crm, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.CRM = crm;
        this.especialidade = especialidade;
    }

    public String getCRM()
    {
        return this.CRM;
    }

    public String getEspecialidade()
    {
        return this.especialidade;
    }

    public void setCrm(String cr)
    {
        this.CRM = cr;
    }

    public void setEspecialidade(String e)
    {
        this.especialidade = e;
    }
}
