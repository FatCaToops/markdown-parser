//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        
        int currentIndex = 0;
        //no image
        if((markdown.indexOf("!") < 0) && (markdown.indexOf("](") > 0)){
            //System.out.println("go to here");
            while(currentIndex < markdown.length()) {
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                if(openBracket > 0){
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                }
                else{
                    break;
                }
                currentIndex = closeParen + 1;
            }
        }
        // there is image or ! between bracket
        else if(markdown.indexOf("!") > 0){
            //System.out.println("2");
            int exclamation = markdown.indexOf("!", currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            //! between bracket
            if(exclamation > openBracket && exclamation < closeBracket){
                while(currentIndex < markdown.length()) {
                    exclamation = markdown.indexOf("!", currentIndex);
                    openBracket = markdown.indexOf("[", currentIndex);
                    closeBracket = markdown.indexOf("]", openBracket);
                    int openParen = markdown.indexOf("(", closeBracket);
                    int closeParen = markdown.indexOf(")", openParen);

                    if(exclamation > openBracket && openBracket > 0){
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                    }
                    else{
                        break;
                    }
                    currentIndex = closeParen + 1;
                    //just skip this image link
                }
            }
        }
        //another way of using internet link
        else if(markdown.indexOf("]:") > 0){
            //System.out.println("3");
            while(currentIndex < markdown.length()) {
                currentIndex = markdown.indexOf(":", currentIndex);
                int nextLine = markdown.indexOf("\n", currentIndex);
                /* System.out.println("currentIndex " + currentIndex);
                System.out.println("nextLine " + nextLine); */
                /* [Link][1]
                
                [1]:https://something.com */

                toReturn.add(markdown.substring(currentIndex + 1, nextLine - 1));

                currentIndex = nextLine + 1;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        if(args[0].indexOf(".md") < 0){
            File directory = new File(args[0]);
            File[] filesList = directory.listFiles();
            for(File file:filesList){
                Path fileName = Path.of(file.toString());
                String content = Files.readString(fileName);
                ArrayList<String> links = getLinks(content);
                System.out.println(links);
            }
        }
        else{
            Path fileName = Path.of(args[0]);
            String content = Files.readString(fileName);
            ArrayList<String> links = getLinks(content);
            System.out.println(links);
        }
    }
}
