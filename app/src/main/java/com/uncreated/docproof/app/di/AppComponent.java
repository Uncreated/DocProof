package com.uncreated.docproof.app.di;


import com.uncreated.docproof.app.di.modules.AppModule;
import com.uncreated.docproof.app.di.modules.RepositoryModule;
import com.uncreated.docproof.ui.fragments.camera.presenter.CameraPresenter;
import com.uncreated.docproof.ui.fragments.document.presenter.DocumentPresenter;
import com.uncreated.docproof.ui.fragments.documents.presenter.DocumentsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(DocumentsPresenter documentsPresenter);

    void inject(DocumentPresenter documentPresenter);

    void inject(CameraPresenter cameraPresenter);
}
