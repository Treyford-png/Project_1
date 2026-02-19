package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.util.List;

/**
 * Uses WikiUrlBuilder to create a URL from user input
 * Turns URL into JSON from Wikipedia API using WikiClient
 * NOTE: Treyford Mercer wrote all code, Holden Hankins merely refactored for better testing
 *
 * @author Treyford Mercer
 * @author Holden Hankins
 * @version 0.1.0
 */

public class GetJson {

    public static SwitchString nameToUrl(String articleName) {
        if (articleName == null) {
            return new SwitchString("NULL_NAME", StringOrError.ERROR);
        }
        WikiUrlBuilder urlBuilder = new WikiUrlBuilder();
        String url;
        try {
            url = urlBuilder.buildUrl(articleName);
        } catch (IllegalArgumentException e) {
            return new SwitchString("ERROR", StringOrError.ERROR);
        }
        return new SwitchString(url, StringOrError.STRING);
    }

    /**
     * Takes an article name as a String and attempts to convert into a JSON file
     * @return edit history JSON as a String
     *
     */
    public static SwitchString jsonFromName(String name) {
        // Gets article URL
        SwitchString urlSwitchString = nameToUrl(name);
        String url = urlSwitchString.getString();
        if (urlSwitchString.isStringOrError() == StringOrError.ERROR) {
            if (url.equals("ERROR")) {
                return new SwitchString("Error 408: request timeout", StringOrError.ERROR);
            }
            else {
                return new SwitchString("Error 400: bad request", StringOrError.ERROR);
            }
        }

        WikiClient client = new WikiClient();
        String json;

        // Connects to Wikipedia API
        try {
            json = client.fetchArticleJson(url);
        } catch (IOException e) {
            return new SwitchString("Error 408: request timeout", StringOrError.ERROR);
        }

        // Checks for no page containing wiki article
        try {
            List<String> missing = JsonPath.read(json, "$.query.pages.*.missing");

            if (!missing.isEmpty()) {
                return new SwitchString("Error 404: page not found", StringOrError.ERROR);
            }
        } catch (Exception ignored) {
        }

        return new SwitchString(json, StringOrError.STRING);
    }
}