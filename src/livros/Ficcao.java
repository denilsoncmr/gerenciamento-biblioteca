package livros;

import javax.swing.*;

public class Ficcao extends Livro {
    public Ficcao(int isbn, String name, int pageNumbers, int status) {
        super(isbn, name, pageNumbers, status);
    }

    @Override
    public void setPageNumbers(int pageNumbers){
        this.pageNumbers = pageNumbers;
    }
    @Override
    public String toString() {
        JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL \n" +
                "Genero: Ficção \n" +
                "ISBN: " + this.isbn +
                "\nName: " + this.name +
                "\nPage Numbers: " + this.pageNumbers);
        return "";
    }
}
