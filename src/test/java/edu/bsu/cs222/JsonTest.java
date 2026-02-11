package edu.bsu.cs222;


public class JsonTest {
    /**
     * Because GetJson uses user input, it is impossible to test using asserts
     * It is also really annoying to set a String to a preassigned JSON output because of the chars
     * So we are testing it by comparing the output to files stored in test.docs
     */

    public void main() {
        /*
         * Test 1 - correct name - "Max Verstappen" - Max Verstappen.json
         * Test 2 - redirect name - "verstappen" - verstappen.json
         * Test 3 -
         * Tets 4 -
         */
        GetJson getAJson = new GetJson();
        getAJson.getJson();
    }
}