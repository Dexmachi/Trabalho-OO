package Cadastros;

import Clientes.Paciente;
import Staff.Medico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class cadPac
{
    private int numPac = 0;
    private List<Paciente> pacs;

    public cadPac()
    {
        numPac = 0;
        pacs = new ArrayList<Paciente>();
    }

    public int cadastrarPac(Paciente p)
    {
        boolean cadastrou = pacs.add(p);
        if(cadastrou)
        {
            numPac=pacs.size();
        }
        return numPac;
    }




    public Paciente criarPaciente()
    {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do paciente");
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do paciente");
        String dataNascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento do paciente");
        Paciente p = new Paciente(nome, cpf, dataNascimento, null);
        cadastrarPac(p);
        return p;
    }

    public Paciente lerPaciente (String CPF)
    {
        for(Paciente p : pacs)
        {
            if(p.getCPF().equalsIgnoreCase(CPF))
            {
                return p;
            }
                JOptionPane.showMessageDialog(null, p.toString());
        }
        return null;
    }

    public void atualizarPaciente(Paciente p)
    {
        String r = JOptionPane.showInputDialog(null, "Qual informação deseja atualizar:\n1-Nome\n2-CPF\n3-Data de nascimento");
        switch (r)
        {
            case "1":
                String n = JOptionPane.showInputDialog("Escreva o novo nome:");
                p.setNome(n);
                break;
            case "2":
                String c = JOptionPane.showInputDialog("Escreva o novo CPF:");
                p.setCPF(c);
                break;
            case "3":
                String d = JOptionPane.showInputDialog("Escreva a nova Data de nascimento:");
                p.setDataNascimento(d);
                break;
        }
    }

    public boolean deletarPac(Paciente p)
    {
        boolean remove = false;
        Paciente remover = lerPaciente(p.getCPF());
        if(remover != null)
        {
            remove = pacs.remove(remover);
        }
        return remove;
    }
}
