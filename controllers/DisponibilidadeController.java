package controllers;

import java.util.ArrayList;
import controllers.IDisponibilidadeController;
import models.Carro;

public class DisponibilidadeController implements IDisponibilidadeController {
    private static ArrayList<Carro> disponibilidade = new ArrayList<Carro>();

    @Override
    public void cadastrarDisponibilidade(Carro disponivel) {
        disponibilidade.add(disponivel);
    }

    @Override
    public Carro buscarPorPlaca(String placa) {
        for (Carro carro : disponibilidade) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    @Override
    public void removerCarro(Carro carro) {
        disponibilidade.remove(carro);
    }
}
