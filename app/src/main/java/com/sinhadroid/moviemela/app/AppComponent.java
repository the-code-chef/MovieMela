package com.sinhadroid.moviemela.app;

import com.sinhadroid.moviemela.app.details.DetailsComponent;
import com.sinhadroid.moviemela.app.details.DetailsModule;
import com.sinhadroid.moviemela.app.favorites.FavoritesModule;
import com.sinhadroid.moviemela.app.listing.ListingComponent;
import com.sinhadroid.moviemela.app.listing.ListingModule;
import com.sinhadroid.moviemela.app.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
