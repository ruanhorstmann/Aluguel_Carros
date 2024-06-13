package models;

public class ItemCarro {
    private Carro carro;
    private String modelo;
    private String placa;
    
    public Carro getCarro(){
        return carro;
    }
    public void setCarro(Carro carro){
        this.carro = carro;
    }

    public String getModelo(){
        return modelo;
    }
    public void setTitulo(String modelo){
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
