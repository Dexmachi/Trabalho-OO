package Staff.Prescricoes;

public class Medicamento {
    private final String nome;
    private final String tipo; // * qual o tipo de medicação? antialérgico, anticoncepcional, etc
    private final int quantidade;
    private final int Periodo; // * de quantas em quantas horas o paciente deverá tomar a medicação
    private final int Dias; // * quantos dias o paciente deverá ser medicado
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

    public String getTipo()
        {
            return this.tipo;
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
