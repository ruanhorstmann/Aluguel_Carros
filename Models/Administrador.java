import java.io.Serializable;

public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String login;
    private transient String senha; 

    public Administrador(String nome, String cpf, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
