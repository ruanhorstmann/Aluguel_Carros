package controllers;
import models.Funcionario;
import java.util.ArrayList;

import controllers.contracts.IFuncionarioController;

public class FuncionarioController implements IFuncionarioController{
    private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    @Override
    public boolean cadastrar(Funcionario funcionario) {
        if(buscarPorCpf(funcionario.getCpf()) == null){
            funcionarios.add(funcionario);
            return true;
            }
            return false; 
    }

    @Override
    public ArrayList<Funcionario> listar(){
        return funcionarios;
    }

    @Override
    public Funcionario buscarPorCpf(String cpf) {
        for(Funcionario funcionarioLista: funcionarios){
            if (funcionarioLista.getCpf().equals(cpf)) {
                return funcionarioLista;
            }
        }
        return null;
    }

    @Override
    public void removerFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
        
    }

    

}
