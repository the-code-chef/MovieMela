package com.sinhadroid.moviemela.app.favorites;

import com.sinhadroid.moviemela.app.Movie;

import java.util.List;

/**
 * @author arun
 */
public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
