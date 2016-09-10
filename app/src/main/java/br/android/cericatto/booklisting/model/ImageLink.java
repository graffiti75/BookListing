package br.android.cericatto.booklisting.model;

/**
 * ImageLink.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class ImageLink {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private String smallThumbnail;
    private String thumbnail;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public ImageLink(String smallThumbnail, String thumbnail) {
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "ImageLink{" +
            "smallThumbnail='" + smallThumbnail + '\'' +
            ", thumbnail='" + thumbnail + '\'' +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public String getSmallThumbnail() {
        return smallThumbnail;
    }
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}