import Cadastros.CadConsul;
import Cadastros.CadPac;
import Cadastros.CadPres;
import Cadastros.CadastroMed;
import Clientes.Paciente;
import Staff.Medico;
import Menu.Menu;

public class Main {
    public static void main(String[] args) {
        CadastroMed cadM = new CadastroMed();
        CadConsul cadConsul = new CadConsul();
        CadPac cadPac = new CadPac(cadConsul);



        Menu menu = new Menu(cadM, cadPac, cadConsul, null);
        CadPres cadPres = new CadPres(cadConsul, cadM, cadPac, menu);
        menu.setCadPres(cadPres);
        
        Paciente paciente = new Paciente("teste", "001", "25/02/2025", cadConsul);
        cadPac.cadastrarPac(paciente);

        for (Paciente p : cadPac.getPacs()) {
            System.out.println(p.getCPF());
        }

        Medico medico = new Medico("teste", "010", "25/02/2025", "001", "consulta");
        cadM.cadastrarMed(medico);

        menu.iniciarMenu();
    }
}
