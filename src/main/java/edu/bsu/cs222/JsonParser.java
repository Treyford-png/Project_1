package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import java.util.List;

/**
 * Parses out article name, redirect, and revision history from JSON string
 *
 * @author Holden Hankins
 * @author Treyford Mercer
 * @version 0.1.0
 */
public class JsonParser {
    private String jsonString;
    private WikiArticle article;

    public JsonParser(String jsonString) {
        // End program if JSON isn't made
        if (jsonString == null) {
            return;
        }
        this.jsonString = jsonString;
        // JSONArray to String conversion
        List<String> jsonList = JsonPath.read(jsonString, "$.query.pages.*.title");
        String articleName = convertJsonStr(jsonList);
        boolean redirected = jsonString.contains("Redirect");
        article = new WikiArticle(articleName, redirected);
        populateEditArray();
    }


    public WikiArticle getArticle() {
        return article;
    }

    /**
     * Converts JSON in List<String> form to String
     */
    public String convertJsonStr(List<String> list) {
        return list.getFirst();
    }

    public String getDateString(String timestamp) {
        return timestamp.substring(0, 10);
    }

    public String getTimeString(String timestamp) {
        return timestamp.substring(11);
    }

    /**
     * Uses an edit gathered from JSON to create a WikiEdit class stored in editArray
     */
    public void populateEditArray() {
        WikiEdit edit;
        for (int i = 0; i < 15; i++) {

            // Terminate loop if no more edits are present
            List<String> revisionString = JsonPath.read(jsonString, "$.query.pages.*.revisions[" + i + "]");
            if (revisionString.isEmpty()) {
                return;
            }

            List<String> listUser = JsonPath.read(jsonString, ("$.query.pages.*.revisions[" + i + "].user"));
            List<String> listTimestamp = JsonPath.read(jsonString, ("$.query.pages.*.revisions[" + i + "].timestamp"));

            String user = convertJsonStr(listUser);
            String timestamp = convertJsonStr(listTimestamp);
            String date = getDateString(timestamp);
            String time = getTimeString(timestamp);

            edit = new WikiEdit(user, date, time);
            article.addEditToArray(edit, i);
        }
    }
}