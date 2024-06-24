public class Caminhao extends Veiculo {
    private static final long serialVersionUID = 1L;

    private double capacidadeCarga;
    private String tipoCarroceria;

    public Caminhao(String marca, String modelo, String placa, double capacidadeCarga, String tipoCarroceria, double valorDiaria, Administrador administrador, int ano) {
        super(modelo, placa, valorDiaria, true, false, administrador, marca, ano);
        this.capacidadeCarga = capacidadeCarga;
        this.tipoCarroceria = tipoCarroceria;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", capacidadeCarga=" + capacidadeCarga +
                ", tipoCarroceria='" + tipoCarroceria + '\'' +
                ", valorDiaria=" + getValorDiaria() +
                ", ano=" + getAno() +
                '}';
    }
}
