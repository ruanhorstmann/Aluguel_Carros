import java.io.Serializable;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String modelo;
    private String placa;
    private double valorDiaria;
    private boolean disponivel;
    private boolean reservado;
    private Administrador administrador;
    private String marca;
    private int ano;
    private Cliente cliente;

    public Veiculo(String modelo, String placa, double valorDiaria) {
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
        this.reservado = false; // Por padrão, o veículo não está reservado
        this.administrador = null;
        this.cliente = null;
    }

    public Veiculo(String modelo, String placa, double valorDiaria, boolean disponivel, boolean reservado,
                   Administrador administrador, String marca, int ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
        this.reservado = reservado;
        this.administrador = administrador;
        this.marca = marca;
        this.ano = ano;
        this.cliente = null;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", valorDiaria=" + valorDiaria +
                ", disponivel=" + disponivel +
                ", reservado=" + reservado +
                ", administrador=" + (administrador != null ? administrador.getNome() : "N/A") +
                ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") +
                '}';
    }

    // Método para reservar o veículo
    public void reservar() {
        if (disponivel && !reservado) {
            reservado = true;
            System.out.println("Veículo reservado com sucesso.");
        } else {
            System.out.println("Não é possível reservar o veículo.");
        }
    }

    // Método para cancelar a reserva do veículo
    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
            System.out.println("Reserva do veículo cancelada.");
        } else {
            System.out.println("O veículo não está reservado.");
        }
    }
}
