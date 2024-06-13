package models;

import java.util.List;

public class Aluguel {
    private Usuario usuario;
    private Funcionario funcionario;
    private List<ItemCarro> carros;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ItemCarro> getCarros() {
        return carros;
    }

    public void setCarros(List<ItemCarro> carros) {
        this.carros = carros;
    }
}
