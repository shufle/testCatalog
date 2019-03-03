package com.example.testCatalog.model;

public class BookInfo {
    private long ID;
    private String title;
    private String authorName;

    public BookInfo(long ID, String title, String authorName) {
        this.ID = ID;
        this.title = title;
        this.authorName = authorName;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
