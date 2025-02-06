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



public class CadConsul
{
    CadPac cadPac;
    private int numConsul = 0;
    private List<Consulta> consuls;

    public CadConsul()
    {
        numConsul = 0;
        consuls = new ArrayList<Consulta>();
    }

    public int cadastrarConsul(Consulta c)
    {
        boolean cadastrou = consuls.add(c);
        if(cadastrou)
        {
            numConsul=consuls.size();
        }
        return numConsul;
    }

    public Consulta criarConsul(CadastroMed cadM, CadPac cadPac)
    {
        Medico medico;
        Paciente paciente;

        String especialidade = JOptionPane.showInputDialog(null, "Digite a especialidade desejada:");
        String horariostr = JOptionPane.showInputDialog(null, "Digite o horário da consulta:");
        String duracaostr = JOptionPane.showInputDialog(null, "Digite o tempo estimado que vai levar a consulta:");
        String cpf = JOptionPane.showInputDialog(null, "Digite a o cpf do paciente:");
        String CRM = JOptionPane.showInputDialog(null, "Digite o crm do médico:");
        String valor = JOptionPane.showInputDialog(null, "Digite o valor da consulta:");
        String datastr =  JOptionPane.showInputDialog(null, "Digite a data de consulta:");


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


        paciente.agendarHorario(datastr);

        Consulta c = new Consulta(data, medico, paciente, duracao, horario, preco, especialidade);
        cadastrarConsul(c);
        Pagamento pagamento = new Pagamento(preco, data);
        paciente.adicionarPagamento(pagamento);
        return c;
    }

    public Consulta lerConsul (LocalDate data, String cpf)
    {
        for(Consulta c : consuls)
        {
            if(c.getData().equals(data))
            {
                Paciente p = c.getPaciente();
                if(p.getCPF().equalsIgnoreCase(cpf))
                {
                    return c;
                }
            }
        }
        System.out.println("Sem consultas encontradas no dia " + data + " e com um paciente de CPF " + cpf + ".");
        return null;
    }

    public int validarInteiroMed(String valor) {
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
                validarPaciente(cpf, cadPac);;
            }
            return pac;
        }
        return null;
    }


    public List<Consulta> getConsuls(){
        {
            return this.consuls;
        }
    }
}
