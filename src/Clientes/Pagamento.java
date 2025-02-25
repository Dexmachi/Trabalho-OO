package Clientes;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pagamento {
    private double valor;
    private boolean pago = false;
    private boolean vencido = false;
    private final LocalDate dataCriacao;
    private LocalDate vencimento;



    public Pagamento(double p, LocalDate d)
    {
        this.valor = p;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor)
        {
            this.valor = valor;
        }

    public void setPago(boolean pago)
    {
        this.pago=pago;
    }

    public LocalDate getDataVencimento()
    {
        return this.vencimento;
    }


    DecimalFormat df = new DecimalFormat("#.00");
// set que checa se o valor está vencido //
    public boolean setVencido()
    {
        if (getVencimento() != null && getVencimento().isBefore(LocalDate.now()) && !this.pago)
        {
            this.vencido = true;
        }
        return this.vencido;
    }

// set que faz o valor receber uma multa básica após vencido ser = true
    public void setValorVencido()
    {
        if(this.vencido && valor != 0.0)
        {
            long mesesAtraso = calcularMesesAtraso();
            setValor(getValor()*Math.pow(1.1, mesesAtraso));
            System.out.println("o preço da sua desobediência é de R$" + df.format(getValor()));
        }
    }

    private long calcularMesesAtraso() {
        LocalDate dataAtual = LocalDate.now();
        long meses = ChronoUnit.MONTHS.between(vencimento, dataAtual);
        LocalDate vencimentoMaisMeses = vencimento.plusMonths(meses);
        if (dataAtual.isAfter(vencimentoMaisMeses)) {
            meses++;
        }
        return Math.max(meses, 0);
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



    public void setPreco(double novoPreco)
    {
        this.valor = novoPreco;
    }
}
