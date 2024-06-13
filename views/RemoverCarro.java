import controllers.CarroController;
import models.Carro;
import utils.Console;
import contracts.IViews;

public class RemoverCarro implements IViews {

    @Override
    public void renderizar() {
        CarroController carroController = new CarroController();
        System.out.println("\n ---------- Remover Carro ----------\n");
        String placa = Console.readString("Digite a placa do carro: ");
        Carro carro = carroController.buscarPorPlaca(placa);
        if (carro != null) {
            carroController.removerCarro(carro);
            System.out.println("\n ---------- Carro removido com sucesso! ----------");
        } else {
            System.out.println("\n -------- Carro não encontrado! --------");
        }
    }
    
}
