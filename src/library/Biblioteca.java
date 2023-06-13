package library;

import clientes.Cliente;
import livros.*;

import javax.swing.*;
import java.util.ArrayList;

public class Biblioteca {

    public int menu() {
        return Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL  \n" +
                "1 - Cadastrar Livro \n" +
                "2 - Remover Livro \n" +
                "3 - Cadastrar Cliente \n" +
                "4 - Livros Disponiveis \n" +
                "5 - Emprestar Livro \n" +
                "6 - Sair \n"
        ));
    }

    private int selecionarGenero() {
        return Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n" +
                "Selecione o genêro do livro \n" +
                "1 - Auto Ajuda \n" +
                "2 - Ficção \n" +
                "3 - Infantil \n" +
                "4 - Romance \n" +
                "5 - Terror \n"
        ));
    }
    public String pegaNome(){
        return JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Insira o nome do livro:");
    }
    public int pegaISBN(){
        return Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Insira o ISBN do livro:"));
    }
    public int pegaNumeroDePaginas(){
        return Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Insira o número de páginas do livro:"));
    }
    public String nomeCliente(){
        return JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Insira o nome do cliente:");
    }
    public String emailCliente(){
        return JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Insira o email do cliente:");
    }
    public String cpfCliente(){
        return JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Insira o CPF:");
    }
    public Livro cadastrarLivro(ArrayList<Livro> estoque) {
        int genero = selecionarGenero();
        switch (genero) {
            case 1:
                AutoAjuda autoAjuda = new AutoAjuda(pegaISBN(), pegaNome(), pegaNumeroDePaginas(), 1);
                for (Livro livro : estoque) {
                    if(livro.getIsbn() == autoAjuda.getIsbn()){
                        JOptionPane.showMessageDialog(null, "Um livro com esse ISBN "+
                                "já está cadastrado");
                        return null;
                    }
                }
                return autoAjuda;
            case 2:
                Ficcao ficcao = new Ficcao(pegaISBN(), pegaNome(), pegaNumeroDePaginas(), 1);
                for (Livro livro : estoque) {
                    if(livro.getIsbn() == ficcao.getIsbn()){
                        JOptionPane.showMessageDialog(null, "Um livro com esse ISBN"+
                                "já está cadastrado");
                        return null;
                    }
                }
                return ficcao;
            case 3:
                Infantil infantil = new Infantil(pegaISBN(), pegaNome(), pegaNumeroDePaginas(), 1);
                for (Livro livro : estoque) {
                    if(livro.getIsbn() == infantil.getIsbn()){
                        JOptionPane.showMessageDialog(null, "Um livro com esse ISBN"+
                                "já está cadastrado");
                        return null;
                    }
                }
                return infantil;
            case 4:
                Romance romance = new Romance(pegaISBN(), pegaNome(), pegaNumeroDePaginas(), 1);
                for (Livro livro : estoque) {
                    if(livro.getIsbn() == romance.getIsbn()){
                        JOptionPane.showMessageDialog(null, "Um livro com esse ISBN"+
                                "já está cadastrado");
                        return null;
                    }
                }
                return romance;
            case 5:
                Terror terror = new Terror(pegaISBN(), pegaNome(), pegaNumeroDePaginas(), 1);
                for (Livro livro : estoque) {
                    if(livro.getIsbn() == terror.getIsbn()){
                        JOptionPane.showMessageDialog(null, "Um livro com esse ISBN"+
                                "já está cadastrado");
                        return null;
                    }
                }
                return terror;
            default:
                JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL \n" +
                        "Opção Inválida!Tente novamente");
        }
        return cadastrarLivro(estoque);
    }
    public ArrayList<Livro> removerLivro(ArrayList<Livro> estoque){
        int ibsn = Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL \n"+
                "Informe o ISBN do livro que deseja remover:"));
        for (Livro livro : estoque) {
            if (livro.getStatus() == 0 && livro.getIsbn() == ibsn) {
                JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL \n" +
                        "O livro está emprestado no momento! Impossível removê-lo");
                return null;
            } else if (livro.getStatus() == 1 && livro.getIsbn() == ibsn) {
                JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL \n" +
                        "O livro " + livro.getName() + " foi removido!");
                estoque.remove(livro);
                return estoque;
            }
        }
        return null;
    }
    public Cliente cadastrarCliente(){
        Cliente cliente = new Cliente(nomeCliente(), cpfCliente(), emailCliente());
        return cliente;
    }
    public void livrosDisponiveis(ArrayList<Livro> estoque){
        for (Livro livro: estoque) {
            if(livro.getStatus() == 1){
                livro.toString();
            }
        }
    }
    public Livro emprestaLivro(ArrayList<Livro> estoque, ArrayList<Cliente> clientes){
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL  \n" +
                "Deseja ver os livros disponiveis primeiro?" +
                "\n1 - Sim" +
                "\n2 - Não"));
        if (opcao == 1){
            livrosDisponiveis(estoque);
        } else if(opcao == 2){
            int isbn = Integer.parseInt(JOptionPane.showInputDialog("BIBLIOTECA CENTRAL  \n" +
                    "Insira o ISBN do livro desejado: "));
            String cpf = JOptionPane.showInputDialog("BIBLIOTECA CENTRAL  \n" +
                    "Informe o CPF do cliente: ");
            for (Cliente cliente : clientes) {
                if(cliente.getCpf().equals(cpf)){
                    for (Livro livros : estoque) {
                        if (livros.getIsbn() == isbn){
                            livros.setCliente(cliente);
                            cliente.getLivros().add(livros);
                            JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL  \n" +
                                    "O livro "+ livros.getName() + "foi emprestado para "+ cliente.getNome());
                            livros.setStatus(0);
                            return livros;
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL  \n" +
                            "CPF invalido ou cliente não encontrado");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"BIBLIOTECA CENTRAL  \n" +
                    "Opção Inválida! Tente novamente!");
            emprestaLivro(estoque, clientes);
        }
    return null;
    }
}
