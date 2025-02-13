package Menu;

import Cadastros.CadPres;
import Staff.Medico;
import Clientes.Paciente;
import Cadastros.CadastroMed;
import Cadastros.CadPac;
import Cadastros.CadConsul;
import Staff.Prescricoes.Consulta;

import javax.swing.JOptionPane;

public class Menu {
    Medico m = null;
    Paciente p = null;
    CadastroMed cadastroM;
    CadPac cadastroP;
    CadConsul cadConsul;
    CadPres cadPres;
    public Menu(CadastroMed cadastroM, CadPac cadPac, CadConsul cadC, CadPres cadPres)
    {
        this.cadPres = cadPres;
        this.cadastroM = cadastroM; //* recebe a instância de cadastro para usar a mesma lista de cadastros
        this.cadastroP = cadPac; //* recebe a instância de cadastro para usar a mesma lista de cadastros
        this.cadConsul = cadC; //* recebe a instância de cadastro para usar a mesma lista de cadastros
    }
    public void setCadPres(CadPres cadPres)
    {
        this.cadPres = cadPres;
    }

    /*
                        FAZER ISSO DAQUI SER LEGÍVEL PELO CÓDIGO (fazer esse menu ser recursivo)
                        * Corrigido via implementação de métodos ao invés de código puro

                        TODO 1 FAZER O SISTEMA NÃO CRASHAR CASO O USUÁRIO SELECIONE UM NÚMERO ALÉM DOS QUE COLOCAMOS PARA SEREM SELECIONADOS
                        !!!!!!! ainda não corrigido

                        FAZER O SISTEMA TER UMA ETAPA A MAIS PARA LER O USUÁRIO (input de cpf para encontrar o objeto pessoa correto)
                        * Corrigido utilizando os métodos "ler paciente" e "ler médico"

                        FAZER O SISTEMA FAZER O MÉDICO E O PACIENTE SEREM HERDEIROS DO OBJETO PESSOA
                        * Corrigido utilizando extend em public class paciente e médico

                        FAZER O SISTEMA TER UMA FORMA DE ENCONTRAR O OBJETO QUE QUEREMOS
                        * Mais um corrigido utilizando lerPaciente e lerMed

                        TODO 2 FAZER O RESTO DAS OPERAÇÕES DE PACIENTE

                        ! TODO 3 FAZER OS HISTÓRICOS
    */

    public void iniciarMenu()
    {

        String opcao3 = JOptionPane.showInputDialog("Você é\n1 - um médico\nou\n2 - um paciente");

        if (opcao3.equals("1"))
        {
            String opcao4 = JOptionPane.showInputDialog("Insira seu CRM");
            this.m = cadastroM.lerMedico(opcao4);
            if (m != null)
            {
                menuStaff();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"este não é um médico registrado");
                iniciarMenu();
            }
        }

        if(opcao3.equals("2"))
        {
            String opcao4 = JOptionPane.showInputDialog("Insira seu CPF");
            this.p = cadastroP.lerPaciente(opcao4);
            if (p != null)
            {
                menuClientes();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"este não é um paciente registrado");
                iniciarMenu();
            }
        }
    }

    public void menuStaff()
    {
        {
            String question;
            String opcao2;


            //*condições para definir qual a ação escolhida
            String opcao = JOptionPane.showInputDialog("""
                    O que deseja fazer:
                    1 - Editar médicos
                    2 - Editar Paciente
                    3 - Editar consulta
                    4 - Criar Prescrição
                    5 - Ver Histórico de consultas
                    6 - atender uma consulta
                    0 - voltar""");
            switch (opcao) {
                case "0":
                    iniciarMenu();
                    break;


                //! sistema crud do médico
                case "1":
                    opcao2 = JOptionPane.showInputDialog("""
                            Escolha uma das opções abaixo:
                            1-criar médico
                            2-ler médico
                            3-atualizar médico
                            4-deletar médico""");
                    switch (opcao2) {
                        case "1" -> {
                            cadastroM.criarMed();
                            menuStaff();
                        }
                        case "2" -> {
                            question = JOptionPane.showInputDialog("Informe o CRM do médico:");
                            Medico med = cadastroM.lerMedico(question);
                            if (med != null) {
                                JOptionPane.showMessageDialog(null, "CRM: " + med.getCRM() + " Nome: " + med.getNome());
                            }
                            menuStaff();
                        }
                        case "3" -> {
                            question = JOptionPane.showInputDialog("Informe o CRM do médico:");
                            Medico med = cadastroM.lerMedico(question);
                            if (med != null) {
                                cadastroM.atualizarMedico(med);
                            }
                            menuStaff();
                        }
                        case "4" -> {
                            question = JOptionPane.showInputDialog("Informe o CRM do médico:");
                            Medico med = cadastroM.lerMedico(question);
                            if (med != null) {
                                cadastroM.deletarMed(med);
                            }
                            menuStaff();
                        }
                    }
                    break;


                //!  sistema crud do paciente
                case "2":
                    opcao2 = JOptionPane.showInputDialog("""
                            Escolha uma das opções abaixo:
                            1-criar paciente
                            2-ler paciente
                            3-atualizar paciente
                            4-deletar paciente""");
                    switch (opcao2) {
                        case "1" -> {
                            p = cadastroP.criarPaciente();
                            menuStaff();
                        }
                        case "2" -> {
                            question = JOptionPane.showInputDialog("Informe o CPF do paciente:");
                            this.p = cadastroP.lerPaciente(question);
                            if (p != null) {
                                JOptionPane.showMessageDialog(null, "paciente de cpf: " + p.getCPF() + " e nome: " + p.getNome());
                            }
                            menuStaff();
                        }
                        case "3" -> {
                            question = JOptionPane.showInputDialog("Informe o CPF do paciente:");
                            this.p = cadastroP.lerPaciente(question);
                            if (p != null) {
                                cadastroP.atualizarPaciente(p);
                            }
                            menuStaff();
                        }
                        case "4" -> {
                            question = JOptionPane.showInputDialog("Informe o CPF do paciente:");
                            this.p = cadastroP.lerPaciente(question);
                            if (p != null) {
                                boolean bool = cadastroP.deletarPac(p);
                                if (bool) {
                                    JOptionPane.showMessageDialog(null, "deletado com sucesso");
                                }
                                menuStaff();
                            }
                        }
                    }
                    break;


                //! sistema crud de consulta
                case "3":
                    opcao2 = JOptionPane.showInputDialog("""
                            Escolha uma das opções abaixo:
                            1-criar consulta
                            2-ler consulta
                            3-atualizar consulta
                            4-deletar consulta
                            0 - voltar""");
                    switch (opcao2) {
                        case "1" -> {
                            Consulta c = cadConsul.criarConsul(cadastroM, cadastroP);
                            JOptionPane.showMessageDialog(null, c.toString());
                            menuStaff();
                        }
                        case "2" -> {
                            Consulta c = cadConsul.lerConsulCMed();
                            if (c != null) {
                                JOptionPane.showMessageDialog(null, "Consulta dia: " + c.getData() + " Hora: " + c.getHorario() + " Com o paciente: " + c.getPaciente().getNome() + " e médico: " + c.getMed().getNome());
                            }
                            menuStaff();
                        }
                        case "3" -> {
                            cadConsul.atualizarConsul(cadastroP, cadastroM);
                            menuStaff();
                        }
                        case "4" -> {
                            cadConsul.cancelarConsul();
                            menuStaff();
                        }
                    }
                    break;


                //! sistema crud da prescrição
                case "4":
                    opcao2 = JOptionPane.showInputDialog("""
                            O que deseja fazer?
                            1 - Cadastrar uma prescrição
                            2 - Ler uma prescrição
                            3 - Atualizar uma prescrição
                            4 - Deletar uma prescrição
                            0 - Voltar
                            """);
                        switch (opcao2) {
                            case "1" -> {
                                opcao2 = JOptionPane.showInputDialog("""
                            Escolha uma das opções abaixo para adicionar à essa prescrição:
                            1- Exame
                            2- Medicamento
                            3-Tratamento
                            4- finalizar
                            0- Voltar""");
                                switch (opcao2)
                                {
                                    case "0" ->
                                            menuStaff();

                                    case "1" ->
                                    {
                                        cadPres.criarExame();
                                        menuStaff();
                                    }
                                    case "2" ->
                                    {
                                        cadPres.criarMed();
                                        menuStaff();
                                    }

                                    case "3" ->
                                    {
                                        cadPres.criarTrat();
                                        menuStaff();
                                    }
                                    case "4" ->
                                    {
                                        cadPres.cadPres();
                                        menuStaff();
                                    }
                                }
                                menuStaff();
                            }
                            case "2" -> {
                                cadPres.lerPres();
                                menuStaff();
                            }
                            case "3" -> {
                                cadPres.atualizarPres();
                                menuStaff();
                            }
                            case "4" -> {
                                cadPres.cancelarPres();
                                menuStaff();
                            }
                    }
                    break;
            }
        }
    }

    public void menuClientes()
    {
        String opcao = JOptionPane.showInputDialog("""
                O que deseja fazer:
                1 - Marcar consulta
                2 - Cancelar consulta
                3 - Ver boletos
                4 - Pagar boleto
                5 - Ver histórico de consultas
                6 - Ver prescrições
                0 - Voltar""");
        switch (opcao)
        {
            case "0":
                iniciarMenu();
            case "1":
                JOptionPane.showMessageDialog(null, "Entraremos em contato em breve para marcar sua consulta!");
                menuClientes();
            case "2":
                JOptionPane.showMessageDialog(null, "Entraremos em contato para cancelar sua consulta.");
                menuClientes();
            case "4":
                p.setIsPago();
                menuClientes();
        }
    }


}
