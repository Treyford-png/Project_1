package edu.bsu.cs222;

import static edu.bsu.cs222.StringOrError.ERROR;

/**
 * Stores a Wikipedia article's name, if a redirect, and most recent revisions
 *
 * @author Holden Hankins
 * @author Treyford Mercer
 * @version 0.1.0
 */
public class WikiArticle {
    private final String articleName;
    private final WikiEdit[] editArray = new WikiEdit[15];
    private boolean redirected;
    private SwitchString switchString;

    public WikiArticle(String articleName, boolean redirected,SwitchString switchString) {
        this.articleName = articleName;
        this.redirected = redirected;
        // Fills array with null edits
        for (int i = 0; i < 15; i++) {
            this.editArray[i] = new WikiEdit();
        }
        this.switchString = switchString;
    }

    public WikiArticle() {
        articleName = null;
        for (int i = 0; i < 15; i++) {
            editArray[i] = null;
        }
    }

    public WikiEdit getWikiEdit(int index) {
        return editArray[index];
    }

    public void addEditToArray(WikiEdit edit, int index) {
        editArray[index] = edit;
    }

    public String getArticleName() {
        return articleName;
    }

    public WikiEdit getEditAtIndex(int index) {
        return editArray[index];
    }

    public String print() {
        if (switchString.isStringOrError() == ERROR) {
            return switchString.getString();
        }
        StringBuilder printStr = new StringBuilder();
        if (redirected) {
            printStr.append("Redirects to ").append(getArticleName()).append("\n\n");
        }


        for (int i = 0; i < 15; i++) {
            printStr.append(i + 1).append("  ").append(getEditAtIndex(i).getOutput());
        }

        return "" + printStr;
    }
}
