import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class test_lab4 {
    @Test
    public void testSnippet1() throws IOException{
        Path filename1 = Path.of("snippet1.md");
        String content1 = Files.readString(filename1);
        ArrayList<String> links1 = MarkdownParse.getLinks(content1);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
                    links1);
    }

    @Test
    public void testSnippet2() throws IOException{
        Path filename1 = Path.of("snippet2.md");
        String content1 = Files.readString(filename1);
        ArrayList<String> links1 = MarkdownParse.getLinks(content1);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), 
                    links1);
    }

    @Test
    public void testSnippet3() throws IOException{
        Path filename1 = Path.of("snippet3.md");
        String content1 = Files.readString(filename1);
        ArrayList<String> links1 = MarkdownParse.getLinks(content1);
        assertEquals(List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"), 
                    links1);
    }
}
