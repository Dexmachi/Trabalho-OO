package Staff.Prescricoes;

import java.time.LocalDate;
import java.util.Date;

public class Preco {
    private double valor;
    private LocalDate vencimento;
    private double num; // pra que isso vai servir???

// get e set de valor
    public double getValor()
    {
        return valor;
    }

    public void setValor(double novoValor)
    {
        this.valor = novoValor;
    }

//get e set de vencimento
    public LocalDate getVencimento() {
        return this.vencimento;
    }

    public void setVencimento()
    {
        this.vencimento = vencimento;
    }
}