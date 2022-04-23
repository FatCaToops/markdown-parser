import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        //ArrayList<String> links = getLinks(content);
	    System.out.println(content);
        System.out.println(content.indexOf("\n"));
    }
}
