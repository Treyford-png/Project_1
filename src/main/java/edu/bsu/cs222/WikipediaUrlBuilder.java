package edu.bsu.cs222;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WikipediaUrlBuilder {

    private static final String API_ENDPOINT =
            "https://en.wikipedia.org/w/api.php";

    public String buildUrl(String articleTitle) {
        if (articleTitle == null || articleTitle.isBlank()) {
            throw new IllegalArgumentException("Article title must not be empty");
        }

        String encodedTitle = encode(articleTitle.trim());

        return API_ENDPOINT +
                "?action=query" +
                "&format=json" +
                "&prop=revisions" +
                "&titles=" + encodedTitle +
                "&rvprop=timestamp|user" +
                "&rvlimit=15" +
                "&redirects";
    }

    private String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
