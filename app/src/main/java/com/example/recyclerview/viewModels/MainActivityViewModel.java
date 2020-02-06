package com.example.recyclerview.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclerview.models.NicePlace;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;

    public void init(){

    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mNicePlaces;
    }
}
