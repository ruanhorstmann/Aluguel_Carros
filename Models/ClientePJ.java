public class ClientePJ extends Cliente {
    private String cnpj;
    private String nomeFantasia;

    public ClientePJ(String nome, String cpf, String cnpj, String nomeFantasia) {
        super(nome, cpf);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String getIdentificacao() {
        return getCnpj();
    }

    @Override
    public String toString() {
        return "ClientePJ{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                '}';
    }
}
