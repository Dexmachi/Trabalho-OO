package Staff.Prescricoes;

public class Medicamento {
    private String nome;
    private String tipo; // * qual o tipo de medicação? antialérgico, anticoncepcional, etc
    private int quantidade;
    private int Periodo; // * de quantas em quantas horas o paciente deverá tomar a medicação
    private int Dias; // * quantos dias o paciente deverá ser medicado
    public Medicamento(String nome, String tipo, int quantidade, int Periodo, int Dias)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.Periodo = Periodo;
        this.Dias = Dias;
    }

    public String getNome()
    {
        return this.nome;
    }

    public int getQuantidade()
    {
        return this.quantidade;
    }

    public int getPeriodo()
    {
        return this.Periodo;
    }

    public int getDias()
    {
        return this.Dias;
    }

}
