package livros;

import javax.swing.*;

public class Terror extends Livro {
    public Terror(int isbn, String name, int pageNumbers, int status) {
        super(isbn, name, pageNumbers, status);
    }

    @Override
    public void setPageNumbers(int pageNumbers){
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
