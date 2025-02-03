package Clientes;
import Pessoas.Pessoa;

import java.time.LocalDate;
import java.util.Scanner;

public class Paciente extends Pessoa {
    // atributos //
    private Pagamento pagamento;
    // funções //
    public Paciente(String nome, String cpf, String dataNascimento, Pagamento pagamento) {
        super(nome, cpf, dataNascimento);
        this.pagamento = pagamento;
    }

    public String getCPF()
    {
        return super.getCPF();
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
