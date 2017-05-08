package com.sinhadroid.moviemela.app.listing.sorting;

/**
 * @author arun
 */
public interface SortingDialogPresenter
{
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
