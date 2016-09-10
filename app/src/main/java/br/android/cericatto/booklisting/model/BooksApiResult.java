package br.android.cericatto.booklisting.model;

import java.util.List;

/**
 * BooksApiResult.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class BooksApiResult {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private String kind;
    private Integer totalItems;
    private List<BookItem> items;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public BooksApiResult(String kind, Integer totalItems, List<BookItem> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    //--------------------------------------------------
    // To String
    //--------------------------------------------------

    @Override
    public String toString() {
        return "BooksApiResult{" +
            "kind='" + kind + '\'' +
            ", totalItems=" + totalItems +
            ", items=" + items +
            '}';
    }

    //--------------------------------------------------
    // Getters and Setters
    //--------------------------------------------------

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<BookItem> getItems() {
        return items;
    }
    public void setItems(List<BookItem> items) {
        this.items = items;
    }
}