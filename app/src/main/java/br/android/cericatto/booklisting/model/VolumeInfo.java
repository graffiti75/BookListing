package br.android.cericatto.booklisting.model;

import java.util.List;

/**
 * VolumeInfo.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class VolumeInfo {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private String title;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<IndustryIdentifier> industryIdentifiers;
    private ReadingMode readingModes;
    private Integer pageCount;
    private String printType;
    private String categories;
    private Integer averageRating;
    private Integer ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private ImageLink imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public VolumeInfo(String title, List<String> authors, String publisher, String publishedDate,
        String description, List<IndustryIdentifier> industryIdentifiers, ReadingMode readingModes,
        Integer pageCount, String printType, String categories, Integer averageRating,
        Integer ratingsCount, String maturityRating, Boolean allowAnonLogging,
        String contentVersion, ImageLink imageLinks, String language, String previewLink,
        String infoLink, String canonicalVolumeLink) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModes = readingModes;
        this.pageCount = pageCount;
        this.printType = printType;
        this.categories = categories;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.maturityRating = maturityRating;
        this.allowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "VolumeInfo{" +
            "title='" + title + '\'' +
            ", authors=" + authors +
            ", publisher='" + publisher + '\'' +
            ", publishedDate='" + publishedDate + '\'' +
            ", description='" + description + '\'' +
            ", industryIdentifiers=" + industryIdentifiers +
            ", readingModes=" + readingModes +
            ", pageCount=" + pageCount +
            ", printType='" + printType + '\'' +
            ", categories=" + categories +
            ", averageRating=" + averageRating +
            ", ratingsCount=" + ratingsCount +
            ", maturityRating='" + maturityRating + '\'' +
            ", allowAnonLogging=" + allowAnonLogging +
            ", contentVersion='" + contentVersion + '\'' +
            ", imageLinks=" + imageLinks +
            ", language='" + language + '\'' +
            ", previewLink='" + previewLink + '\'' +
            ", infoLink='" + infoLink + '\'' +
            ", canonicalVolumeLink='" + canonicalVolumeLink + '\'' +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }
    public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ReadingMode getReadingModes() {
        return readingModes;
    }
    public void setReadingModes(ReadingMode readingModes) {
        this.readingModes = readingModes;
    }

    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrintType() {
        return printType;
    }
    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }
    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }
    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public Boolean getAllowAnonLogging() {
        return allowAnonLogging;
    }
    public void setAllowAnonLogging(Boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }
    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLink getImageLinks() {
        return imageLinks;
    }
    public void setImageLinks(ImageLink imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }
    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }
    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }
    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }
}