package menu;

import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args) {
        String opcao = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-Médico\n2-Paciente");
        String opcao2;
        switch (opcao){
            case "1":
            opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar paciente\n2-ler paciente\n3-atualizar paciente\n4-deletar paciente");
            break;
            case "2":
            opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar médico\n2-ler médico\n3-atualizar médico\n4-deletar médico");
            break;
        }
    }
}
