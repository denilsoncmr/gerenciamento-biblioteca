package livros;

import clientes.Cliente;

public abstract class Livro {
    protected int isbn;
    protected String name;
    protected int pageNumbers;
    protected Cliente cliente;
    protected int status;

    public Livro(int isbn, String name, int pageNumbers, int status) {
        this.isbn = isbn;
        this.name = name;
        this.pageNumbers = pageNumbers;
        this.status = status;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
