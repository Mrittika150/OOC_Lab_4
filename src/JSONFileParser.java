
import java.io.FileReader;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;
public class JSONFileParser implements  BookParser{
    private JSONFileParser() {
    }

    public static JSONFileParser createJSONFileParser() {
        return new JSONFileParser();
    }

    public void readFile(){

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("c:\\file.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            String title = (String) jsonObject.get("title");

            String author = (String) jsonObject.get("author");

            String genre = (String) jsonObject.get("genre");



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Book> parse(String filepath) throws Exception {
        return List.of();
    }
}

