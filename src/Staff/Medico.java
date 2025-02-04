package Staff;
import Pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {
    // atributos //
    private String CRM;
    private String especialidade;
    private List<Integer> horariosOcupados;

    // funções //
    public Medico(String nome, String cpf, String dataNascimento, String crm, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.CRM = crm;
        this.especialidade = especialidade;
        this.horariosOcupados = new ArrayList<>();
    }

    public String getCRM() {
        return this.CRM;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setCrm(String cr) {
        this.CRM = cr;
    }

    public void setEspecialidade(String e) {
        this.especialidade = e;
    }

    public boolean estaDisponivel(int horario) {
        return !horariosOcupados.contains(horario);
    }

    public void agendarHorario(int horario) {
        if (estaDisponivel(horario)) {
            horariosOcupados.add(horario);
        }
    }
}
