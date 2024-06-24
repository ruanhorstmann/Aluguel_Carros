import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Sistema {
    private List<Cliente> clientes;
    private Administrador administrador;
    private List<Veiculo> veiculos;
    private List<Veiculo> veiculosFixosDisponiveis;

    public Sistema() {
        this.clientes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.veiculosFixosDisponiveis = new ArrayList<>();

        carregarDados(); // Carregar dados dos arquivos
        this.administrador = new Administrador("Administrador Padrão", "12345678900", "admin", "senha123");

        inicializarVeiculosFixosDisponiveis();
        atualizarReferenciaAdministrador();
    }

    private void carregarDados() {
        // Carregar clientes e veículos dos arquivos
        List<Cliente> loadedClientes = ArquivoUtil.carregarClientes();
        List<Veiculo> loadedVeiculos = ArquivoUtil.carregarVeiculos();

        if (loadedClientes != null) {
            this.clientes.addAll(loadedClientes);
        }
        if (loadedVeiculos != null) {
            this.veiculos.addAll(loadedVeiculos);
        }
    }

    private void inicializarVeiculosFixosDisponiveis() {
        veiculosFixosDisponiveis.add(new Carro("Gol G4", "ABC-1234", 4, "Volkswagen", 2018, 100.0, administrador));
        veiculosFixosDisponiveis.add(new Carro("Jetta", "DEF-1234", 4, "Volkswagen", 2024, 190.0, administrador));
        veiculosFixosDisponiveis.add(new Carro("Kwid", "GHI-1234", 4, "Renault", 2021, 120.0, administrador));
        veiculosFixosDisponiveis.add(new Carro("HB20", "JKL-1234", 4, "Hyundai", 2020, 150.0, administrador));
        veiculosFixosDisponiveis.add(new Moto("Honda", "CG Fan", "MNO-123", 160, 90.0, administrador, 2019));
        veiculosFixosDisponiveis.add(new Moto("Yamaha", "Yamaha Fazer", "PQR-123", 250, 130.0, administrador, 2022));
        veiculosFixosDisponiveis.add(new Caminhao("Scania R450", "XYZ-5678", "XYZ-5678", 25.0, "Carga Seca", 300.0, administrador, 2021));
        veiculosFixosDisponiveis.add(new Caminhao("Volvo FH540", "XYZ-9876", "XYZ-9876", 30.0, "Baú Refrigerado", 350.0, administrador, 2023));
    }

    private void atualizarReferenciaAdministrador() {
        for (Veiculo veiculo : veiculos) {
            veiculo.setAdministrador(administrador);
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        if (buscarClientePorCPF(cliente.getCpf()) != null) {
            System.out.println("\nErro: CPF já cadastrado.\n");
        } else {
            clientes.add(cliente);
            System.out.println("\nCliente " + cliente.getNome() + " cadastrado com sucesso!\n");
            salvarClientes();
        }
    }

    private void salvarClientes() {
        ArquivoUtil.salvarClientes(clientes);
    }

    public boolean loginAdministrador(String login, String senha) {
        if (administrador.autenticar(login, senha)) {
            System.out.println("\nAdministrador logado: " + administrador.getNome());
            return true;
        } else {
            System.out.println("\nFalha ao autenticar administrador");
            return false;
        }
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculo.setAdministrador(administrador);
        veiculos.add(veiculo);
        salvarVeiculos();
    }

    private void salvarVeiculos() {
        ArquivoUtil.salvarVeiculos(veiculos);
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>(veiculosFixosDisponiveis);

        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel() && !veiculo.isReservado()) {
                disponiveis.add(veiculo);
            }
        }
        return disponiveis;
    }

    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias) {
        if (veiculosFixosDisponiveis.contains(veiculo) || veiculos.contains(veiculo)) {
            if (veiculo.isDisponivel() && !veiculo.isReservado()) {
                veiculo.setCliente(cliente);
                veiculo.setDisponivel(false);
                veiculo.setReservado(false); // Garantir que não fique reservado

                Reserva reserva = new Reserva(cliente, veiculo, LocalDate.now(), dias);
                cliente.adicionarReserva(reserva);
                System.out.println("Veículo alugado com sucesso por " + dias + " dias.");
                salvarVeiculos();
                salvarClientes();
            } else {
                System.out.println("O veículo não está disponível para aluguel.");
            }
        } else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }

    public void reservarVeiculo(Cliente cliente, Veiculo veiculo, int dias) {
        if (veiculosFixosDisponiveis.contains(veiculo) || veiculos.contains(veiculo)) {
            if (veiculo.isDisponivel() && !veiculo.isReservado()) {
                veiculo.setCliente(cliente);
                veiculo.setDisponivel(false);
                veiculo.setReservado(true);

                Reserva reserva = new Reserva(cliente, veiculo, LocalDate.now(), dias);
                cliente.adicionarReserva(reserva);
                System.out.println("Veículo reservado com sucesso por " + dias + " dias.");
                salvarVeiculos();
                salvarClientes();
            } else {
                System.out.println("O veículo não está disponível para reserva.");
            }
        } else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }

    public void cancelarReservaVeiculo(Cliente cliente, Veiculo veiculo) {
        if (veiculos.contains(veiculo)) {
            if (veiculo.isReservado() && veiculo.getCliente().equals(cliente)) {
                veiculo.setReservado(false);
                veiculo.setDisponivel(true);
                veiculo.setCliente(null);

                cliente.removerReserva(veiculo);
                System.out.println("Reserva do veículo cancelada com sucesso.");
                salvarVeiculos();
                salvarClientes();
            } else {
                System.out.println("Este veículo não está reservado para este cliente.");
            }
        } else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
