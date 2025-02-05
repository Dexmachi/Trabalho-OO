package Staff.Prescricoes;

import Cadastros.CadPac;
import Cadastros.CadastroMed;
import Clientes.Paciente;
import Clientes.Pagamento;
import Staff.Medico;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private LocalDate data;
    private Medico medico;
    private Paciente paciente;
    private double duracao;
    private boolean isAtendida=false;
    private int horario;
    private Preco preco;
    private String especialidade;
    CadPac cadPac=new CadPac();
    Pagamento pagamento;

    public Consulta(LocalDate data, Medico medico, Paciente paciente, double duracao,
                    int horario, Preco preco, String especialidade) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.duracao = duracao;
        this.horario = horario;
        this.preco = preco;
        this.especialidade = especialidade;
    }


    public Consulta()
    {}

    public Consulta criarConsul(CadastroMed cadM)
    {
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
        paciente = cadPac.lerPaciente(cpf);
        preco = new Preco(Double.parseDouble(valor), LocalDate.now(), 1);
        especialidade = especialidade;
        int horario = Integer.parseInt(horariostr);
        double duracao = Double.parseDouble(duracaostr);
        if(!medico.estaDisponivel(horario))
            do
                {
                    horariostr = JOptionPane.showInputDialog(null, "O médico não está disponível neste horário, favor inserir outro.");
                    horario = Integer.parseInt(horariostr);
                } while (!medico.estaDisponivel(horario));
        medico.agendarHorario(horario);
        Pagamento pagamento = new Pagamento(preco, data);
        paciente.adicionarPagamento(pagamento);
        return new Consulta(data, medico, paciente, duracao, horario, preco, especialidade);


    }

    public double getValor()
    {
        return this.preco.getValor();
    }

}
