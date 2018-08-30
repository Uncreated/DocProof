package com.uncreated.docproof.app.di.modules;

import com.uncreated.docproof.model.documents.DocumentRepository;
import com.uncreated.docproof.model.documents.DocumentRepositoryStub;
import com.uncreated.docproof.model.photo.ImageRepository;
import com.uncreated.docproof.model.photo.ImageRepositoryStub;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    public DocumentRepository documentRepository() {
        return new DocumentRepositoryStub();
    }

    @Provides
    public ImageRepository imageRepository() {
        return new ImageRepositoryStub();
    }
}
