public class Carro extends Veiculo {
    private static final long serialVersionUID = 1L;

    private int numeroPortas;

    public Carro(String modelo, String placa, int numeroPortas, String marca, int ano, double valorDiaria, Administrador administrador) {
        super(modelo, placa, valorDiaria, true, false, administrador, marca, ano);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", numeroPortas=" + numeroPortas +
                ", valorDiaria=" + getValorDiaria() +
                '}';
    }
}
