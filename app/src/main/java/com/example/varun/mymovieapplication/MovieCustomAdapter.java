package com.example.varun.mymovieapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

//
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by varun on 12/4/2017.
 */

public class MovieCustomAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<MovieDataModel> movieDataModelList;


    public MovieCustomAdapter(Context context, int listview_items, ArrayList<MovieDataModel> movieDataModelList) {
        super(context,listview_items,movieDataModelList);
        this.context = context;
        this.movieDataModelList = movieDataModelList;

    }

    @Override
    public int getCount() {
        return movieDataModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieDataModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context,R.layout.listview_items,null);
        TextView tvName = (TextView) view1.findViewById(R.id.tvTitle);
        tvName.setText(movieDataModelList.get(i).getTitle());
        Log.d("Details", movieDataModelList.get(i).getTitle());
        TextView tvGenres = (TextView) view1.findViewById(R.id.tvGenre);
        String s = String.valueOf(movieDataModelList.get(i).getGeners_name()).replaceAll("\\[","").replaceAll("\\]","");
        tvGenres.setText(s);
        TextView tvPopularity = (TextView) view1.findViewById(R.id.tvPopularity);
        tvPopularity.setText(movieDataModelList.get(i).getPopularity());
        ImageView imageView = (ImageView) view1.findViewById(R.id.ivMovieImg);
        Glide.with(getContext()).load("https://image.tmdb.org/t/p/w500"+movieDataModelList.get(i).getPoster_path())
                .into(imageView);
        return view1;
    }


}
