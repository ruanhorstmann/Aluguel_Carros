package controllers.contracts;

import java.util.ArrayList;

import models.Usuario;

public interface IUsuarioController {

    boolean cadastrar(Usuario usuario);
    ArrayList <Usuario> listar();
    Usuario buscarPorCpf(String cpf);
    void removerUsuario(Usuario funcionario);

}
