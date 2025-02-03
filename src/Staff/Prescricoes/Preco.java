package Staff.Prescricoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Preco {
    private double valor;
    private double num; // pra que isso vai servir???


    public Preco(double valor, LocalDate vencimento, double num)
    {
        this.valor = valor;
        this.num = num;
    }

// get e set de valor
    public double getValor()
    {
        return valor;
    }

    public void setValor(double novoValor)
    {
        this.valor = novoValor;
    }

}