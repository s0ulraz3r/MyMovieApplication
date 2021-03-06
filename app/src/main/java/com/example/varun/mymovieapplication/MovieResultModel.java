package com.example.varun.mymovieapplication;

import android.widget.ListView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kvaru on 2/23/2018.
 */

/**
 * This Class is created to get the JSON data and pass it to MovieDataModel class.
 */
public class MovieResultModel {

    @SerializedName("results")
    private List<MovieDataModel> results;


    public List<MovieDataModel> getResults() {
        return results;
    }

    public void setResults(List<MovieDataModel> results) {
        this.results = results;
    }
}
