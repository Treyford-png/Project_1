package edu.bsu.cs222;

public class WikiArticle {
    private final String articleName;
    private final WikiEdit[] editArray = new WikiEdit[15];

    public WikiArticle(String articleName) {
        this.articleName = articleName;

        // Fills array with null edits
        for (int i = 0; i < 15; i++) {
            this.editArray[i] = null;
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
}
