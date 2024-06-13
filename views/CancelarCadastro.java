import utils.Console;
import contracts.IViews;
import controllers.CarroController;
import models.Funcionario;
import models.Usuario;
import controllers.FuncionarioController;

public class CancelarCadastro implements IViews{

    @Override
    public void renderizar() {
        FuncionarioController funcionarioController = new FuncionarioController();
        CarroController usuarioController = new CarroController();

        System.out.println("\n ---------- Cancelar Cadastro ----------\n");
        String cpf = Console.readString("Digite o Cpf para cancelar seu cadastro: ");
        Usuario usuario = usuarioController.buscarPorCpf(cpf);
        if(usuario != null){
            usuarioController.removerUsuario(usuario);
        System.out.println("\n ---------- Cadastro cancelado com suceso! ----------");
        } else {
            Funcionario funcionario = funcionarioController.buscarPorCpf(cpf);
            if(funcionario != null){
                funcionarioController.removerFuncionario(funcionario);
            System.out.println("\n ---------- Cadastro cancelado com suceso! ----------");
            }else{
                System.out.println("\n -------- CPF não encontrado! --------");
            }
        }
    }
}
