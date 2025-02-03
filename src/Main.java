import Clientes.Paciente;
import Clientes.Pagamento;
import Staff.Prescricoes.Preco;
import Menu.Menu;

import java.awt.*;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Preco preco = new Preco(102.0, LocalDate.now(), 1);
        Pagamento pagamento = new Pagamento(preco, 1);
        Menu menu = new Menu();
        menu.iniciarMenu();
    }
}
