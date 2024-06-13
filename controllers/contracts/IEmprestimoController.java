package controllers.contracts;

import java.util.ArrayList;

import models.Emprestimo;

public interface IEmprestimoController {

    void cadastrar(Emprestimo emprestimo);
    ArrayList<Emprestimo> listar();
    
}
