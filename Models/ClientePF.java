public class ClientePF extends Cliente {
    private String email;

    public ClientePF(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getIdentificacao() {
        return getCpf();
    }

    @Override
    public String toString() {
        return "ClientePF{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
