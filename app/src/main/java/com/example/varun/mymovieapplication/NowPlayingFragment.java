package com.example.varun.mymovieapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.varun.mymovieapplication.Interfaces.IUpdateNowPlaying;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by kvaru on 2/23/2018.
 */


/**
 * NowPlayingFragment displays the NowPlaying movie details in the NowPlaying movie tab.
 */
public class NowPlayingFragment extends Fragment implements IUpdateNowPlaying {
    ListView listView;
    private MovieCustomAdapter movieCustomAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_now_playing, container, false);
        listView = (ListView) rootView.findViewById(R.id.lvNowPlaying);

        Call<MovieResultModel> movieResultModelCall=  ((TmdbInterface)NetworkUtil.buildUrl(TmdbInterface.BASE_URL,TmdbInterface.class)).getNowPlayingMovieDetails();
        NetworkUtil.setInterfacesNowPlaying(this);
        NetworkUtil.callEnqueueForMovie(movieResultModelCall, MyMovieApp.getGenre(),true);
        return rootView;
    }



    @Override
    public void UpdateListForNowplaying(ArrayList list) {
        movieCustomAdapter = new MovieCustomAdapter(getActivity(),R.layout.listview_items,list);
        listView.setAdapter(movieCustomAdapter);
    }
}
