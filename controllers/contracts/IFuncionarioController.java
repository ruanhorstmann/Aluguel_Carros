package controllers.contracts;

import java.util.ArrayList;

import models.Funcionario;

public interface IFuncionarioController {

    boolean cadastrar(Funcionario funcionario);
    ArrayList<Funcionario> listar();
    Funcionario buscarPorCpf(String cpf);
    void removerFuncionario(Funcionario funcionario);
    
}
