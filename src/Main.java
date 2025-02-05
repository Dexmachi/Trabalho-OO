import Cadastros.CadPac;
import Cadastros.CadastroMed;
import Clientes.Paciente;
import Clientes.Pagamento;
import Staff.Medico;
import Staff.Prescricoes.Consulta;
import Staff.Prescricoes.Preco;
import Menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CadastroMed cadM = new CadastroMed();
        CadPac cadPac = new CadPac();
        Consulta consulta = new Consulta();
        Menu menu = new Menu(cadM, cadPac);
        Paciente paciente = new Paciente("teste", "001", "25/02/2025");
        cadPac.cadastrarPac(paciente);

        for (Paciente p : cadPac.getPacs()) {
            System.out.println(p.getCPF());
        }

        Medico medico = new Medico("Jorge", "001", "25/02/2025", "001", "consulta");
        cadM.cadastrarMed(medico);



        menu.iniciarMenu();
    }
}
