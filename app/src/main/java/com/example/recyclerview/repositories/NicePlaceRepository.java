package com.example.recyclerview.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.recyclerview.models.NicePlace;

import java.util.ArrayList;
import java.util.List;


/*
 *
 *   Singleton pattern
 *
 */
public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataset = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepository();
        }
        return instance;
    }


    //Pretend to get Data from a webservice or an online source
    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicePlaces();

        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataset);

        return data;
    }


    private void setNicePlaces() {
        // Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        dataset.add(new NicePlace("Havasu Falls", "https://i.redd.it/glin0nwndo501.jpg"));
        dataset.add(new NicePlace("Trondheim", "https://i.redd.it/tpsnoz5bzo501.jpg"));
        dataset.add(new NicePlace("Portugal", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        dataset.add(new NicePlace("Rocky Mountain National Park", "https://i.redd.it/j6myfqglup501.jpg"));
        dataset.add(new NicePlace("Mahahual", "https://i.redd.it/0h2gm1ix6p501.jpg"));
        dataset.add(new NicePlace("Frozen Lake", "https://i.redd.it/k98uzl68eh501.jpg"));
        dataset.add(new NicePlace("White Sands Desert", "https://i.redd.it/glin0nwndo501.jpg"));
        dataset.add(new NicePlace("Austrailia", "https://i.redd.it/obx4zydshg601.jpg"));
        dataset.add(new NicePlace("Washington", "https://i.imgur.com/ZcLLrkY.jpg"));

    }


}
