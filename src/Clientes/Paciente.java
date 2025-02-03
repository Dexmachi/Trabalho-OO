package Clientes;
import Pessoas.Pessoa;

import java.time.LocalDate;
import java.util.Scanner;

public class Paciente extends Pessoa {
    // atributos //
    private boolean isPago;
    // funções //
    private Pagamento pagamento = new Pagamento(new Staff.Prescricoes.Preco(0.0, LocalDate.now(), 1), 1);
    public Paciente(String nome, String cpf, String dataNascimento, Pagamento pagamento, int id) {
        super(nome, cpf, dataNascimento);
        this.pagamento = pagamento;
    }

    public void setIsPago()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite S se você pagou e N se não: ");
        String sn = sc.nextLine();
        if(sn.equalsIgnoreCase("N"))
        {
            pagamento.setPago(false);
        }
        else if(sn.equalsIgnoreCase("S"))
        {
            pagamento.setPago(true);
        }
        else
        {
            System.out.println("Entrada inválida, por favor insira uma entrada indicada.");
            setIsPago();
        }
        sc.close();
    }
}
