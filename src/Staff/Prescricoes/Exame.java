package Staff.Prescricoes;

import java.time.LocalDate;

public class Exame {
    private final String tipo;
    private final LocalDate dataPres;

    public Exame(String tipo, LocalDate dataPres)
    {
        this.tipo = tipo;
        this.dataPres = dataPres;
    }

    public String getTipo()
    {
        return this.tipo;
    }
    public LocalDate getDataPres()
    {
        return this.dataPres;
    }
}
