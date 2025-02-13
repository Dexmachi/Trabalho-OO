package Staff.Prescricoes;

import java.time.LocalDate;
import java.util.Date;

public class Exame {
    private String tipo;
    private LocalDate dataPres;

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
