import controllers.CarroController;
import models.Usuario;
import utils.Console;
import contracts.IViews;

public class CadastrarUsuario implements IViews{

    @Override
    public void renderizar() {
        Usuario usuario = new Usuario();
        CarroController usuarioController = new CarroController();
        System.out.println("\n ---------- Cadastro de Usuários ----------\n");
        usuario.setNome(Console.readString("Digite o nome do usuário: "));
        usuario.setCpf(Console.readString("Digite o CPF do usuário: "));
        usuario.setTelefone(Console.readLong("Digite o telefone do usuário: "));
    
        
        if (usuarioController.cadastrar(usuario)) {
            System.out.println("\n---------- Usuário cadastrado com sucesso! ----------\n");
        } else {
            System.out.println("\n---------- CPF já cadastrado! ----------\n");
        }
    }
}
