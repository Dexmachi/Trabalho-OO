import Clientes.Pagamento;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Clientes.Pagamento pagamento = new Clientes.Pagamento(new Staff.Prescricoes.Preco(),  1);
        Clientes.Paciente paciente = new Clientes.Paciente(pagamento, 1);

        paciente.setisPago();
        if(pagamento.getPago())
        {
            System.out.println("pago com sucesso!!!");
        }
        else
        {
            System.out.println("você tem pagamentos pendentes.");
        }
        }
    }