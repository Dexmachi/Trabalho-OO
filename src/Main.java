import Cadastros.CadConsul;
import Cadastros.CadPac;
import Cadastros.CadastroMed;
import Clientes.Paciente;
import Staff.Medico;
import Staff.Prescricoes.Consulta;
import Menu.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CadastroMed cadM = new CadastroMed();
        CadConsul cadConsul = new CadConsul();
        CadPac cadPac = new CadPac(cadConsul);

        Menu menu = new Menu(cadM, cadPac, cadConsul);
        Paciente paciente = new Paciente("teste", "001", "25/02/2025", cadConsul);
        cadPac.cadastrarPac(paciente);

        for (Paciente p : cadPac.getPacs()) {
            System.out.println(p.getCPF());
        }

        Medico medico = new Medico("Jorge", "001", "25/02/2025", "001", "consulta");
        cadM.cadastrarMed(medico);

        menu.iniciarMenu();
    }
}
