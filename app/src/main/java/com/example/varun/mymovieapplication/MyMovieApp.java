package com.example.varun.mymovieapplication;

import android.app.Application;

/**
 * Created by kvaru on 2/24/2018.
 */

public class MyMovieApp extends Application {
   private static Genre genre;
    @Override
    public void onCreate() {
        super.onCreate();
        genre=new Genre();
        getGenre().getGenre();
    }

    public static Genre getGenre() {
        return genre;
    }

}
