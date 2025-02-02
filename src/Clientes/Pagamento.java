package Clientes;

import Staff.Prescricoes.Preco;

import java.time.LocalDate;

public class Pagamento {
    private Preco preco;
    private boolean pago = false;
    private int id;
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
// get e set do atributo "pago" //

// set que checa se o valor está vencido //
//TODO: habilidade de settar o Localdate de getVencimento
    public void setVencido() {
        if (preco.getVencimento() != null && preco.getVencimento().isBefore(LocalDate.now()))
        {
            this.vencido = true;
        }
    }

// set que faz o valor receber uma multa básica após vencido ser = true
//TODO: fazer esta multa ser aumentada dependendo do mês (10% a mais ao mês)
    public void setValorVencido()
    {
        if(this.vencido && !this.pago && preco != null)
        {
            preco.setValor(preco.getValor()*1.1);
        }
    }
// * build method que usei, precisamos melhorar
    public Pagamento(Preco preco, int id) {
        this.preco = preco;
        this.id = id;
        setVencido();
    }


}
