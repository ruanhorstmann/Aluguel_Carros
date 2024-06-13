package controllers;
import java.util.ArrayList;
import java.util.List;
import models.Carro;
import models.Usuario;

public class CarroController {
    private List<Carro> carros = new ArrayList<>();

    // Método para cadastrar um novo carro
    public boolean cadastrar(Carro carro) {
        // Verifica se o carro já está cadastrado pelo número da placa
        if (buscarPorPlaca(carro.getPlaca()) == null) {
            carros.add(carro);
            return true; // Cadastro realizado com sucesso
        }
        return false; // Carro já cadastrado
    }

    // Método para listar todos os carros cadastrados
    public List<Carro> listarCarros() {
        return carros;
    }

    // Método para buscar um carro pelo número da placa
    public Carro buscarPorPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro; // Retorna o carro se encontrado
            }
        }
        return null; // Retorna null se o carro não for encontrado
    }

    // Método para atualizar os dados de um carro
    public boolean atualizarCarro(Carro carroAtualizado) {
        Carro carroExistente = buscarPorPlaca(carroAtualizado.getPlaca());
        if (carroExistente != null) {
            // Atualiza os dados do carro existente com os dados do carro atualizado
            carroExistente.setModelo(carroAtualizado.getModelo());
            carroExistente.setMarca(carroAtualizado.getMarca());
            carroExistente.setAno(carroAtualizado.getAno());
            carroExistente.setStatus(carroAtualizado.getStatus());
            return true; // Atualização realizada com sucesso
        }
        return false; // Carro não encontrado, portanto não foi atualizado
    }

    // Método para remover um carro pelo número da placa
    public boolean removerCarro(String placa) {
        Carro carro = buscarPorPlaca(placa);
        if (carro != null) {
            carros.remove(carro); // Remove o carro se encontrado
            return true; // Remoção realizada com sucesso
        }
        return false; // Carro não encontrado, portanto não foi removido
    }

    public boolean cadastrar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    public Usuario buscarPorCpf(String cpfUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCpf'");
    }

    public void removerUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerUsuario'");
    }

    public void removerCarro(Carro carro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerCarro'");
    }
}
