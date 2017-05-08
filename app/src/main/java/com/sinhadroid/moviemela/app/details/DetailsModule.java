package com.sinhadroid.moviemela.app.details;

import com.sinhadroid.moviemela.app.favorites.FavoritesInteractor;
import com.sinhadroid.moviemela.app.network.RequestHandler;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule
{
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(RequestHandler requestHandler)
    {
        return new MovieDetailsInteractorImpl(requestHandler);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor)
    {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
