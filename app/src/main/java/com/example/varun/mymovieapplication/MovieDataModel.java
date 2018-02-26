package com.example.varun.mymovieapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvaru on 2/23/2018.
 */
/**
 * This class handles the JSON data sent by MovieResultModel.
 */

public class MovieDataModel {
    private int _ID;
    private String title;
    private String popularity;
    private List<Integer> genre_ids;
    private String poster_path;
    private ArrayList<String> geners_name;

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ArrayList<String> getGeners_name() {
        return geners_name;
    }

    public void setGeners_name(ArrayList<String> geners_name) {
        this.geners_name = geners_name;
    }

    public int get_ID() {
        return _ID;

    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_id) {
        this.genre_ids = genre_id;
    }
}
