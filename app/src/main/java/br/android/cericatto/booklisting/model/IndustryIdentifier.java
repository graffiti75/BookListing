package br.android.cericatto.booklisting.model;

/**
 * IndustryIdentifier.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class IndustryIdentifier {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private String type;
    private String identifier;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public IndustryIdentifier(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "IndustryIdentifier{" +
            "type='" + type + '\'' +
            ", identifier='" + identifier + '\'' +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}