package com.uncreated.docproof.ui.fragments.documents.view;

import android.graphics.Bitmap;

import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.ui.fragments.base.BaseFragmentView;

import java.util.List;

public interface DocumentsView extends BaseFragmentView {
    void onDocumentsChanged(List<Document> documents);

    void onThumbnailLoaded(Bitmap bitmap, int index);
}
