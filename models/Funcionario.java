package models;
public class Funcionario extends Pessoa{
    
    
    private String matricula;


    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        
        return 
            "Nome: " + getNome() +
            " | CPF: " + getCpf() + 
            " | Matricula: " + matricula;
    }
}
