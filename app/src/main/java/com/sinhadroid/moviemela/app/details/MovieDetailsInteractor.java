package com.sinhadroid.moviemela.app.details;

import com.sinhadroid.moviemela.app.Review;
import com.sinhadroid.moviemela.app.Video;

import java.util.List;

import rx.Observable;

/**
 * @author arun
 */
public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
