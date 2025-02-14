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
    private final List<Pagamento> pagamentos;
    private final List<Consulta> consultas;
    private final CadConsul cadConsul;

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
        this.pagamentos.add(p);
    }

    public List<Pagamento> getPagamentosPendentes() {
        List<Pagamento> pendentes = new ArrayList<>();
        boolean c = pagamento.getPago();
        for (Pagamento pagamento : this.pagamentos) {
            if (!c) {
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

            for (Pagamento m : this.pagamentos) {
                if (m.getDataCriacao().isEqual(d)) {
                    return m;
                }
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida. Por favor, use o formato dd/mm/yyyy digitando as /.");
            lerBoletos();
        }

        return null;
    }


    public void setIsPago() {

        Pagamento pagamento = lerBoletos();

        String sn = JOptionPane.showInputDialog("Digite S se você pagou e N se não: ");
        if (sn.equalsIgnoreCase("N")) {
            pagamento.setPago(false);
            JOptionPane.showInputDialog(null, "Não pago com sucesso!");
        } else if (sn.equalsIgnoreCase("S")) {
            pagamento.setPago(true);
            JOptionPane.showInputDialog(null, "Pago com sucesso!");
        } else {
            JOptionPane.showInputDialog("Entrada inválida, por favor insira uma entrada indicada.");
            setIsPago();
        }
    }

    public boolean estaDisponivel(LocalDate horario) {
        return cadConsul.lerConsul(horario, getCPF()) != null;
    }

    public void agendarConsul(String horario) {
        LocalDate d = LocalDate.parse(horario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (estaDisponivel(d)) {
            Consulta con = cadConsul.lerConsul(d, getCPF());
            if (con != null) {
                this.consultas.add(con);
            }
        }
    }
}
