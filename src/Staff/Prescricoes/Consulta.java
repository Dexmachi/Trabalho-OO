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

    public String getCPFPaciente()
    {
        return this.paciente.getCPF();
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

    public void isAtendida() {
        this.isAtendida = true;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String e)
    {
        this.especialidade = e;
    }

    public void setHorario(int novoHorario)
    {
        this.horario = novoHorario;
    }

    public void setDuracao(double novaDuracao)
    {
        this.duracao = novaDuracao;
    }

    public void setPaciente(Paciente paciente)
    {
        this.paciente = paciente;
    }

    public void setMedico(Medico novoMedico)
    {
        this.medico = novoMedico;
    }

    public void setPreco(double novoPreco)
    {
        this.preco = novoPreco;
    }

    public void setData(LocalDate novaData)
    {
        this.data = novaData;
    }

    public Object getCRMMed()
    {
        return this.medico.getCRM();
    }

    public Medico getMed()
    {
        return this.medico;
    }
}
