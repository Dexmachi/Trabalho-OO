package Staff.Prescricoes;

import Clientes.Paciente;
import Clientes.Pagamento;
import Staff.Medico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private LocalDate data;
    private Medico medico;
    private Prescricoes p;
    private Paciente paciente;
    private double duracao;
    private boolean isAtendida=false;
    private int horario;
    private final List<Prescricoes> Pres;
    private String especialidade;
    private Pagamento pagamento;

    public Consulta(LocalDate data, Medico medico, Paciente paciente, double duracao,
                    int horario, String especialidade) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.duracao = duracao;
        this.horario = horario;
        this.especialidade = especialidade;
        this.Pres = new ArrayList<>();
    }


    public Paciente getPac() {
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

    public boolean getAtendida()
    {
        return this.isAtendida;
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
        pagamento.setPreco(novoPreco);
    }

    public void setData(LocalDate novaData)
    {
        this.data = novaData;
    }

    public Medico getMed()
    {
        return this.medico;
    }

    public Prescricoes getPres()
    {
        return this.p;
    }

    public List<Prescricoes> getListPres()
    {
        return this.Pres;
    }

    public void setP(Prescricoes p) {
        this.p = p;
    }

    public void addPres(Prescricoes p)
    {
        this.Pres.add(p);
    }
}
