package Staff;

public class Medico {
    // atributos //
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String CRM;
    private String especialidade;
    // funções //
    public Medico(String nome, String cpf, String dataNascimento, String crm, String especialidade) {
    }

    public String getNome()
    {
        return this.nome;
    }
    public String getCRM()
    {
        return this.CRM;
    }
    public String getDataNascimento()
    {
        return this.dataNascimento;
    }
    public String getEspecialidade()
    {
        return this.especialidade;
    }
    public String getCPF()
    {
        return this.cpf;
    }

    public void setNome(String n)
    {
        this.nome = n;
    }

    public void setCPF(String c)
    {
        this.cpf = c;
    }
}
