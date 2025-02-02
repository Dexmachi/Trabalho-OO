//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Clientes.Pagamento pagamento = new Clientes.Pagamento(new Staff.Prescricoes.Preco(),  1);

        pagamento.setPago(false);

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