package com.example.varun.mymovieapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kvaru on 2/24/2018.
 */

/**
 * Genre Class fetches the JSON data from the API.
 * Hasp Map is created to store the Genre data ID & Name as a key value pair.
 */
public class Genre{
    ArrayList<GenreDataModel> list_Genre  = new ArrayList<>();
    HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

    public void getGenre() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TmdbInterface.BASE_URL_GENRE)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        TmdbInterface tmdbInterface_genre = retrofit.create(TmdbInterface.class);

        Call<GenreResultModel> genreResultModelCall = tmdbInterface_genre.getGenreDetails();

        genreResultModelCall.enqueue(new Callback<GenreResultModel>() {
            @Override
            public void onResponse(Call<GenreResultModel> call, Response<GenreResultModel> response) {
                GenreResultModel resultModel = response.body();
                List<GenreDataModel> genreDataModels = resultModel.getGenres();
                for (int i = 0; i < genreDataModels.size(); i++) {
                    GenreDataModel model = new GenreDataModel();
                    model.setId(genreDataModels.get(i).getId());
                    model.setName(genreDataModels.get(i).getName());
                    list_Genre.add(model);
                }
                for (int i=0;i<list_Genre.size();i++){
                    hashMap.put(list_Genre.get(i).getId(),list_Genre.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<GenreResultModel> call, Throwable t) {

            }
        });


    }
}
