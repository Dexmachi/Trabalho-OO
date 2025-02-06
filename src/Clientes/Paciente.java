package Clientes;
import Cadastros.CadConsul;
import Pessoas.Pessoa;
import Staff.Prescricoes.Consulta;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    // atributos //
    private Pagamento pagamento;
    private List<Pagamento> pagamentos;
    private List<Consulta> consultas;
    private CadConsul cadConsul;

    // funções //
    public Paciente(String nome, String cpf, String dataNascimento, CadConsul c) {
        super(nome, cpf, dataNascimento);
        this.pagamentos = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.cadConsul = c;
    }

    public String getCPF() {
        return super.getCPF();
    }

    public void adicionarPagamento(Pagamento p) {
        pagamentos.add(p);
    }

    public List<Pagamento> getPagamentosPendentes() {
        List<Pagamento> pendentes = new ArrayList<>();
        for (Pagamento pagamento : pagamentos) {
            if (!pagamento.isPago()) {
                pendentes.add(pagamento);
            }
        }
        return pendentes;
    }

    public Pagamento lerBoletos() {

        String data = JOptionPane.showInputDialog("Digite o dia do boleto");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate d = LocalDate.parse(data, formato);

            for (Pagamento m : pagamentos) {
                if (m.getDataCriacao().isEqual(d)) {
                    return m;
                }
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida. Por favor, use o formato dd/mm/yyyy digitando as /.");
        }

        return null;
    }


    public void setIsPago() {
        String sn = JOptionPane.showInputDialog("favor indique se você pagou ou não este boleto: ");
        System.out.println("Digite S se você pagou e N se não: ");
        if (sn.equalsIgnoreCase("N")) {
            pagamento.setPago(false);
        } else if (sn.equalsIgnoreCase("S")) {
            pagamento.setPago(true);
        } else {
            System.out.println("Entrada inválida, por favor insira uma entrada indicada.");
            setIsPago();
        }
    }

    public boolean estaDisponivel(String horario) {
        LocalDate d = LocalDate.parse(horario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (cadConsul.lerConsul(d, getCPF()) == null) {
            return false;
        }
        return true;
    }

    public void agendarHorario(String horario) {
        if (estaDisponivel(horario)) {
            LocalDate d = LocalDate.parse(horario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Consulta con = cadConsul.lerConsul(d, getCPF());
            if (con != null) {
                consultas.add(con);
            }
        }
    }
}
