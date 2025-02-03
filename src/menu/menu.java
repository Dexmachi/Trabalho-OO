package Menu;

import Staff.Medico;
import Clientes.Paciente;

import javax.swing.JOptionPane;

public class Menu {
        public void iniciarMenu() {
            String opcao = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-Médico\n2-Paciente\n3-consulta\n4-Prescrição");
            String opcao2;
            Medico m = null;
            Paciente p = null;

            switch (opcao)
            {
                case "1":
                    //sistema crud do médico
                    opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar médico\n2-ler médico\n3-atualizar médico\n4-deletar médico");
                    //condições para definir qual a ação escolhida
                    if (opcao2.equals("1"))
                    {
                        m = criarMedico();
                    }
                    /*
                    TODO 1 FAZER ISSO DAQUI SER LEGÍVEL PELO CÓDIGO (fazer esse menu ser recursivo)
                    TODO 2 FAZER O SISTEMA NÃO CRASHAR CASO O USUÁRIO SELECIONE UM NÚMERO ALÉM DOS QUE COLOCAMOS PARA SEREM SELECIONADOS
                    TODO 3 FAZER O SISTEMA TER UMA ETAPA A MAIS PARA LER O USUÁRIO (input de cpf para encontrar o objeto pessoa correto)
                    TODO 4 FAZER O SISTEMA FAZER O MÉDICO E O PACIENTE SEREM HERDEIROS DO OBJETO PESSOA
                    TODO 5 FAZER O SISTEMA TER UMA FORMA DE ENCONTRAR O OBJETO QUE QUEREMOS
                     */
                    else if (opcao2.equals("2") && m != null)
                    {
                        lerMedico(m);
                    }
                    else if (opcao2.equals("3") &&  m != null)
                    {
                        atualizarMedico(m);
                    }
                    break;
                case "2":
                    //sistema crud do paciente
                    opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar paciente\n2-ler paciente\n3-atualizar paciente\n4-deletar paciente");
                    if (opcao2.equals("1"))
                    {
                        p = criarPaciente();
                    }
                    else if (opcao2.equals("2") && p != null)
                    {
                        lerPaciente(p);
                    }
                    else if (opcao2.equals("3") &&  p != null)
                    {
                        atualizarPaciente(p);
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




    //função para criar um objeto medico
        public Medico criarMedico ()
        {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do médico");
            String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do médico");
            String dataNascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento do médico");
            String crm = JOptionPane.showInputDialog(null, "Digite o CRM do médico");
            String especialidade = JOptionPane.showInputDialog(null, "Digite a especialidade do médico");
            Medico m = new Medico(nome, cpf, dataNascimento, crm, especialidade);
            return m;
        }
        private Paciente criarPaciente()
        {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do paciente");
            String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do paciente");
            String dataNascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento do paciente");
            Paciente p = new Paciente(nome, cpf, dataNascimento, null, 0);
            return p;
        }

        //função para ler as informações de um objeto médico
        public void lerMedico (Medico m)
        {
            System.out.println("Nome:" + m.getNome() + "\n" + "CPF:" + m.getCPF() + "\n" + "data de nascimento:" + m.getDataNascimento() + "\n" + "CRM:" + m.getCRM() + "\n" + "Especialidade:" + m.getEspecialidade() + "\n");
        }
        private void lerPaciente(Paciente p)
        {
            System.out.println("Nome:" + p.getNome() + "\n" + "CPF:" + p.getCPF() + "\n" + "data de nascimento:" + p.getDataNascimento() + "\n");
        }

        //função para atualizar alguma informação do médico
        public void atualizarMedico (Medico m)
        {
            String r = JOptionPane.showInputDialog(null, "Qual informação deseja atualizar:\n1-Nome\n2-CPF\n3-Data de nascimento\n4-CRM\n5-Especialidade");
            switch (r)
            {
                case "1":
                    String n = JOptionPane.showInputDialog("Escreva o nome:");
                    m.setNome(n);
                    break;
                case "2":
                    String c = JOptionPane.showInputDialog("Escreva o CPF:");
                    m.setCPF(c);
                    break;
                case "3":
                    String d = JOptionPane.showInputDialog("Escreva o Data de nascimento:");
                    m.setDataNascimento(d);
                    break;
                case "4":
                    String cr = JOptionPane.showInputDialog("Escreva o CRM:");
                    m.setCrm(cr);
                    break;
                case"5":
                    String e = JOptionPane.showInputDialog("Escreva o Especialidade:");
                    m.setEspecialidade(e);
            }
        }
        private void atualizarPaciente(Paciente p)
        {
            String r = JOptionPane.showInputDialog(null, "Qual informação deseja atualizar:\n1-Nome\n2-CPF\n3-Data de nascimento");
            switch (r)
            {
                case "1":
                    String n = JOptionPane.showInputDialog("Escreva o nome:");
                    p.setNome(n);
                    break;
                case "2":
                    String c = JOptionPane.showInputDialog("Escreva o CPF:");
                    p.setCPF(c);
                    break;
                case "3":
                    String d = JOptionPane.showInputDialog("Escreva o Data de nascimento:");
                    p.setDataNascimento(d);
                    break;
            }
        }
}
