package edu.bsu.cs222;

/**
 * Allows for handling of error codes and strings in the same object
 * Prevents formatting errors
 *
 * @author Holden Hankins
 * @author Treyford Mercer
 */
public class SwitchString {
    private String str;
    private StringOrError stringOrError;

    public SwitchString(String str, StringOrError stringOrError) {
        this.str = str;
        this.stringOrError = stringOrError;
    }

    public String getString() {
        return str;
    }

    public StringOrError isStringOrError() {
        return stringOrError;
    }

    public void append(String strToAdd) {
        str += strToAdd;
    }

    public void replace(String str, StringOrError stringOrError) {
        this.str = str;
        this.stringOrError = stringOrError;
    }
}