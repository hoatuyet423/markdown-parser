import static org.junit.Assert.*;
import java.io.IOException;
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
    public void testLinks() throws IOException{
        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("https://something.com, some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        assertEquals(expectedResult, links);

    }
}
