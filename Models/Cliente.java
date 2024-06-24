import java.util.ArrayList;
import java.util.List;

public abstract class Cliente extends Pessoa {
    private List<Reserva> reservas;

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.reservas = new ArrayList<>();
    }

    public abstract String getIdentificacao();

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void removerReserva(Veiculo veiculo) {
        this.reservas.removeIf(reserva -> reserva.getVeiculo().equals(veiculo));
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return super.toString() + ", reservas=" + reservas;
    }
}
