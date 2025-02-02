package Staff.Prescricoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Preco {
    private double valor;
    private LocalDate vencimento;
    private double num; // pra que isso vai servir???


    public Preco(double valor, LocalDate vencimento, double num)
    {
        this.valor = valor;
        this.vencimento = vencimento;
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


    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//get e set de vencimento
    public void setThisVencimento()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("defina a quantidade de dias (30~90 dias recomendados)");
        int dias = sc.nextInt();
        this.vencimento = LocalDate.now().plusDays(dias);
        String vencimentoFormatado = vencimento.format(formatter);
        System.out.println("Data de vencimento: " + vencimentoFormatado);
    }
    public LocalDate getVencimento() {
        return this.vencimento;
    }

}