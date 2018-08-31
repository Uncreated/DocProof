package com.uncreated.docproof.model.documents.entities;

public class Page {
    private String thumbnailPath;
    private String imagePath;

    public Page() {
    }

    public static Page createTest() {
        Page page = new Page();

        page.thumbnailPath = "";
        page.imagePath = "";

        return page;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
