package com.sinhadroid.moviemela.app.listing;

import com.sinhadroid.moviemela.app.Movie;

import java.util.List;

import rx.Observable;

/**
 * @author arun
 */
public interface MoviesListingInteractor
{
    Observable<List<Movie>> fetchMovies();
}
