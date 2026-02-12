package edu.bsu.cs222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Connects to Wikipedia API client and fetches JSON as a String
 *
 * @author Treyford Mercer
 * @author Holden Hankins
 * @version 0.1.0
 */
public class WikiClient {

    // User Agent requested by Wikipedia
    private static final String USER_AGENT =
            "RevisionReporters/0.1 (Holden, Treyford)";

    public String fetchArticleJson(String urlString) throws IOException {
        // Connects to Wikipedia article's API using URL obtained in WikiUrlBuilder
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", USER_AGENT);

        // Reads stream directly from Wikipedia API
        try (InputStream inputStream = connection.getInputStream();
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            // Creates JSON from stream
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            return json.toString();
        }
    }
}
