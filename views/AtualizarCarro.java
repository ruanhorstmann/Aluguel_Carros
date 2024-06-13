import controllers.CarroController;
import models.Carro;
import utils.Console;
import contracts.IViews;

public class AtualizarCarro implements IViews {
  
    @Override
    public void renderizar() {
        CarroController carroController = new CarroController();
        System.out.println("\n ---------- Atualizar Carro ----------\n");
        String placa = Console.readString("Digite a placa do carro que deseja atualizar: ");
        Carro carro = carroController.buscarPorPlaca(placa);
        if (carro != null) {
            carro.setModelo(Console.readString("\nDigite o novo modelo do carro: "));
            carro.setMarca(Console.readString("Digite a nova marca do carro: "));
            carro.setAno(Console.readInt("Digite o novo ano do carro: "));
            carro.setStatus(Console.readString("Digite o novo status do carro: "));
            carroController.atualizarCarro(carro);
            System.out.println("\n ---------- Carro atualizado com sucesso! ----------");
        } else {
            System.out.println("\n -------- Carro não encontrado! --------");
        }
    }
}
