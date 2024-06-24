import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Sistema sistema;
    private final Scanner scanner;

    public Menu(Sistema sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("\nBem vindo a Positiva Veículos!!!\n");

        while (true) {
            exibirMenuPrincipal();
            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    cadastrarClientePF();
                    break;
                case 2:
                    cadastrarClientePJ();
                    break;
                case 3:
                    loginAdministrador();
                    break;
                case 4:
                    loginCliente();
                    break;
                case 5:
                    System.out.println("\nObrigado por utilizar nosso sistema! Até a próxima!\n");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("1. Cadastrar Cliente Pessoa Física");
        System.out.println("2. Cadastrar Cliente Pessoa Jurídica");
        System.out.println("3. Login Administrador");
        System.out.println("4. Login Cliente");
        System.out.println("5. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private int obterOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next(); // limpa o buffer do scanner
        }
        return scanner.nextInt();
    }

    private void cadastrarClientePF() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        ClientePF cliente = new ClientePF(nome, cpf, email);
        sistema.cadastrarCliente(cliente);
    }

    private void cadastrarClientePJ() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("Nome da Empresa: ");
        String nomeEmpresa = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("CPF do representante: ");
        String cpf = scanner.nextLine();

        ClientePJ clienteJuridico = new ClientePJ(nomeEmpresa, cpf, cnpj, nomeFantasia);
        sistema.cadastrarCliente(clienteJuridico);
    }

    private void loginAdministrador() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (sistema.loginAdministrador(login, senha)) {
            administradorMenu();
        } else {
            System.out.println("Login ou usuário incorretos\n");
        }
    }

    private void administradorMenu() {
        while (true) {
            exibirMenuAdministrador();
            int opcao = obterOpcao();

            if (opcao == 4) {
                System.out.println("\nSaindo do menu do administrador...\n");
                break;
            }

            cadastrarVeiculo(opcao);
        }
    }

    private void exibirMenuAdministrador() {
        System.out.println("\n-------Menu do Administrador--------\n");
        System.out.println("1. Cadastrar Carro");
        System.out.println("2. Cadastrar Moto");
        System.out.println("3. Cadastrar Caminhão");
        System.out.println("4. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private void cadastrarVeiculo(int opcao) {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("\nMarca do veículo: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Ano do veículo: ");
        int ano = obterInteiro();

        Veiculo veiculo = null;

        switch (opcao) {
            case 1:
                System.out.print("Número de portas: ");
                int numeroPortas = obterInteiro();
                System.out.print("Valor da diária: ");
                double valorDiariaCarro = obterDouble();

                veiculo = new Carro(modelo, placa, numeroPortas, marca, ano, valorDiariaCarro, sistema.getAdministrador());
                break;
            case 2:
                System.out.print("Cilindrada: ");
                int cilindrada = obterInteiro();
                System.out.print("Valor da diária: ");
                double valorDiariaMoto = obterDouble();

                veiculo = new Moto(marca, modelo, placa, cilindrada, valorDiariaMoto, sistema.getAdministrador(), ano);
                break;
            case 3:
                System.out.print("Capacidade de carga (toneladas): ");
                double capacidadeCarga = obterDouble();
                System.out.print("Tipo de carroceria: ");
                String tipoCarroceria = scanner.nextLine();
                System.out.print("Valor da diária: ");
                double valorDiariaCaminhao = obterDouble();

                veiculo = new Caminhao(marca, modelo, placa, capacidadeCarga, tipoCarroceria, valorDiariaCaminhao, sistema.getAdministrador(), ano);
                break;
            default:
                System.out.println("\nOpção inválida.\n");
        }

        if (veiculo != null) {
            sistema.adicionarVeiculo(veiculo);
            System.out.println("\nVeículo cadastrado com sucesso!\n");
        }
    }

    private void loginCliente() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("\nCPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente clienteEncontrado = sistema.buscarClientePorCPF(cpfCliente);
        if (clienteEncontrado != null) {
            clienteMenu(clienteEncontrado);
        } else {
            System.out.println("\nCliente não encontrado.\n");
        }
    }

    private void clienteMenu(Cliente cliente) {
        while (true) {
            exibirMenuCliente();
            int opcao = obterOpcao();

            if (opcao == 3) {
                System.out.println("\nSaindo do menu do cliente...\n");
                break;
            }

            switch (opcao) {
                case 1:
                    alugarVeiculo(cliente);
                    break;
                case 2:
                    reservarVeiculo(cliente);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void exibirMenuCliente() {
        System.out.println("\n----------Menu do Cliente----------\n");
        System.out.println("1. Reservar Veículo");
        System.out.println("2. Alugar Veículo");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void alugarVeiculo(Cliente cliente) {
        List<Veiculo> veiculosDisponiveis = sistema.listarVeiculosDisponiveis();
        if (veiculosDisponiveis.isEmpty()) {
            System.out.println("\nNenhum veículo disponível para aluguel.\n");
        } else {
            System.out.println("\nVeículos disponíveis:\n");
            for (int i = 0; i < veiculosDisponiveis.size(); i++) {
                Veiculo veiculo = veiculosDisponiveis.get(i);
                System.out.println((i + 1) + ". Marca: " + veiculo.getMarca() +
                        ", Modelo: " + veiculo.getModelo() +
                        ", Placa: " + veiculo.getPlaca() +
                        ", Valor da diária: " + veiculo.getValorDiaria());
            }
            System.out.print("\nEscolha o número do veículo para alugar: ");
            int escolha = obterInteiro();
    
            if (escolha > 0 && escolha <= veiculosDisponiveis.size()) {
                Veiculo veiculoEscolhido = veiculosDisponiveis.get(escolha - 1);
                System.out.print("\nQuantos dias deseja alugar o veículo?\n");
                int dias = obterInteiro();
                sistema.alugarVeiculo(cliente, veiculoEscolhido, dias);
            } else {
                System.out.println("\nEscolha inválida.");
            }
        }
    }
    

    private void reservarVeiculo(Cliente cliente) {
        List<Veiculo> veiculosDisponiveis = sistema.listarVeiculosDisponiveis();
        if (veiculosDisponiveis.isEmpty()) {
            System.out.println("\nNenhum veículo disponível para reserva.\n");
        } else {
            System.out.println("\nVeículos disponíveis para reserva:\n");
            for (int i = 0; i < veiculosDisponiveis.size(); i++) {
                if (i + 1 <= veiculosDisponiveis.size()) {
                    Veiculo veiculo = veiculosDisponiveis.get(i);
                    System.out.println((i + 1) + ". Marca: " + veiculo.getMarca() +
                            ", Modelo: " + veiculo.getModelo() +
                            ", Placa: " + veiculo.getPlaca() +
                            ", Valor da diária: " + veiculo.getValorDiaria());
                }
            }
            System.out.print("\nEscolha o número do veículo para reservar: ");
            int escolha = obterInteiro();

            if (escolha > 0 && escolha <= veiculosDisponiveis.size()) {
                Veiculo veiculoEscolhido = veiculosDisponiveis.get(escolha - 1);
                System.out.print("\nQuantos dias deseja reservar o veículo?\n");
                int dias = obterInteiro();
                sistema.reservarVeiculo(cliente, veiculoEscolhido, dias);
            } else {
                System.out.println("\nEscolha inválida.");
            }
        }
    }

    private int obterInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next(); // limpa o buffer do scanner
        }
        return scanner.nextInt();
    }

    private double obterDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next(); // limpa o buffer do scanner
        }
        return scanner.nextDouble();
    }
}