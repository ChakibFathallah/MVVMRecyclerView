package com.example.recyclerview.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recyclerview.models.NicePlace;

import java.util.List;

public class MainActivityViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;

    public void init(){
        mNicePlaces.
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mNicePlaces;
    }
}
