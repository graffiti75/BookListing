package br.android.cericatto.booklisting.model;

/**
 * SaleInfo.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class SaleInfo {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private String country;
    private String saleability;
    private Boolean isEbook;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public SaleInfo(String country, String saleability, Boolean isEbook) {
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "SaleInfo{" +
            "country='" + country + '\'' +
            ", saleability='" + saleability + '\'' +
            ", isEbook=" + isEbook +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }
    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public Boolean getEbook() {
        return isEbook;
    }
    public void setEbook(Boolean ebook) {
        isEbook = ebook;
    }
}