package Clientes;

import Staff.Prescricoes.Preco;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Pagamento {
    private Preco preco;
    private boolean pago = false;
    private boolean vencido = false;

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
//TODO: habilidade de settar o Localdate de getVencimento
    public void setVencido() {
        if (preco.getVencimento() != null && preco.getVencimento().isBefore(LocalDate.now()) && !this.pago)
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
    public Pagamento(Preco preco, int id) {
        this.preco = preco;
        setVencido();
    }

    public void func()
    {
        setVencido();
        setValorVencido();
    }

}
