public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, String placa, int cilindrada, double valorDiaria, Administrador administrador, int ano) {
        super(modelo, placa, valorDiaria, true, false, administrador, marca, ano);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", cilindrada=" + cilindrada +
                ", valorDiaria=" + getValorDiaria() +
                ", ano=" + getAno() +
                '}';
    }
}
