package controllers;
import java.util.ArrayList;

import controllers.contracts.IEmprestimoController;
import models.Emprestimo;

public class EmprestimoController implements IEmprestimoController {
    private static ArrayList<Emprestimo> emprestimos =new ArrayList<Emprestimo>();

    @Override
    public void cadastrar(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }

    @Override
    public ArrayList<Emprestimo> listar() {
        return emprestimos;
    }

}
