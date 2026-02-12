package edu.bsu.cs222;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Builds a URL by inserting an article title into prewritten API call
 *
 * @author Treyford Mercer
 * @version 0.1.0
 */
public class WikiUrlBuilder {

    public String buildUrl(String articleTitle) {
        // Handles null error
        if (articleTitle == null || articleTitle.isBlank()) {
            throw new IllegalArgumentException("Article title must not be empty");
        }

        // Adds title to pregenerated API lin
        String encodedTitle = encode(articleTitle.trim());
        return "https://en.wikipedia.org/w/api.php" +
                "?action=query" +
                "&format=json" +
                "&prop=revisions" +
                "&titles=" +
                encodedTitle +
                "&rvprop=timestamp|user" +
                "&rvlimit=15" +
                "&redirects";
    }

    /**
     * Helper function that allows spaces to be present in URL
     */
    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
