package com.example.varun.mymovieapplication;

import com.example.varun.mymovieapplication.Interfaces.IUpdateNowPlaying;
import com.example.varun.mymovieapplication.Interfaces.IUpdateUpcoming;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kvaru on 2/24/2018.
 */

public class NetworkUtil {
    static Retrofit retrofit;
    private static IUpdateUpcoming iUpdateUpcoming;
    private static IUpdateNowPlaying iUpdateNowPlaying;
    public static Object buildUrl(String url,Class serviceInterface){
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        return retrofit.create(serviceInterface);
    }
    public static void setInterfacesUpcoming(IUpdateUpcoming IList){
        iUpdateUpcoming =IList;
    }
    public static void setInterfacesNowPlaying(IUpdateNowPlaying IList){
        iUpdateNowPlaying =IList;
    }
    public static void callEnqueueForMovie(Call<MovieResultModel> movieResultModelCall, final Genre genre,final boolean isNowplaying){
        movieResultModelCall.enqueue(new Callback<MovieResultModel>() {
            @Override
            public void onResponse(Call<MovieResultModel> call, Response<MovieResultModel> response) {
                MovieResultModel movieResultModels = response.body();
                List<MovieDataModel> movieDataModels = movieResultModels.getResults();
                ArrayList<MovieDataModel> list  = new ArrayList<>();
                for (int i=0;i<movieDataModels.size();i++){
                    MovieDataModel movieModel = new MovieDataModel();
                    movieModel.setTitle(movieDataModels.get(i).getTitle());
                    movieModel.setPopularity(movieDataModels.get(i).getPopularity());
                    ArrayList<String> strings_genres = new ArrayList<>();
                    for(int g : movieDataModels.get(i).getGenre_ids()){
                        System.out.println(genre.hashMap.get(g));
                        strings_genres.add(genre.hashMap.get(g));

                    }

                    movieModel.setGeners_name(strings_genres);
                    movieModel.setPoster_path(movieDataModels.get(i).getPoster_path());
                    list.add(movieModel);



                }
                if(isNowplaying){
                    iUpdateNowPlaying.UpdateListForNowplaying(list);
                }
                else {
                    iUpdateUpcoming.UpdateList(list);
                }

            }

            @Override
            public void onFailure(Call<MovieResultModel> call, Throwable t) {

            }
        });
    }

}
