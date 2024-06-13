package controllers;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    // Método para cadastrar um novo usuário
    public boolean cadastrarUsuario(Usuario usuario) {
        // Verifica se o usuário já está cadastrado pelo CPF
        if (buscarPorCPF(usuario.getCpf()) == null) {
            usuarios.add(usuario);
            return true; // Cadastro realizado com sucesso
        }
        return false; // Usuário já cadastrado
    }

    // Método para listar todos os usuários cadastrados
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    // Método para buscar um usuário pelo CPF
    public Usuario buscarPorCPF(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario; // Retorna o usuário se encontrado
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    // Método para atualizar os dados de um usuário
    public boolean atualizarUsuario(Usuario usuarioAtualizado) {
        Usuario usuarioExistente = buscarPorCPF(usuarioAtualizado.getCpf());
        if (usuarioExistente != null) {
            // Atualiza os dados do usuário existente com os dados do usuário atualizado
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
            return true; // Atualização realizada com sucesso
        }
        return false; // Usuário não encontrado, portanto não foi atualizado
    }

    // Método para remover um usuário pelo CPF
    public boolean removerUsuario(String cpf) {
        Usuario usuario = buscarPorCPF(cpf);
        if (usuario != null) {
            usuarios.remove(usuario); // Remove o usuário se encontrado
            return true; // Remoção realizada com sucesso
        }
        return false; // Usuário não encontrado, portanto não foi removido
    }
}
