package br.android.cericatto.booklisting.model;

/**
 * EPub.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class EPub {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private Boolean isAvailable;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public EPub(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "EPub{" +
            "isAvailable=" + isAvailable +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}