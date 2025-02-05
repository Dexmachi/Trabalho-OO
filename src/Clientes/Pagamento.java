package Clientes;

import Staff.Medico;
import Staff.Prescricoes.Preco;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Pagamento {
    private Preco preco;
    private boolean pago = false;
    private boolean vencido = false;
    private LocalDate dataCriacao;
    private LocalDate vencimento;



    public Pagamento(Preco p, LocalDate d)
    {
        this.preco = p;
        this.dataCriacao = d;
        setThisVencimento(d);
        this.pago = false;
        this.vencido = false;
    }

    // get e set do atributo "pago" //
    public boolean getPago()
    {
        return this.pago;
    }

    public LocalDate getDataCriacao()
    {
        return this.dataCriacao;
    }



    public void setPago(boolean pago)
    {
        this.pago=pago;
    }


    DecimalFormat df = new DecimalFormat("#.00");
// set que checa se o valor está vencido //
    public void setVencido()
    {
        if (getVencimento() != null && getVencimento().isBefore(LocalDate.now()) && !this.pago)
        {
            this.vencido = true;
        }
    }

// set que faz o valor receber uma multa básica após vencido ser = true
//TODO: fazer esta multa ser aumentada dependendo do mês (10% a mais ao mês)
    public void setValorVencido()
    {
        if(this.vencido && preco != null)
        {
            preco.setValor(preco.getValor()*1.1);
            System.out.println("o preço da sua desobediência é de R$" + df.format(preco.getValor()));
        }
    }
// * build method que usei, precisamos melhorar
    public Pagamento(Preco preco, int id)
    {
        this.preco = preco;
        setVencido();
    }

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //get e set de vencimento
    public void setThisVencimento(LocalDate v)
    {

        String dias = JOptionPane.showInputDialog("defina a quantidade de dias para este boleto vencer (30~90 dias recomendados)");
        int diasInt = Integer.parseInt(dias);
        this.vencimento = v.plusDays(diasInt);
        String vencimentoFormatado = vencimento.format(formatter);
        System.out.println("Data de vencimento: " + vencimentoFormatado);
    }
    public LocalDate getVencimento()
    {
        return this.vencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void func()
    {
        setVencido();
        setValorVencido();
    }

}
