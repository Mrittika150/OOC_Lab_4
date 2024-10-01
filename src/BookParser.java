import java.util.List;

public interface BookParser {
    List<Book> parse(String filepath) throws  Exception;

}
