package Staff.Prescricoes;

public class Tratamento {
    private final String nome;
    private final int repeticoes;

    public Tratamento(String nome, int repeticoes)
    {
        this.nome = nome;
        this.repeticoes = repeticoes;
    }

    public String getNome()
    {
        return this.nome;
    }

    public int getRepeticoes()
    {
        return this.repeticoes;
    }

}