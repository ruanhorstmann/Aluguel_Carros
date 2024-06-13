package models;
import java.util.ArrayList;

public class Emprestimo{

    public Emprestimo(){
        usuario = new Usuario();
        funcionario = new Funcionario();
        livros = new ArrayList<ItemCarro>();
    }


    private Usuario usuario;
    // private Livro livro;
    private Funcionario funcionario;
    private ArrayList<ItemCarro> livros;

    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    // public Livro getLivro(){
    //     return livro;
    // }
    // public void setLivro(Livro livro){
    //     this.livro = livro;
    // }

    public Funcionario getFuncionario(){
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public ArrayList<ItemCarro> getLivros(){
        return livros;
    }
    public void setLivros(ArrayList<ItemCarro> livros){
        this.livros = livros;
    }

    @Override
    public String toString() {
        
        return 
            "Nome Usuario: " + usuario.getNome() +
            // " | Titulo livro: " + livro.getTitulo() + 
            " | Funcionario Responsavel: " + funcionario.getNome();
    }
}
