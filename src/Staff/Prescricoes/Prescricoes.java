package Staff.Prescricoes;

import Clientes.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Prescricoes {
    private Consulta consul;
    private Medicamento medicamento;
    private Tratamento tratamento;
    private Exame exame;
    private List<Exame> exs;
    private List<Tratamento> trats;
    private List<Medicamento> meds;

    public Prescricoes(Consulta c, Medicamento m, Tratamento t, Exame e)
    {
        this.consul = c;
        this.medicamento = m;
        this.tratamento = t;
        this.exame = e;
        this.meds = new ArrayList<>();
        this.exs = new ArrayList<>();
        this.trats = new ArrayList<>();
    }

    public void addMeds(Medicamento m)
    {
        this.meds.add(m);
    }

    public void addExs(Exame e)
    {
        this.exs.add(e);
    }

    public void addTrats(Tratamento t)
    {
        this.trats.add(t);
    }

    public List<Medicamento> getMeds()
    {
        return this.meds;
    }

    public List<Exame> getExs()
    {
        return this.exs;
    }
    public List<Tratamento> getTrats()
    {
        return this.trats;
    }
}
