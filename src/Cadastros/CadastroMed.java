package Cadastros;

import Staff.Medico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroMed
{
    private int numMed;
    private List<Medico> meds;

    public CadastroMed()
    {
        numMed = 0;
        this.meds = new ArrayList<>();
    }

    public void cadastrarMed(Medico m)
    {
        meds.add(m);
        numMed=meds.size();
    }

    public void criarMed()
    {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do médico");
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do médico");
        String dataNascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento do médico");
        String crm = JOptionPane.showInputDialog(null, "Digite o CRM do médico");
        String especialidade = JOptionPane.showInputDialog(null, "Digite a especialidade do médico");
        Medico m = new Medico(nome, cpf, dataNascimento, crm, especialidade);

        Medico j = lerMedico(crm);

        if (j == null)
        {
            cadastrarMed(m);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "CRM já cadastrado.");
        }
    }

    public Medico lerMedico (String CRM)
    {
        for(Medico m : meds)
        {
            if(m.getCRM().trim().equalsIgnoreCase(CRM.trim()))
            {
                return m;
            }
        }
        return null;
    }

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

    public boolean deletarMed(Medico m)
    {
        boolean remove = false;
        Medico remover = lerMedico(m.getCRM());
        if(remover != null)
        {
            remove = meds.remove(remover);
        }
        return remove;
    }
}
