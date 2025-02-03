package Clientes;

import Staff.Prescricoes.Preco;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pagamento {
    private Preco preco;
    private boolean pago = false;
    private boolean vencido = false;
    private LocalDate vencimento;

    // get e set do atributo "pago" //
    public boolean getPago()
    {
        return this.pago;
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
    public void setThisVencimento()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("defina a quantidade de dias (30~90 dias recomendados)");
        int dias = sc.nextInt();
        this.vencimento = LocalDate.now().plusDays(dias);
        String vencimentoFormatado = vencimento.format(formatter);
        System.out.println("Data de vencimento: " + vencimentoFormatado);
    }
    public LocalDate getVencimento()
    {
        return this.vencimento;
    }

    public void func()
    {
        setVencido();
        setValorVencido();
    }

}
