package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GetJson {

    /**
     * All code originally written by Treyford Mercer as Main.java
     * Refactored into Json.java by Holden Hankins to allow for implementation of parsing
     * Check GitHub commit history for more information on blame
     */

    public static String getJson() {
        // Creates Wikipedia API URL
        WikiUrlBuilder urlBuilder = new WikiUrlBuilder();
        String articleName = getUserInput();

        // Create URL
        String url = nameToUrl(articleName);
        if (url == null) { // Catches and handles invalid article name
            return null;
        }

        WikiClient client = new WikiClient();
        String json;

        try {
            json = client.fetchArticleJson(url);
        } catch (IOException e) {
            System.err.println("Error: Network error while contacting Wikipedia.");
            return null;
        }
        try {
            List<String> missing =
                    JsonPath.read(json, "$.query.pages.*.missing");

            if (!missing.isEmpty()) {
                System.err.println("Error: No Wikipedia page found for that article.");
                return null;
            }
        } catch (Exception ignored) {}

        try {
            List<String> redirects =
                    JsonPath.read(json, "$.query.redirects[*].to");
            if (!redirects.isEmpty()) {
                System.out.println("Redirected to " + redirects.get(0));
            }
        } catch (Exception ignored) {}

        System.out.println(json);
        return json;
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Wikipedia article name: ");
        String articleName = scanner.nextLine();

        if (articleName == null || articleName.isBlank()) {
            System.err.println("Error: No article name provided.");
            return getUserInput();
        }
        return articleName;
    }

    public static String nameToUrl(String articleName) {
        WikiUrlBuilder urlBuilder = new WikiUrlBuilder();

        String url;
        try {
            url = urlBuilder.buildUrl(articleName);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid article name.");
            return null;
        }
        return url;
    }
}
