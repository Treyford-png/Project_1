package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WikiUrlBuilderTest {
    @Test
    void buildsUrlWithSpaces() {
        WikiUrlBuilder builder = new WikiUrlBuilder();
        String url = builder.buildUrl("Frank Zappa");

        assertTrue(url.contains("titles=Frank+Zappa"));
    }
    @Test
    void buildsUrlWithLowercase() {
        WikiUrlBuilder builder = new WikiUrlBuilder();
        String url = builder.buildUrl("frank zappa");
        assertTrue(url.contains("titles=frank+zappa"));
    }
    @Test
    void throwsExceptionForBlankTitle() {
        WikiUrlBuilder builder = new WikiUrlBuilder();
        assertThrows(IllegalArgumentException.class,
                () -> builder.buildUrl("   "));
    }
}

