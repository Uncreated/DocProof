package com.uncreated.docproof.model.documents.entities;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Page> pages;
    private String thumbnailPath;

    public Document() {
    }

    public static Document createTest(int count) {
        Document document = new Document();

        document.thumbnailPath = "";

        List<Page> pages = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            pages.add(Page.createTest());
        }

        document.setPages(pages);

        return document;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
}
