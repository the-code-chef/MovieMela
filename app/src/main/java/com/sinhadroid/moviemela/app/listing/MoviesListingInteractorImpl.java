package com.sinhadroid.moviemela.app.listing;

import android.support.annotation.NonNull;

import com.sinhadroid.moviemela.app.Api;
import com.sinhadroid.moviemela.app.Movie;
import com.sinhadroid.moviemela.app.favorites.FavoritesInteractor;
import com.sinhadroid.moviemela.app.listing.sorting.SortType;
import com.sinhadroid.moviemela.app.listing.sorting.SortingOptionStore;
import com.sinhadroid.moviemela.app.network.RequestGenerator;
import com.sinhadroid.moviemela.app.network.RequestHandler;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import rx.Observable;

/**
 * @author arun
 */
class MoviesListingInteractorImpl implements MoviesListingInteractor
{
    private FavoritesInteractor favoritesInteractor;
    private RequestHandler requestHandler;
    private SortingOptionStore sortingOptionStore;

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                RequestHandler requestHandler, SortingOptionStore store)
    {
        this.favoritesInteractor = favoritesInteractor;
        this.requestHandler = requestHandler;
        sortingOptionStore = store;
    }

    @Override
    public Observable<List<Movie>> fetchMovies()
    {
        return Observable.fromCallable(this::getMovieList);
    }


    private List<Movie> getMovieList() throws IOException, JSONException
    {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue())
        {
            return fetchMovieList(Api.GET_POPULAR_MOVIES);
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue())
        {
            return fetchMovieList(Api.GET_HIGHEST_RATED_MOVIES);
        } else
        {
            return favoritesInteractor.getFavorites();
        }
    }

    @NonNull
    private List<Movie> fetchMovieList(String url) throws IOException, JSONException
    {
        Request request = RequestGenerator.get(url);
        String response = requestHandler.request(request);
        return MoviesListingParser.parse(response);
    }
}
