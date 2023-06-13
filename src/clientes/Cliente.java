package clientes;

import livros.Livro;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private ArrayList<Livro> livros = new ArrayList();

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }
}
