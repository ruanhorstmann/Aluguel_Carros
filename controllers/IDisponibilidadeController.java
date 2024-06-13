package controllers;

import models.Carro;

public interface IDisponibilidadeController {
    void cadastrarDisponibilidade(Carro disponivel);
    Carro buscarPorPlaca(String placa);
    void removerCarro(Carro carro);
}
