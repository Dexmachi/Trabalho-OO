package Clientes;

import java.util.Scanner;

public class Paciente {
    // atributos //

    /*
     * linkar este check de pagamento com o get e set Pago de "Clientes.Pagamento"
     * fazer questão de que seja uma função do objeto "Clientes.Paciente" a troca deste check
    */
    private boolean isPago;
    private int id;
    // funções //
    private Pagamento pagamento = new Pagamento(new Staff.Prescricoes.Preco(), 1);
    public Paciente(Pagamento pagamento, int id) {
        this.pagamento = pagamento;
        this.id = id;
    }

    public void setisPago()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite S se você pagou e N se não: ");
        String sn = sc.nextLine();
        if(sn.equals("N") || sn.equals("n"))
        {
            pagamento.setPago(false);
        }
        else if(sn.equals("S") || sn.equals("s"))
        {
            pagamento.setPago(true);
        }
        else
        {
            setisPago();
        }
    }
}
