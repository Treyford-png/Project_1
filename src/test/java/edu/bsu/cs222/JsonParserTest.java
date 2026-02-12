package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsonParserTest {
    // 4 edits present in article
    String edit1 = "2019-12-3 22:33:36Z  Bot1058";
    String edit2 = "2015-12-2 02:37:16Z  Dcirovic";
    String edit3 = "2015-07-0 06:24:49Z  Gilliam";
    String edit4 = "2004-03-1 12:44:12Z  Danny";

    @Test
    public void testJsonParser() throws IOException {
        JsonParser jsonParser = new JsonParser(GetJson.jsonFromName("Zionsville"));
        assert(jsonParser.getArticle().getArticleName().equals("Zionsville"));
        System.out.println(jsonParser.getArticle().getWikiEdit(0).getOutput());
        assert(jsonParser.getArticle().getWikiEdit(0).getOutput().equals(edit1));
        assert(jsonParser.getArticle().getWikiEdit(1).getOutput().equals(edit2));
        assert(jsonParser.getArticle().getWikiEdit(2).getOutput().equals(edit3));
        assert(jsonParser.getArticle().getWikiEdit(3).getOutput().equals(edit4));
    }
}