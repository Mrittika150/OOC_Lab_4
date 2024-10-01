import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLFileParser {
    private List<Book> books;

    public XMLFileParser() {
        this.books = new ArrayList<>();
    }

    public List<Book> loadBooksFromXML(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Book book = new Book(
                    element.getElementsByTagName("title").item(0).getTextContent(),
                    element.getElementsByTagName("author").item(0).getTextContent(),
                    element.getElementsByTagName("genre").item(0).getTextContent(),
                    Integer.parseInt(element.getElementsByTagName("pages").item(0).getTextContent()),
                    element.getElementsByTagName("date_read").item(0).getTextContent()
            );
            books.add(book);
        }
        return books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
