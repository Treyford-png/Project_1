package edu.bsu.cs222;

/**
 * Main method for program
 * Asks user for article -> gets JSON from Wikipedia relating to said article -> prints out last 15 edits
 *
 * @author Holden Hankins
 * @author Treyford Mercer
 * @version 0.1.0
 */
public class GetWikiEditHistory {
    public static void main(String[] args) {
        // User Query -> JSON file
        String articleName = GetJson.getUserInput();
        String jsonAsString = GetJson.jsonFromName(articleName);

        // Ends program if exception
        if (jsonAsString == null) {
            return;
        }

        // Prints top edits from article formated "yyyy-mm-dd hh:mm:ssZ  username"
        JsonParser jsonParser = new JsonParser(jsonAsString);
        jsonParser.getArticle().print();
    }
}