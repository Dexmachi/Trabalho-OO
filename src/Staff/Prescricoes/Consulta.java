package Staff.Prescricoes;

import Clientes.Paciente;
import Staff.Medico;

import java.util.Date;

public class Consulta {
    private Date data;
    private Medico medico;
    private Paciente paciente;
    private double duracao;
    private boolean isAtendida;
    private int horario;
    private Preco preco;
}
