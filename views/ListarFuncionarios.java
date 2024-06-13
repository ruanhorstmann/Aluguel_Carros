import controllers.FuncionarioController;
import models.Funcionario;
import contracts.IViews;

public class ListarFuncionarios implements IViews{
    
    @Override
    public void renderizar() {
        FuncionarioController funcionarioController = new FuncionarioController();
        System.out.println("\n ---------- Listagem de Funcionários ----------\n");
        for (Funcionario funcionarioCadastrado : funcionarioController.listar()){
            System.out.println(funcionarioCadastrado);
        }
    }

}
