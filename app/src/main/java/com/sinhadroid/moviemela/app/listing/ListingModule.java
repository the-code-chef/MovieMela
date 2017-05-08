package com.sinhadroid.moviemela.app.listing;

import com.sinhadroid.moviemela.app.favorites.FavoritesInteractor;
import com.sinhadroid.moviemela.app.network.RequestHandler;
import com.sinhadroid.moviemela.app.listing.sorting.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule
{
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          RequestHandler requestHandler,
                                                          SortingOptionStore sortingOptionStore)
    {
        return new MoviesListingInteractorImpl(favoritesInteractor, requestHandler, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor)
    {
        return new MoviesListingPresenterImpl(interactor);
    }
}
