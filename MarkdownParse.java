//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int openBracket = 0; 
        int closeBracket = 0; 
        int openParen = 0; 
        int closeParen = 0;

        while(currentIndex < markdown.length() 
                && openBracket != -1 
                && closeBracket != -1
                && openParen != -1
                && closeParen != -1) {
                    
            System.out.println("current Index: " + currentIndex);
            openBracket = markdown.indexOf("[", currentIndex);
            closeBracket = markdown.indexOf("]", openBracket);
            openParen = markdown.indexOf("(", closeBracket);
            closeParen = markdown.indexOf(")", openParen);
            System.out.println("openBracket: " + openBracket);
            System.out.println("closeBracket: " + closeBracket);
            System.out.println("openParen: " + openParen);
            System.out.println("closeParen: " + closeParen);
            if (markdown.indexOf("\n") == currentIndex){
                break;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            System.out.println(toReturn.toString());
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
