package com.sinhadroid.moviemela.app;

import android.app.Application;
import android.os.StrictMode;

import com.sinhadroid.moviemela.app.details.DetailsComponent;
import com.sinhadroid.moviemela.app.details.DetailsModule;
import com.sinhadroid.moviemela.app.favorites.FavoritesModule;
import com.sinhadroid.moviemela.app.listing.ListingComponent;
import com.sinhadroid.moviemela.app.listing.ListingModule;
import com.sinhadroid.moviemela.app.network.NetworkModule;

/**
 * @author arun
 */
public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
