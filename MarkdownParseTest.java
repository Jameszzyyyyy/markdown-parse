import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException{
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
    @Test
    public void TestFile2() throws IOException{
        String contents = Files.readString(Path.of("./test-file2.md"));
        List<String> expect = new ArrayList<String>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("./test-file3.md"));
        List<String> expect = new ArrayList<String>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile4() throws IOException{
        String contents = Files.readString(Path.of("./test-file5.md"));
        List<String> expect = new ArrayList<String>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet1() throws IOException{
        String contents = Files.readString(Path.of("./snippet1.md"));
        List<String> expect = List.of("`google.come", "google.com", "ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException{
        String contents = Files.readString(Path.of("./snippet2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException{
        String contents = Files.readString(Path.of("./snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", "github.com", "https://cse.ucsd.edu/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}
