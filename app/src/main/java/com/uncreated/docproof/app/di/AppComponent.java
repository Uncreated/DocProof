package com.uncreated.docproof.app.di;


import com.uncreated.docproof.app.di.modules.AppModule;
import com.uncreated.docproof.app.di.modules.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {
}
