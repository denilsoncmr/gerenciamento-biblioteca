package livros;

import javax.swing.*;

public class Romance extends Livro {
    public Romance(int isbn, String name, int pageNumbers, int status) {
        super(isbn, name, pageNumbers, status);
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    @Override
    public String toString() {
        JOptionPane.showMessageDialog(null, "BIBLIOTECA CENTRAL \n" +
                "Genero: Auto Juda \n" +
                "ISBN: " + this.isbn +
                "\nName: " + this.name +
                "\nPage Numbers: " + this.pageNumbers);
        return "";
    }
}
