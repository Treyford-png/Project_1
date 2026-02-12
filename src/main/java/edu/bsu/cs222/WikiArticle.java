package edu.bsu.cs222;

public class WikiArticle {
    private final String articleName;
    private final WikiEdit[] editArray = new WikiEdit[15];
    private  boolean redirected;

    public WikiArticle(String articleName, boolean redirected) {
        this.articleName = articleName;
        this.redirected = redirected;
        // Fills array with null edits
        for (int i = 0; i < 15; i++) {
            this.editArray[i] = new WikiEdit();
        }
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

    public void print() {
        if (redirected) {
            System.out.println("Redirects to " + getArticleName());
        }
        for (int i = 0; i < 15; i++) {
            if (!getEditAtIndex(i).doesExists()) {
                break;
            }
            System.out.println(i + "  " + getEditAtIndex(i).getOutput());
        }
    }
}
