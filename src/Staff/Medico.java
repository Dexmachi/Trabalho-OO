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
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.CRM = crm;
        this.especialidade = especialidade;
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

    public void setDataNascimento(String d)
    {
        this.dataNascimento = d;
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
