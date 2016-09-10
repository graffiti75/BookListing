package br.android.cericatto.booklisting.model;

/**
 * SearchInfo.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class SearchInfo {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private String textSnippet;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public SearchInfo(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "SearchInfo{" +
            "textSnippet=" + textSnippet +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public String getTextSnippet() {
        return textSnippet;
    }
    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }
}