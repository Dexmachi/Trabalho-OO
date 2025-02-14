package Cadastros;

import Clientes.Pagamento;
import Staff.Prescricoes.Consulta;
import Clientes.Paciente;
import Staff.Medico;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class CadConsul {
    private final List<Consulta> consuls;

    public CadConsul() {
        this.consuls = new ArrayList<>();
    }

    public void cadastrarConsul(Consulta c) {
        this.consuls.add(c);
    }

    public Consulta criarConsul(CadastroMed cadM, CadPac cadPac) {
        Medico medico;
        Paciente paciente;

        String especialidade = JOptionPane.showInputDialog(null, "Digite a especialidade desejada:");
        String horariostr = JOptionPane.showInputDialog(null, "Digite o horário da consulta:");
        String duracaostr = JOptionPane.showInputDialog(null, "Digite o tempo estimado que vai levar a consulta:");
        String cpf = JOptionPane.showInputDialog(null, "Digite a o cpf do paciente:");
        String CRM = JOptionPane.showInputDialog(null, "Digite o crm do médico:");
        String valor = JOptionPane.showInputDialog(null, "Digite o valor da consulta:");
        String datastr = JOptionPane.showInputDialog(null, "Digite a data de consulta:");


        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        LocalDate data = LocalDate.parse(datastr, formato);

        medico = cadM.lerMedico(CRM);

        paciente = validarPaciente(cpf, cadPac);


        double preco = Double.parseDouble(valor);
        int horario = Integer.parseInt(horariostr);
        double duracao = Double.parseDouble(duracaostr);

        //garantir que o médico está disponível e agenda na agenda do médico
        while (!medico.estaDisponivel(horario)) {
            horariostr = JOptionPane.showInputDialog("O médico não está disponível neste horário. Favor inserir outro horário:");
            horario = validarInteiroMed(horariostr);
        }

        medico.agendarHorario(horario);

        paciente.agendarConsul(datastr);

        Consulta c = new Consulta(data, medico, paciente, duracao, horario, especialidade);
        cadastrarConsul(c);
        medico.addConsulta(c);

        Pagamento pagamento = new Pagamento(preco, data);
        paciente.adicionarPagamento(pagamento);
        return c;
    }

    public Consulta lerConsul (LocalDate data, String cpf)
    {
        for(Consulta c : this.consuls)
        {
            if(c.getData().equals(data))
            {
                Paciente p = c.getPac();
                if(p.getCPF().equalsIgnoreCase(cpf))
                {
                    return c;
                }
            }
            else
            {
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "Sem consultas encontradas no dia " + data + " e com um paciente de CPF " + cpf + ".");
        return null;
    }

    //método para atualizar alguma informação de consulta
    public void atualizarConsul(CadPac cadPac, CadastroMed cadMed)
    {
        Consulta c = lerConsulCMed();
        String r = JOptionPane.showInputDialog(null, "Qual informação deseja atualizar:\n1-especialidade\n2-horário\n3-duração\n4-paciente\n5-médico\n6-valor\n7-data");
        switch (r)
        {
            case "1":
                String e = JOptionPane.showInputDialog("Escreva a nova especialidade:");
                c.setEspecialidade(e);
                break;
            case "2":
                String h = JOptionPane.showInputDialog("Escreva o novo horário:");
                int novoHorario = Integer.parseInt(h);
                c.setHorario(novoHorario);
                break;
            case "3":
                String d = JOptionPane.showInputDialog("Escreva a nova duração:");
                double novaDuracao = Double.parseDouble(d);
                c.setDuracao(novaDuracao);
                break;
            case "4":
                String cpf = JOptionPane.showInputDialog("Escreva o CPF do novo paciente:");
                //método que possui o mesmo nome de outro método, porém possui apenas um parâmetro
                Paciente paciente = cadPac.lerPaciente(cpf);
                c.setPaciente(paciente);
                break;
            case "5":
                String crm = JOptionPane.showInputDialog("Escreva o CRM do novo médico:");
                //método para achar um médico a partir de sua crm
                Medico novoMedico = cadMed.lerMedico(crm);
                c.setMedico(novoMedico);
                break;
            case "6":
                String v = JOptionPane.showInputDialog("Escreva o novo valor:");
                double novoPreco = Double.parseDouble(v);
                c.setPreco(novoPreco);
                break;
            case "7":
                String dat = JOptionPane.showInputDialog("Escreva a nova data:");
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate novaData = LocalDate.parse(dat, formato);
                c.setData(novaData);
                break;
        }
    }

    public boolean cancelarConsul()
    {
        boolean remove = false;
        Consulta remover = lerConsulCMed();
        if(remover != null)
        {
            remove = this.consuls.remove(remover);
        }
        return remove;
    }

    public Consulta lerConsulCMed()
    {
        String datastr = JOptionPane.showInputDialog("insira a data da consulta que deseja ver:");
        LocalDate data = LocalDate.parse(datastr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String cpf = JOptionPane.showInputDialog("insira o cpf do paciente:");
        String nome = JOptionPane.showInputDialog("insira o nome do medico:");
        for(Consulta c : this.consuls) {
            System.out.println(c.getData());
            System.out.println(c.getMed().getNome());
            System.out.println(c.getPac().getCPF());
            if (c.getData().equals(data))
            {
                Paciente p = c.getPac();
                if (p.getCPF().equalsIgnoreCase(cpf)) {
                    Medico m = c.getMed();
                    if (m.getNome().equalsIgnoreCase(nome)) {
                        {
                            return c;
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Sem consultas encontradas com os dados indicados");
            return null;
        }
        JOptionPane.showMessageDialog(null, "Sem consultas encontradas com os dados indicados");
        return null;
    }

    public int validarInteiroMed(String valor)
    {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return validarInteiroMed(JOptionPane.showInputDialog("O médico não está disponível neste horário. Favor inserir outro horário:"));
        }
    }

    public Paciente validarPaciente(String cpf, CadPac cadPac)
    {
        for(Paciente pac : cadPac.getPacs())
        {
            if(!cpf.equalsIgnoreCase(pac.getCPF()))
            {
                cpf = JOptionPane.showInputDialog("Paciente inexistente ou não cadastrado, favor inserir outro cpf: ");
                validarPaciente(cpf, cadPac);
            }
            return pac;
        }
        return null;
    }
}
