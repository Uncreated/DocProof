package com.uncreated.docproof.ui.fragments.documents.view;

import android.graphics.Bitmap;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.uncreated.docproof.model.documents.entities.Document;
import com.uncreated.docproof.ui.fragments.base.BaseFragmentView;

import java.util.List;

public interface DocumentsView extends BaseFragmentView {
    @StateStrategyType(SingleStateStrategy.class)
    void onDocumentsChanged(List<Document> documents);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void onThumbnailLoaded(Bitmap bitmap, int index);
}
