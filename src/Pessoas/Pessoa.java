package Pessoas;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Pessoa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return this.nome;
    }


    public String getCPF() {
        return this.cpf;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setCPF(String c) {
        this.cpf = c;
    }

    public void setDataNascimento(String d) {
        this.dataNascimento = d;
    }
}

