package Menu;

import Staff.Medico;
import Clientes.Paciente;
import Cadastros.CadastroMed;
import Cadastros.cadPac;

import javax.swing.JOptionPane;

public class Menu {
    Medico m = null;
    Paciente p = null;
    CadastroMed cadastroM = new CadastroMed();
    cadPac cadastroP = new cadPac();
        public void iniciarMenu() {

            String opcao2;
            String opcao3 = JOptionPane.showInputDialog("Você é\n" + "1 - um médico\n" + "ou\n" + "2 - um paciente");
            String question;
            if (opcao3.equals("1"))
            {
                String opcao = JOptionPane.showInputDialog("O que deseja editar:\n1-Médico\n2-Paciente\n3-consulta\n4-Prescrição");
                switch (opcao) {
                    case "1":
                        //sistema crud do médico
                        opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar médico\n2-ler médico\n3-atualizar médico\n4-deletar médico");
                        //condições para definir qual a ação escolhida
                        if (opcao2.equals("1")) {
                            this.m = cadastroM.criarMedico();
                        }
                        /*
                        TODO 1 FAZER ISSO DAQUI SER LEGÍVEL PELO CÓDIGO (fazer esse menu ser recursivo)
                        TODO 2 FAZER O SISTEMA NÃO CRASHAR CASO O USUÁRIO SELECIONE UM NÚMERO ALÉM DOS QUE COLOCAMOS PARA SEREM SELECIONADOS
                        TODO 3 FAZER O SISTEMA TER UMA ETAPA A MAIS PARA LER O USUÁRIO (input de cpf para encontrar o objeto pessoa correto)
                        TODO 4 FAZER O SISTEMA FAZER O MÉDICO E O PACIENTE SEREM HERDEIROS DO OBJETO PESSOA
                        TODO 5 FAZER O SISTEMA TER UMA FORMA DE ENCONTRAR O OBJETO QUE QUEREMOS
                         */
                        else if (opcao2.equals("2") && m != null) {
                            question = JOptionPane.showInputDialog("Informe o CRM do médico:");
                            Medico med = cadastroM.lerMedico(question);
                            if (med != null) {
                                JOptionPane.showMessageDialog(null, med.toString());
                            }
                        } else if (opcao2.equals("3") && m != null) {
                            cadastroM.atualizarMedico(m);
                        } else if (opcao2.equals("4") && m != null) {
                            cadastroM.deletarMed(m);
                        }
                        break;
                    case "2":
                        //sistema crud do paciente
                        opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar paciente\n2-ler paciente\n3-atualizar paciente\n4-deletar paciente");
                        if (opcao2.equals("1")) {
                            this.p = cadastroP.criarPaciente();
                        } else if (opcao2.equals("2") && p != null) {
                            question = JOptionPane.showInputDialog("Informe o CPF do paciente:");
                            Paciente pac = cadastroP.lerPaciente(question);
                            if (pac != null) {
                                JOptionPane.showMessageDialog(null, p.toString());
                            }
                        } else if (opcao2.equals("3") && p != null) {
                            cadastroP.atualizarPaciente(p);
                        } else if (opcao2.equals("4") && p != null) {
                            boolean bool = cadastroP.deletarPac(p);
                            if (bool) {
                                JOptionPane.showMessageDialog(null, "deletado com sucesso");
                            }
                        }
                        break;
                    case "3":
                        //sistema crud de consulta
                        opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar consulta\n2-ler consulta\n3-atualizar consulta\n4-deletar consulta");
                        break;
                    case "4":
                        //sistema crud do exame
                        opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-Exame\n2-Medicamento\n3-Tratamento");
                        break;
                }
            }
        }
}
