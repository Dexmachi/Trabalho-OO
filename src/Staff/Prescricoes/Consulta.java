package Staff.Prescricoes;

import Clientes.Paciente;
import Clientes.Pagamento;
import Staff.Medico;

import java.time.LocalDate;

public class Consulta {
    private LocalDate data;
    private Medico medico;
    private Paciente paciente;
    private double duracao;
    private boolean isAtendida=false;
    private int horario;
    private double preco;
    private String especialidade;
    Pagamento pagamento;

    public Consulta(LocalDate data, Medico medico, Paciente paciente, double duracao,
                    int horario, double preco, String especialidade) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.duracao = duracao;
        this.horario = horario;
        this.preco = preco;
        this.especialidade = especialidade;
    }

    public double getPreco()
    {
        return this.pagamento.getValor();
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public LocalDate getData ()
    {
        return this.data;
    }

    public int getHorario() {
        return this.horario;
    }

    public boolean isAtendida() {
        return this.isAtendida;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }
}
