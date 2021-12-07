import model.FileType;
import service.TextParser;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String filePath = ".\\src\\main\\resources\\input.txt";

        TextParser textParser = new TextParser();
        textParser.parseString(filePath, FileType.XML);
        textParser.parseString(filePath, FileType.CSV);

    }
}
