package Staff.Prescricoes;

import Clientes.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Prescricoes {
    private final List<Exame> exs;
    private final List<Tratamento> trats;
    private final List<Medicamento> meds;

    public Prescricoes()
    {
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
