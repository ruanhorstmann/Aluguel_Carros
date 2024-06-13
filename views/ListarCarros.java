import controllers.CarroController;
import models.Carro;
import contracts.IViews;

public class ListarCarros implements IViews {

    @Override
    public void renderizar() {
        CarroController carroController = new CarroController();
        System.out.println("\n ---------- Listagem de Carros ----------\n");
        for (Carro carroCadastrado : carroController.listarCarros()) {
            System.out.println("Placa: " + carroCadastrado.getPlaca());
            System.out.println("Modelo: " + carroCadastrado.getModelo());
            System.out.println("Marca: " + carroCadastrado.getMarca());
            System.out.println("Ano: " + carroCadastrado.getAno());
            System.out.println("Status: " + carroCadastrado.getStatus());
            System.out.println("-----------------------------------------");
        }
    }
}
