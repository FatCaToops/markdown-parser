//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://github.com/YoavGutmanUCSD/markdown-parser-2

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseReview {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int exclamation = markdown.indexOf("!", currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen + 1 <= currentIndex){
                break;
            }
            String returnable = markdown.substring(openParen + 1, closeParen); 
            // if(returnable.indexOf(" ") != -1){
            //     continue;
            // }
            toReturn.add(returnable); 
            // System.out.println("openParen:"+"   "+openParen);
            // System.out.println("closeParen:"+"   "+closeParen);
            // System.out.println("index:"+"   "+currentIndex);
            if((exclamation + 1 == openBracket&&exclamation!=-1 ) || returnable.indexOf(" ") != -1){
                toReturn.remove(returnable);
                //System.out.println("aaaaaa");
            }
            // else if(returnable.indexOf(" ") != -1){
            //     toReturn.remove(returnable);
            //     //System.out.println("aaaaaa");
            // }
            
            currentIndex = closeParen + 1;
           // System.out.println(currentIndex);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
