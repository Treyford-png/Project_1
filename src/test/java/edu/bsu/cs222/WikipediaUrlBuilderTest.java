package edu.bsu.cs222;
import edu.bsu.cs222.WikipediaUrlBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class WikipediaUrlBuilderTest {
    @Test
    void buildsUrlWithSpaces() {
        WikipediaUrlBuilder builder = new WikipediaUrlBuilder();
        String url = builder.buildUrl("Frank Zappa");

        assertTrue(url.contains("titles=Frank+Zappa"));
    }
    @Test
    void buildsUrlWithLowercase() {
        WikipediaUrlBuilder builder = new WikipediaUrlBuilder();
        String url = builder.buildUrl("frank zappa");
        assertTrue(url.contains("titles=frank+zappa"));
    }
    @Test
    void throwsExceptionForBlankTitle() {
        WikipediaUrlBuilder builder = new WikipediaUrlBuilder();
        assertThrows(IllegalArgumentException.class,
                () -> builder.buildUrl("   "));
    }
}

