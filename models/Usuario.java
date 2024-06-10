package  models;

public class Usuario extends Pessoa{
    
    private Long telefone;

    
     public Long getTelefone(){
        return telefone;
    }
    
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        
        return 
            "Nome: " + getNome() +
            " | CPF: " + getCpf() + 
            " | Telefone: " + telefone + "\n";
    }

}
