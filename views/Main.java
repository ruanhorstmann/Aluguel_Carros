import utils.Console;

public class Main {
    
    public static void main(String[] args) {
        int opc = 0;

        do {
            System.out.println(" ___________________________________");
            System.out.println("|                                   |");
            System.out.println("|              M E N U              |");
            System.out.println("|___________________________________|");
            System.out.println("|                                   |");
            System.out.println("|      1 - Cadastrar Cliente        |");
            System.out.println("|      2 - Listar Clientes          |");
            System.out.println("|      3 - Cadastrar Funcionário    |");
            System.out.println("|      4 - Listar Funcionários      |");
            System.out.println("|      5 - Cadastrar Carro          |");
            System.out.println("|      6 - Listar Carros            |");
            System.out.println("|      7 - Registrar Aluguel        |");
            System.out.println("|      8 - Listar Alugueis          |");
            System.out.println("|      9 - Devolver Carro           |");
            System.out.println("|     10 - Remover Carro            |");
            System.out.println("|     11 - Atualizar Carro          |");
            System.out.println("|     12 - Cancelar Cadastro        |");
            System.out.println("|                                   |");
            System.out.println("|             0 - SAIR              |");
            System.out.println("|___________________________________|");
            opc = Console.readInt("\nDigite a opção desejada: ");

            switch(opc) {
                case 1:
                    CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
                    cadastrarUsuario.renderizar();
                    break;

                case 2:
                    ListarUsuarios listarUsuarios = new ListarUsuarios();
                    listarUsuarios.renderizar();
                    break;

                case 3:
                    CadastrarFuncionario cadastrarFuncionario = new CadastrarFuncionario();
                    cadastrarFuncionario.renderizar();
                    break;

                case 4:
                    ListarFuncionarios listarFuncionarios = new ListarFuncionarios();
                    listarFuncionarios.renderizar();
                    break;

                case 5:
                    CadastrarCarro cadastrarCarro = new CadastrarCarro();
                    cadastrarCarro.renderizar();
                    break;

                case 6: 
                    ListarCarros listarCarros = new ListarCarros();
                    listarCarros.renderizar();
                    break;

                case 7:
                    CadastrarAluguel cadastrarAluguel = new CadastrarAluguel();
                    cadastrarAluguel.renderizar();
                    break;

                case 8:
                    ListarAluguel listarAluguel = new ListarAluguel();
                    listarAluguel.renderizar();
                    break;

                case 9:
                    DevolverCarro devolverCarro = new DevolverCarro();
                    devolverCarro.renderizar();
                    break;

                case 10:
                    RemoverCarro removerCarro = new RemoverCarro();
                    removerCarro.renderizar();
                    break;
                    
                case 11:
                    AtualizarCarro atualizarCarro = new AtualizarCarro();
                    atualizarCarro.renderizar();
                    break; 

                case 12:
                    CancelarCadastro cancelarCadastro = new CancelarCadastro();
                    cancelarCadastro.renderizar();
                    break; 

                case 0:
                    System.out.println("\n\n ---------- SAINDO ----------\n\n");
                    break;

                default:
                    System.out.println("\n ---------- OPÇÃO INVÁLIDA ----------");
            }
        } while (opc != 0);
    }
}
