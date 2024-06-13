import controllers.DisponibilidadeController;
import controllers.CarroController;
import models.Carro;
import utils.Console;
import contracts.IViews;
import models.Usuario;
import models.Aluguel;

public class DevolverCarro implements IViews {

    @Override
    public void renderizar() {
        
        DisponibilidadeController disponibilidadeController = new DisponibilidadeController();
        CarroController carroController = new CarroController();
        CarroController usuarioController = new CarroController();
        Aluguel aluguel = new Aluguel();
        
        System.out.println("\n ---------- Devolver Carro ----------\n");
        String placa = Console.readString("Digite a placa do carro: ");
        Carro carro = carroController.buscarPorPlaca(placa);
        
        if (carro != null) {
            carro.setStatus("Disponível");
            disponibilidadeController.removerCarro(carro);        

            String cpfUsuario = Console.readString("Digite o CPF do Usuário: ");
            Usuario usuario = usuarioController.buscarPorCpf(cpfUsuario);
            if (usuario != null) {
                aluguel.setUsuario(usuario);
                System.out.println("\n ---------- Carro devolvido com sucesso! ----------");
            } else {
                System.out.println(" -------- Usuário não encontrado --------");
            }
        
        } else {
            System.out.println(" -------- Carro não encontrado! --------");
        }
    }
    
}
