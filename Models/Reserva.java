import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;

    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataReserva;
    private int dias;

    public Reserva(Cliente cliente, Veiculo veiculo, LocalDate dataReserva, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataReserva = dataReserva;
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public int getDias() {
        return dias;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataReserva=" + dataReserva +
                ", dias=" + dias +
                '}';
    }
}
