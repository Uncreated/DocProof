package com.uncreated.docproof.app.di.modules;

import com.uncreated.docproof.model.documents.DocumentRepository;
import com.uncreated.docproof.model.documents.DocumentRepositoryStub;
import com.uncreated.docproof.model.documents.TempDocumentRepository;
import com.uncreated.docproof.model.documents.TempDocumentRepositoryStub;
import com.uncreated.docproof.model.photo.ImageRepository;
import com.uncreated.docproof.model.photo.ImageRepositoryStub;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class RepositoryModule {

    //TODO
    private final DocumentRepository documentRepository;
    private final TempDocumentRepository tempDocumentRepository;
    private final ImageRepository imageRepository;

    public RepositoryModule() {
        Timber.d("RepositoryModule");

        documentRepository = new DocumentRepositoryStub();
        tempDocumentRepository = new TempDocumentRepositoryStub(documentRepository);
        imageRepository = new ImageRepositoryStub();
    }

    @Provides
    public TempDocumentRepository tempDocumentRepository(DocumentRepository documentRepository) {
        return tempDocumentRepository;
    }

    @Provides
    public DocumentRepository documentRepository() {
        return documentRepository;
    }

    @Provides
    public ImageRepository imageRepository() {
        return imageRepository;
    }
}
