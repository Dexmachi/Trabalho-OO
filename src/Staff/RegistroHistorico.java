package Staff;

import Staff.Prescricoes.Consulta;
import Staff.Prescricoes.Exame;
import java.util.ArrayList;
import java.util.List;

public class RegistroHistorico {
    private final List<Consulta> historicoConsultas;
    private final List<Exame> historicoExames;

    public RegistroHistorico() {
        this.historicoConsultas = new ArrayList<>();
        this.historicoExames = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    public void adicionarExame(Exame exame) {
        historicoExames.add(exame);
    }

    public List<Consulta> getHistoricoConsultas() {
        return new ArrayList<>(historicoConsultas);
    }

    public List<Exame> getHistoricoExames() {
        return new ArrayList<>(historicoExames);
    }

    public void removerConsulta(Consulta consulta) {
        historicoConsultas.remove(consulta);
    }

    public void removerExame(Exame exame) {
        historicoExames.remove(exame);
    }
}
