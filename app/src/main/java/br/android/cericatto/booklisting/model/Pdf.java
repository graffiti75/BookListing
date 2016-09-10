package br.android.cericatto.booklisting.model;

/**
 * Pdf.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class Pdf {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private Boolean isAvailable;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public Pdf(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "Pdf{" +
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