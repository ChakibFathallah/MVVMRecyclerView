package com.example.recyclerview.repositories;

import com.example.recyclerview.models.NicePlace;

import java.util.ArrayList;


/*
  *
  *   Singleton pattern
  *
   */
public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataset = new ArrayList<>();

    public static NicePlaceRepository getInstance(){
        if (instance == null){
            instance = new NicePlaceRepository();
        }
        return instance;
    }
}
