import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testgetLink() throws IOException{
        Path filename1 = Path.of("test-file.md");
        String content1 = Files.readString(filename1);
        ArrayList<String> links1 = MarkdownParse.getLinks(content1);
        assertEquals(List.of("https://something.com", "some-page.html"), 
                    links1);

        Path filename2 = Path.of("test-file11.md");
        String content2 = Files.readString(filename2);
        ArrayList<String> links2 = MarkdownParse.getLinks(content2);
        assertEquals(List.of(), 
                    links2);

        Path filename3 = Path.of("test-file22.md");
        String content3 = Files.readString(filename3);
        ArrayList<String> links3 = MarkdownParse.getLinks(content3);
        assertEquals(List.of("https://something.com", "https://some-thing.html"), 
                    links3);

        Path filename4 = Path.of("test-file33.md");
        String content4 = Files.readString(filename4);
        ArrayList<String> links4 = MarkdownParse.getLinks(content4);
        assertEquals(List.of("https://something.com"), 
                    links4);
    }

    @Test
    public void testgetLink2() throws IOException{
        Path filename2 = Path.of("test-file2.md");
        String content2 = Files.readString(filename2);
        ArrayList<String> links2 = MarkdownParse.getLinks(content2);
        assertEquals(List.of("https://something.com", "some-page.html"), 
                    links2);
    }

    @Test
    public void testgetLink3() throws IOException{
        Path filename = Path.of("test-file2.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), 
                    links);
    }

    @Test
    public void testgetLink4() throws IOException{
        Path filename = Path.of("test-file4.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), 
                    links);
    }

    @Test
    public void testgetLink5() throws IOException{
        Path filename = Path.of("test-file5.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), 
                    links);
    }

    @Test
    public void testgetLink6() throws IOException{
        Path filename = Path.of("test-file6.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), 
                    links);
    }

    @Test
    public void testgetLink7() throws IOException{
        Path filename = Path.of("test-file7.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), 
                    links);
    }

    @Test
    public void testgetLink8() throws IOException{
        Path filename = Path.of("test-file8.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(""), 
                    links);
    }
}