package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Wikipedia article name: ");
        String articleName = scanner.nextLine();

        if (articleName == null || articleName.isBlank()) {
            System.err.println("Error: No article name provided.");
            return;
        }

        WikipediaUrlBuilder urlBuilder = new WikipediaUrlBuilder();
        String url;

        try {
            url = urlBuilder.buildUrl(articleName);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid article name.");
            return;
        }

        WikipediaClient client = new WikipediaClient();
        String json;

        try {
            json = client.fetchArticleJson(url);
        } catch (IOException e) {
            System.err.println("Error: Network error while contacting Wikipedia.");
            return;
        }

        // Handle the missing pages
        try {
            List<String> missing =
                    JsonPath.read(json, "$.query.pages.*.missing");

            if (!missing.isEmpty()) {
                System.err.println("Error: No Wikipedia page found for that article.");
                return;
            }
        } catch (Exception ignored) {
        }
        try {
            List<String> redirects =
                    JsonPath.read(json, "$.query.redirects[*].to");

            if (!redirects.isEmpty()) {
                System.out.println("Redirected to " + redirects.get(0));
            }
        } catch (Exception ignored) {
        }
        System.out.println(json);
    }
}
