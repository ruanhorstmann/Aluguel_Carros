import controllers.FuncionarioController;
import models.Funcionario;
import utils.Console;
import contracts.IViews;

public class CadastrarFuncionario implements IViews {

    @Override
    public void renderizar() {
        Funcionario funcionario = new Funcionario();
        FuncionarioController funcionarioController = new FuncionarioController();
        System.out.println("\n ---------- Cadastro de Funcionários ----------\n");
        funcionario.setNome(Console.readString("Digite o nome do funcionário: "));
        funcionario.setCpf(Console.readString("Digite o CPF do funcionário: "));
        funcionario.setMatricula(Console.readString("Digite a Matricula do Funcionario: "));
        
        if (funcionarioController.cadastrar(funcionario)) {
            System.out.println("\n---------- Funcionário cadastrado com sucesso! ----------\n");
        } else {
            System.out.println("\n---------- CPF já cadastrado! ----------\n");
        }
    }
}
