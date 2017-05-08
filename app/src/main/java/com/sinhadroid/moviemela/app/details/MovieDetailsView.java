package com.sinhadroid.moviemela.app.details;

import com.sinhadroid.moviemela.app.Movie;
import com.sinhadroid.moviemela.app.Review;
import com.sinhadroid.moviemela.app.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
