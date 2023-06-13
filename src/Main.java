import java.util.ArrayList;

import javax.swing.JOptionPane;

import clientes.Cliente;
import library.Biblioteca;
import livros.Livro;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> livrosCadastrados = new ArrayList();
        ArrayList<Livro> livrosEmprestados = new ArrayList();
        ArrayList<Cliente> clientes = new ArrayList();
        Biblioteca biblioteca = new Biblioteca();
        int opcao = 0;
        while(opcao != 6){
            opcao = biblioteca.menu();
            switch (opcao){
                case 1:
                    Livro livro = biblioteca.cadastrarLivro(livrosCadastrados);
                    if(livro != null)
                        livrosCadastrados.add(livro);
                    break;
                case 2:
                    if(livrosCadastrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL \n" +
                                "Não há livros cadastrados");
                    }else{
                        livrosCadastrados = biblioteca.removerLivro(livrosCadastrados);
                    }
                    break;
                case 3:
                    clientes.add(biblioteca.cadastrarCliente());
                    break;
                case 4:
                    biblioteca.livrosDisponiveis(livrosCadastrados);
                    break;
                case 5:
                    livro = biblioteca.emprestaLivro(livrosCadastrados,clientes);
                    if(livro != null){
                        livrosEmprestados.add(livro);
                    }
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"BIBLIOTECA CENTRAL \n"+
                            "Opção Inválida! Tente novamente!");
            }

        }
    }
}
