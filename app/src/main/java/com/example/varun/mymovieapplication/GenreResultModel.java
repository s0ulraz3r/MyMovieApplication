package com.example.varun.mymovieapplication;

import java.util.List;

/**
 * Created by kvaru on 2/24/2018.
 */

/**
 * This Class is created to get the JSON data and pass it to GenreDataModel class.
 */

public class GenreResultModel {

    private List<GenreDataModel> genres;

    public List<GenreDataModel> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDataModel> genres) {
        this.genres = genres;
    }
}
