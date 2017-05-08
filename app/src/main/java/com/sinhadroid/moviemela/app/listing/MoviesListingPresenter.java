package com.sinhadroid.moviemela.app.listing;

/**
 * @author arun
 */
public interface MoviesListingPresenter
{
    void displayMovies();

    void setView(MoviesListingView view);

    void destroy();
}
