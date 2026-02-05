package edu.bsu.cs222;

public class WikiArticle {
    private String articleName;
    private WikiEdit[] editArray = new WikiEdit[15];

    public WikiArticle(String articleName, WikiEdit[] editArray) {
        this.articleName = articleName;

        // Copies given array to object array
        int arrayIterator = 0;
        for (arrayIterator = 0; arrayIterator < editArray.length; arrayIterator++) {
            if (arrayIterator >= 15) { // Should never be activated, just for safety
                break;
            }
            this.editArray[arrayIterator] = editArray[arrayIterator];
        }

        // Fills rest of array, if necessary
        for (int i = arrayIterator; i < 15; i++) {
            this.editArray[i] = null;
        }
    }

    public WikiArticle() {
        articleName = null;
        for (int i = 0; i < 15; i++) {
            editArray[i] = null;
        }
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
