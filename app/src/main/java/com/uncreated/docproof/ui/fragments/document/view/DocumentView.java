package com.uncreated.docproof.ui.fragments.document.view;

import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.ui.fragments.base.BaseFragmentView;

public interface DocumentView extends BaseFragmentView {
    void onDocument(Document document);
}
