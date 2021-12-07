import model.FileType;
import service.TextParser;

public class Main {
    public static void main(String[] args) {


        String filePath = ".\\src\\main\\resources\\input.txt";

        TextParser textParser = new TextParser();
        textParser.parseString(filePath, FileType.XML);

    }
}
