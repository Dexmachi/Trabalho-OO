package menu;

import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args) {
        //menu para escolher em qual menu quer ser redirecionado
        String opcao = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-Médico\n2-Paciente\n3-consulta\n4-Prescrição");
        String opcao2;
        Medico m;
        switch (opcao){
            case "1":
            //sistema crud do médico
            opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar médico\n2-ler médico\n3-atualizar médico\n4-deletar médico");
            //condições para definir qual a ação escolhida
            if(opcao2=="1"){
                m=criarMedico();
            }else if(opcao2=="2"){
                lerMedico();
            }else if(opcao2=="3"){
                atualizarMedico();
            }
            break;
            case "2":
            //sistema crud do paciente
            opcao2 = JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1-criar paciente\n2-ler paciente\n3-atualizar paciente\n4-deletar paciente");
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
    public Medico criarMedico(){
        String nome=JOptionPane.showInputDialog(null, "Digite o nome do médico");
        String cpf=JOptionPane.showInputDialog(null, "Digite o CPF do médico");
        String dataNascimento=JOptionPane.showInputDialog(null, "Digite a data de nascimento do médico");
        String crm=JOptionPane.showInputDialog(null, "Digite o CRM do médico");
        String especialidade=JOptionPane.showInputDialog(null, "Digite a especialidade do médico");
        Medico mm = new Medico(nome, cpf, dataNascimento, crm, especialidade);
        return mm;
    }
    //função para ler as informações de um objeto médico
    public void lerMedico(){
        System.out.println("Nome:"+m.getNome()+"\n"+"CPF:"+m.getCPF()+"\n"+"data de nascimento:"+m.getDataNascimento()+"\n"+"CRM:"+m.getCRM()+"\n"+"Especialidade:"+m.getEspecialidade()+"\n");
    }
    //função para atualizar alguma informação do médico
    public void atualizarMedico(){
        String r = JOptionPane.showInputDialog(null, "Qual informação deseja atualizar:\n1-Nome\n2-CPF\n3-Data de nascimento\n4-CRM\n5-Especialidade");
        switch (r){
            case "1":
            String n=JOptionPane.showInputDialog("Escreva o nome:");
            m.setNome(n);
            break;
            case "2":
            String c=JOptionPane.showInputDialog("Escreva o CPF:");
            m.setCPF(c);
            break;
        }
    }
}
