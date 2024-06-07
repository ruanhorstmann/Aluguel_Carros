package views;

public class Main {
    
    public static void main (String[] args) {
        int opc = 0;

    do {
        System.out.println(" ___________________________________");
        System.out.println("|                                   |");
        System.out.println("|              M E N U              |");
        System.out.println("|___________________________________|");
        System.out.println("|                                   |");
        System.out.println("|      1 - Cadastrar Usuário        |");
        System.out.println("|      2 - Listar Usuários          |");
        System.out.println("|      3 - Cadastrar Funcionários   |");
        System.out.println("|      4 - Listar Funcionários      |");
        System.out.println("|      5 - Cadastrar Carro          |");
        System.out.println("|      6 - Listar Carros            |");
        System.out.println("|      7 - Registar um aluguel      |");
        System.out.println("|      8 - Carros Alugados          |");
        System.out.println("|      9 - Devolver Carro           |");
        System.out.println("|     10 - Remover Carro            |");
        System.out.println("|     11 - Atualizar Carro          |");
        System.out.println("|     12 - Cancelar Cadastro        |");
        System.out.println("|                                   |");
        System.out.println("|             0 - SAIR              |");
        System.out.println("|___________________________________|");
        opc = Console.readInt("\n Digite a opção desejada: ");