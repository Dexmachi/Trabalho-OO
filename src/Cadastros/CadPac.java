package Cadastros;

import Clientes.Paciente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadPac
{
    private final List<Paciente> pacs;
    CadConsul cadConsul;

    public CadPac(CadConsul cadConsul)
    {
        this.cadConsul = cadConsul;
        this.pacs = new ArrayList<>();
    }

    public void cadastrarPac(Paciente p)
    {
        this.pacs.add(p);
    }


    public Paciente criarPaciente()
    {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do paciente");
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do paciente");
        String dataNascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento do paciente");

        Paciente j = lerPaciente(cpf);

        if (j == null)
        {
        Paciente p = new Paciente(nome, cpf, dataNascimento, cadConsul);
            cadastrarPac(p);
            return p;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado");
            return null;
        }
    }


    public Paciente lerPaciente (String CPF)
    {
        for(Paciente p : this.pacs)
        {
            if(p.getCPF().trim().equalsIgnoreCase(CPF.trim()))
            {
                return p;
            }
        }
        System.out.println("Paciente com CPF " + CPF + " não encontrado.");
        return null;
    }

    public List<Paciente> getPacs(){
        {
            return this.pacs;
        }
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
            remove = this.pacs.remove(remover);
        }
        return remove;
    }
}
