package com.uncreated.docproof.ui.fragments.camera.view;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.uncreated.docproof.model.documents.entities.Page;
import com.uncreated.docproof.ui.fragments.base.BaseFragmentView;

public interface CameraView extends BaseFragmentView {
    @StateStrategyType(OneExecutionStateStrategy.class)
    void goMakePhoto();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goDocument(int index);

    void addPage(Page page);
}
