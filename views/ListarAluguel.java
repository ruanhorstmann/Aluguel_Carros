import controllers.AluguelController;
import models.Aluguel;
import contracts.IViews;
import models.ItemCarro;

public class ListarAluguel implements IViews {
    Aluguel aluguel = new Aluguel();
    
    @Override
    public void renderizar() {
        AluguelController aluguelController = new AluguelController();
        System.out.println("\n __________________________________");
        System.out.println("|                                  |");
        System.out.println("|        Listagem de Aluguéis       |");
        System.out.println("|__________________________________|\n");
    
        for (Aluguel aluguelCadastrado : aluguelController.listar()) {
            System.out.println("\n######## ALUGUEL ########");
            System.out.println("Usuário: " + aluguelCadastrado.getUsuario().getNome());
            System.out.println("Funcionário: " + aluguelCadastrado.getFuncionario().getNome());

            for (ItemCarro itemCadastrado : aluguelCadastrado.getCarros()) {
                System.out.println("-Carro: " + itemCadastrado.getModelo() + " - Placa: " + itemCadastrado.getPlaca());
            }
        }
    } 
}
