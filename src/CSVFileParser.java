
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser {
    private List<Book> books;

    public CSVFileParser() {
        this.books = new ArrayList<>();
    }

    public List<Book> loadBooksFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Book book = new Book(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4]);
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
