package com.example.varun.mymovieapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.varun.mymovieapplication.Interfaces.IUpdateUpcoming;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by kvaru on 2/23/2018.
 */

public class UpcomingFragment extends Fragment implements IUpdateUpcoming {
    ListView listView;
    private MovieCustomAdapter movieCustomAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_upcoming, container, false);
        listView = (ListView) rootView.findViewById(R.id.lvUpcoming);
            Call<MovieResultModel> movieResultModelCall =((TmdbInterface)NetworkUtil.buildUrl(TmdbInterface.BASE_URL,TmdbInterface.class)).getUpcomingMovieDetails();
            NetworkUtil.setInterfacesUpcoming(this);
            NetworkUtil.callEnqueueForMovie(movieResultModelCall, MyMovieApp.getGenre(),false);
        return rootView;
    }

    @Override
    public void UpdateList(ArrayList list) {
        movieCustomAdapter = new MovieCustomAdapter(getActivity(),R.layout.listview_items,list);
        listView.setAdapter(movieCustomAdapter);
    }


}
