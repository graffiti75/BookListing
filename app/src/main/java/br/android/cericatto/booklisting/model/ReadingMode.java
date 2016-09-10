package br.android.cericatto.booklisting.model;

/**
 * ReadingMode.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class ReadingMode {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private Boolean text;
    private Boolean image;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public ReadingMode(Boolean text, Boolean image) {
        this.text = text;
        this.image = image;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "ReadingMode{" +
            "text=" + text +
            ", image=" + image +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public Boolean getText() {
        return text;
    }
    public void setText(Boolean text) {
        this.text = text;
    }

    public Boolean getImage() {
        return image;
    }
    public void setImage(Boolean image) {
        this.image = image;
    }
}