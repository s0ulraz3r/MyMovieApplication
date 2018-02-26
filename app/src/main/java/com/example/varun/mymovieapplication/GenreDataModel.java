package com.example.varun.mymovieapplication;

import java.util.ArrayList;

/**
 * Created by kvaru on 2/24/2018.
 */

/**
 * This class handles the JSON data sent by GenreResultModel.
 */
public class GenreDataModel {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
