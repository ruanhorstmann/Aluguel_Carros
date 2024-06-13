import utils.Console;
import contracts.IViews;
import controllers.CarroController;
import controllers.DisponibilidadeController;
import controllers.FuncionarioController;
import controllers.AluguelController;
import models.Usuario;
import models.Aluguel;
import models.Carro;
import models.Funcionario;
import models.ItemCarro;

public class CadastrarAluguel implements IViews {
    
    @Override
    public void renderizar() {
        Aluguel aluguel = new Aluguel();
        ItemCarro item = new ItemCarro();
        CarroController usuarioController = new CarroController();
        FuncionarioController funcionarioController = new FuncionarioController();
        CarroController carroController = new CarroController();
        AluguelController aluguelController = new AluguelController();
        DisponibilidadeController disponibilidadeController = new DisponibilidadeController();

        System.out.println("\n -------- Cadastro de um Aluguel --------");

        String cpfUsuario = Console.readString("Digite o CPF do Usuário: ");
        Usuario usuario = usuarioController.buscarPorCpf(cpfUsuario);
        if (usuario != null) {
            aluguel.setUsuario(usuario);
            String matriculaFuncionario = Console.readString("Digite o CPF do funcionário: ");
            Funcionario funcionario = funcionarioController.buscarPorCpf(matriculaFuncionario);
            if (funcionario != null) {
                aluguel.setFuncionario(funcionario);

                do {
                    item = new ItemCarro();
                    String placaCarro = Console.readString("Digite a placa do carro: ");
                    Carro carro = carroController.buscarPorPlaca(placaCarro);

                    if (carro != null) {
                        if ("Alugado".equals(carro.getStatus())) {
                            System.out.println("Carro Indisponível!");
                        } else {
                            aluguel.getCarros().add(item);
                            item.setCarro(carro);
                            carro.setStatus("Alugado");
                        }
                    } else {    
                        System.out.println("Carro não existe!");
                    }
                } while (Console.readString("Deseja alugar mais um carro? (S - Sim || N - Não)\n").toUpperCase().equals("S"));
                
                aluguelController.cadastrar(aluguel);

            } else {
                System.out.println("CPF do funcionário não encontrado! ");
            }

        } else {
            System.out.println("Usuário não encontrado! ");
        }
    }
}
