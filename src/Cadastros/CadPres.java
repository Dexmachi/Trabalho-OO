package Cadastros;

import Menu.Menu;
import Staff.Prescricoes.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CadPres {
    private final List<Exame> exs;
    private final List<Tratamento> trats;
    private final List<Medicamento> meds;
    CadConsul cadConsul;
    CadPac cadPac;
    CadastroMed cadM;
    Menu menu;

    public CadPres(CadConsul cadConsul, CadastroMed cadM, CadPac cadPac, Menu menu)
    {
        this.meds = new ArrayList<>();
        this.exs = new ArrayList<>();
        this.trats = new ArrayList<>();
        this.cadConsul = cadConsul;
        this.cadM = cadM;
        this.cadPac = cadPac;
        this.menu = menu;
    }



    public void criarExame()
    {
        String Tipo = JOptionPane.showInputDialog("indique o tipo de exame");
        String datastr = JOptionPane.showInputDialog("indique a data de exame");

        LocalDate data = LocalDate.parse(datastr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Exame ex = new Exame(Tipo, data);
        this.exs.add(ex);
    }


    public void criarMed()
    {
        String nome = JOptionPane.showInputDialog("indique o nome de medicamento");
        String tipo = JOptionPane.showInputDialog("indique o tipo de medicamento");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("indique quantas pilulas/Ml o paciente deve tomar"));
        int periodo = Integer.parseInt(JOptionPane.showInputDialog("indique de quantas em quantas horas o paciente deve tomar o remédio"));
        int Dias = Integer.parseInt(JOptionPane.showInputDialog("indique por quantos dias o paciente deverá tomar os remédios"));

        Medicamento m = new Medicamento(nome, tipo, quantidade, periodo, Dias);
        this.meds.add(m);
    }

    public void criarTrat()
    {
        String nome = JOptionPane.showInputDialog("indique o nome de tratamento");
        int repeticoes = Integer.parseInt(JOptionPane.showInputDialog("indique quantas vezes o tratamento deve ser repetido"));

        Tratamento t = new Tratamento(nome, repeticoes);

        this.trats.add(t);
    }

    public void cadPres()
    {
        String b = JOptionPane.showInputDialog("Tem certeza de que todos os dados estão inseridos? (S/N)");
        if (b.equalsIgnoreCase("S")) {
            Consulta c = cadConsul.lerConsulCMed();
            Prescricoes p = new Prescricoes();
            for (Medicamento m : new ArrayList<>(this.meds)) {
                p.addMeds(m);
                this.meds.remove(m);
            }
            for (Exame e : new ArrayList<>(this.exs)) {
                p.addExs(e);
                this.exs.remove(e);
            }
            for (Tratamento t : new ArrayList<>(this.trats)) {
                p.addTrats(t);
                this.trats.remove(t);
            }

            c.setP(p);
            c.addPres(p);
        } else if (b.equalsIgnoreCase("N")) {
        menuCad();
        }
    }

    public void lerPres()
    {
        Consulta c = cadConsul.lerConsulCMed();
        Prescricoes p = c.getPres();
        String opcao2 = JOptionPane.showInputDialog("""
                Escolha uma das opções abaixo que deseje ler:
                1- Exame
                2- Medicamento
                3-Tratamento
                0- Voltar""");
        switch (opcao2) {
            case "0" -> menu.menuStaff();

            case "1" -> {
                StringBuilder j = new StringBuilder();
                for (Exame e : p.getExs()) {
                    j.append("Fazer um exame de ").append(e.getTipo()).append("no dia: ").append(e.getDataPres()).append("\n");
                }
                JOptionPane.showMessageDialog(null, j.toString());
                lerPres();
            }
            case "2" -> {
                StringBuilder j = new StringBuilder();
                for (Medicamento m : p.getMeds()) {
                    j.append("Tomar o medicamento: ").append(m.getNome()).append(",na quantidade: ").append(m.getQuantidade()).append(" ,de ").append(m.getPeriodo()).append(" em ").append(m.getPeriodo()).append(" horas, por ").append(m.getDias()).append(" dias\n");
                }
                JOptionPane.showMessageDialog(null, j.toString());
                lerPres();
            }

            case "3" -> {
                StringBuilder j = new StringBuilder();
                for (Tratamento t : p.getTrats()) {
                    j.append("Realizar o tratamento: ").append(t.getNome()).append(", ").append(t.getRepeticoes()).append(" vezes");
                }
                JOptionPane.showMessageDialog(null, j.toString());
                lerPres();
            }
        }

    }

    public void lerPresPraPac()
    {
        Consulta c = cadConsul.lerConsulCMed();
        Prescricoes p = c.getPres();
        String opcao2 = JOptionPane.showInputDialog("""
                Escolha uma das opções abaixo que deseje ler:
                1- Exame
                2- Medicamento
                3-Tratamento
                0- Voltar""");
        switch (opcao2) {
            case "0" -> menu.menuClientes();

            case "1" -> {
                StringBuilder j = new StringBuilder();
                for (Exame e : p.getExs()) {
                    j.append("Fazer um exame de ").append(e.getTipo()).append("no dia: ").append(e.getDataPres()).append("\n");
                }
                JOptionPane.showMessageDialog(null, j.toString());
                lerPres();
            }
            case "2" -> {
                StringBuilder j = new StringBuilder();
                for (Medicamento m : p.getMeds()) {
                    j.append("Tomar o medicamento: ").append(m.getNome()).append(",na quantidade: ").append(m.getQuantidade()).append(" ,de ").append(m.getPeriodo()).append(" em ").append(m.getPeriodo()).append(" horas, por ").append(m.getDias()).append(" dias\n");
                }
                JOptionPane.showMessageDialog(null, j.toString());
                lerPres();
            }

            case "3" -> {
                StringBuilder j = new StringBuilder();
                for (Tratamento t : p.getTrats()) {
                    j.append("Realizar o tratamento: ").append(t.getNome()).append(", ").append(t.getRepeticoes()).append(" vezes");
                }
                JOptionPane.showMessageDialog(null, j.toString());
                lerPres();
            }
        }

    }

    public void atualizarPres()
    {
        Consulta c = cadConsul.lerConsulCMed();
        Prescricoes p = c.getPres();
        menuLimpAt(p);
        menuCad();
    }

    public void menuLimpAt(Prescricoes p)
    {
        String b = JOptionPane.showInputDialog("""
                Selecione o que deseja limpar para atualizar
                1 - Medicamentos
                2 - Exames
                3 - Tratamentos
                4 - avançar
                0 - voltar""");
        switch (b) {
            case "1" -> {
                for (Medicamento m : new ArrayList<>(p.getMeds())) {
                    p.getMeds().remove(m);
                }
                menuLimpAt(p);
            }
            case "2" -> {
                for (Exame e : new ArrayList<>(p.getExs())) {
                    p.getExs().remove(e);
                }
                menuLimpAt(p);
            }
            case "3" -> {
                for (Tratamento t : new ArrayList<>(p.getTrats())) {
                    p.getTrats().remove(t);
                }
                menuLimpAt(p);
            }
            case "4" ->

                menuCad();

            case "0" ->

                menu.menuStaff();

        }
    }

    public void menuCad()
    {
        String opcao2 = JOptionPane.showInputDialog("""
                Escolha uma das opções abaixo para adicionar à essa prescrição:
                1 - Exame
                2 - Medicamento
                3 - Tratamento
                4 - finalizar
                0 - Voltar""");
        switch (opcao2) {
            case "0" ->
                menu.menuStaff();

            case "1" -> {
                criarExame();
                menuCad();
            }
            case "2" -> {
                criarMed();
                menuCad();
            }

            case "3" -> {
                criarTrat();
                menuCad();
            }
            case "4" -> {
                cadPres();
                menuCad();
            }
        }
    }

    public void cancelarPres()
    {
        Consulta c = cadConsul.lerConsulCMed();
        Prescricoes p = c.getPres();
        for (Medicamento m : new ArrayList<>(p.getMeds())) {
            p.getMeds().remove(m);
        }
        for (Exame e : new ArrayList<>(p.getExs())) {
            p.getExs().remove(e);
        }
        for (Tratamento t : new ArrayList<>(p.getTrats())) {
            p.getTrats().remove(t);
        }

    }
}