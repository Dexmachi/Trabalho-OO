import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Staff.Prescricoes.Preco preco = new Staff.Prescricoes.Preco(102.0, LocalDate.now(),1);
        Clientes.Pagamento pagamento = new Clientes.Pagamento(preco,  1);
        Clientes.Paciente paciente = new Clientes.Paciente(pagamento, 1);

        preco.setThisVencimento();

        paciente.setIsPago();
        pagamento.func();
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