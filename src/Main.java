import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Reading from CSV
        CSVFileParser csvReader = new CSVFileParser();
        try {
            List<Book> csvBooks = csvReader.loadBooksFromCSV("books.csv"); // Specify the correct CSV file path
            System.out.println("Books from CSV:");
            for (Book book : csvBooks) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Genre: " + book.getGenre() + ", Pages: " + book.getPages() +
                        ", Date Read: " + book.getDate_read());
            }
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + e.getMessage());
        }

        // Reading from XML
        XMLFileParser xmlReader = new XMLFileParser();
        try {
            List<Book> xmlBooks = xmlReader.loadBooksFromXML("books.xml"); // Specify the correct XML file path
            System.out.println("\nBooks from XML:");
            for (Book book : xmlBooks) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Genre: " + book.getGenre() + ", Pages: " + book.getPages() +
                        ", Date Read: " + book.getDate_read());
            }
        } catch (Exception e) {
            System.err.println("Error reading from XML file: " + e.getMessage());
        }
    }
}
