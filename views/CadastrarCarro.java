import controllers.CarroController;
import models.Carro;
import utils.Console;
import contracts.IViews;

public class CadastrarCarro implements IViews {

    @Override
    public void renderizar() {
        Carro carro = new Carro();
        CarroController carroController = new CarroController();
        System.out.println("\n ---------- Cadastro de Carros ----------\n");
        carro.setModelo(Console.readString("Digite o modelo do carro: "));
        carro.setMarca(Console.readString("Digite a marca do carro: "));
        carro.setAno(Console.readInt("Digite o ano do carro: "));
        carro.setPlaca(Console.readString("Digite a placa do carro: "));
        carroController.cadastrar(carro);
        System.out.println("\n ---------- Carro cadastrado com sucesso! ----------");
    }
    
}
