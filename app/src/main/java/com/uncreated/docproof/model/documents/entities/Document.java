package com.uncreated.docproof.model.documents.entities;

import java.util.List;

public class Document {
    private List<Page> pages;

    public Document() {
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
