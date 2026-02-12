package edu.bsu.cs222;

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