/**
 * javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
 * java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
 */

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParseTest {
    /* @Test
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
    } */

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