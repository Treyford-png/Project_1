package edu.bsu.cs222;


import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class GetJsonTest {

    @Test
    public void testGetJson() {
        // Check to verify correct page ID was gathered and page ID is in correct location
        String jsonString = GetJson.jsonFromName("Zionsville").getString();
        assert(jsonString.substring(57, 63).equals("528332"));
    }

    @Test
    public void testGetJsonRedirect() {
        // Check to verify correct page ID was gathered and page ID is in correct location
        String jsonString = GetJson.jsonFromName("zionsville").getString();
        assert(jsonString.substring(112, 118).equals("528332"));
    }

    @Test
    public void testGetJsonNull() {
        assert (GetJson.jsonFromName("").isStringOrError() == StringOrError.ERROR);
    }
}