package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonParser {
    private final String jsonString;
    private final WikiArticle article;

    public JsonParser(String jsonString) {
        this.jsonString = jsonString;

        // JSONArray to String conversion
        List<String> jsonList = JsonPath.read(jsonString, "$.query.pages.*.title");
        String articleName = convertJsonStr(jsonList);

        article = new WikiArticle(articleName);
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
        return timestamp.substring(0, 9);
    }

    public String getTimeString(String timestamp) {
        return timestamp.substring(11, 19);
    }

    public void populateEditArray() {
        WikiEdit edit;
        for (int i = 0; i < 15; i++) {
            System.out.println(i);

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