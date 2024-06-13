package controllers.contracts;

import java.util.ArrayList;

import models.Carro;

public interface ILivroController {
    
    void cadastrar(Carro livro);
    ArrayList<Carro> listar();
    Carro buscarPorLivro(String titulo);
    void removerLivro(Carro Livro);
    void atualizarLivro(Carro livro);
    
}
