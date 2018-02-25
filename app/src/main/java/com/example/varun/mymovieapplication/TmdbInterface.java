package com.example.varun.mymovieapplication;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kvaru on 2/23/2018.
 */

public interface TmdbInterface {

    String BASE_URL = "https://api.themoviedb.org/3/movie/";
    String BASE_URL_GENRE="https://api.themoviedb.org/3/genre/movie/";
    String API_KEY="api_key=6e48f35d1b923d91438ae126a3f0fc27";
    String API_NAME_NOWPLAYING ="now_playing?"+API_KEY;
    String API_NAME_UPCOMING = "upcoming?"+API_KEY;
    String API_NAME_GENRE="list?"+API_KEY;

    @GET(API_NAME_NOWPLAYING)
    Call<MovieResultModel> getNowPlayingMovieDetails();

    @GET(API_NAME_UPCOMING)
    Call<MovieResultModel> getUpcomingMovieDetails();

    @GET(API_NAME_GENRE)
    Call<GenreResultModel> getGenreDetails();
}
