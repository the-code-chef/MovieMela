package com.sinhadroid.moviemela.app.listing;

import com.sinhadroid.moviemela.app.listing.sorting.SortingDialogFragment;
import com.sinhadroid.moviemela.app.listing.sorting.SortingModule;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent
{
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
