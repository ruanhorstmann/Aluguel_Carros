package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Aluguel;

public class AluguelController {
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrar(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public List<Aluguel> listar() {
        return alugueis;
    }
}
