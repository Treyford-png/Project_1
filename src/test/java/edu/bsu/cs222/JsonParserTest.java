package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class JsonParserTest {

    @Test
    public void testJsonParser() throws IOException {
        JsonParser jsonParser = new JsonParser(GetJson.jsonFromName("Verstappen"));
        assert(jsonParser.getArticleName().equals("Max Verstappen"));

    }

}
