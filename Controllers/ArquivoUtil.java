import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {
    private static final String DIRETORIO_DADOS = "Dados";
    private static final String ARQUIVO_CLIENTES = DIRETORIO_DADOS + "/clientes.dat";
    private static final String ARQUIVO_VEICULOS = DIRETORIO_DADOS + "/veiculos.dat";

    static {
        criarDiretorioSeNaoExistir(DIRETORIO_DADOS);
    }

    private static void criarDiretorioSeNaoExistir(String diretorio) {
        File dir = new File(diretorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void salvarClientes(List<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CLIENTES))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public static List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_CLIENTES))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> listaObjetos = (List<?>) obj;
                boolean todosClientes = listaObjetos.stream().allMatch(o -> o instanceof Cliente);
                if (todosClientes) {
                    @SuppressWarnings("unchecked")
                    List<Cliente> clientesLidos = (List<Cliente>) listaObjetos;
                    clientes.addAll(clientesLidos);
                } else {
                    System.err.println("A lista contém objetos que não são do tipo Cliente.");
                }
            } else {
                System.err.println("O objeto lido não é uma lista.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Arquivo de clientes não encontrado ou erro na leitura: " + e.getMessage());
        }
        return clientes;
    }

    public static void salvarVeiculos(List<Veiculo> veiculos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_VEICULOS))) {
            oos.writeObject(veiculos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar veículos: " + e.getMessage());
        }
    }

    public static List<Veiculo> carregarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_VEICULOS))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> listaObjetos = (List<?>) obj;
                boolean todosVeiculos = listaObjetos.stream().allMatch(o -> o instanceof Veiculo);
                if (todosVeiculos) {
                    @SuppressWarnings("unchecked")
                    List<Veiculo> veiculosLidos = (List<Veiculo>) listaObjetos;
                    veiculos.addAll(veiculosLidos);
                } else {
                    System.err.println("A lista contém objetos que não são do tipo Veiculo.");
                }
            } else {
                System.err.println("O objeto lido não é uma lista.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Arquivo de veículos não encontrado ou erro na leitura: " + e.getMessage());
        }
        return veiculos;
    }
}
