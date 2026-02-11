package edu.bsu.cs222;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
