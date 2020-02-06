package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapters.RecyclerViewHorizentalAdapter;
import com.example.recyclerview.adapters.RecyclerViewVerticalAdapter;
import com.example.recyclerview.models.NicePlace;
import com.example.recyclerview.viewModels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.fab)
    FloatingActionButton fab;


    private ArrayList<NicePlace> nicePlacesList;
    private MainActivityViewModel mMainActivityViewModel;

    private RecyclerViewVerticalAdapter adapterVertical;
    private RecyclerViewHorizentalAdapter adapterHorizental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate: started.");


        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                adapterHorizental.notifyDataSetChanged();
                adapterVertical.notifyDataSetChanged();

            }
        });


        initImageBitmaps();
        initRecyclerViewVertical();
        initRecyclerViewHorizental();


    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        nicePlacesList.add(new NicePlace("Havasu Falls", "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));
        nicePlacesList.add(new NicePlace("Trondheim", "https://i.redd.it/tpsnoz5bzo501.jpg"));
        nicePlacesList.add(new NicePlace("Portugal", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        nicePlacesList.add(new NicePlace("Rocky Mountain National Park", "https://i.redd.it/j6myfqglup501.jpg"));
        nicePlacesList.add(new NicePlace("Mahahual", "https://i.redd.it/0h2gm1ix6p501.jpg"));
        nicePlacesList.add(new NicePlace("Frozen Lake", "https://i.redd.it/k98uzl68eh501.jpg"));
        nicePlacesList.add(new NicePlace("White Sands Desert", "https://i.redd.it/glin0nwndo501.jpg"));
        nicePlacesList.add(new NicePlace("Austrailia", "https://i.redd.it/obx4zydshg601.jpg"));
        nicePlacesList.add(new NicePlace("Washington", "https://i.imgur.com/ZcLLrkY.jpg"));

    }

    private void initRecyclerViewVertical() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapterVertical = new RecyclerViewVerticalAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        recyclerView.setAdapter(adapterVertical);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initRecyclerViewHorizental() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_horizental);
        recyclerView.setLayoutManager(layoutManager);
        adapterHorizental = new RecyclerViewHorizentalAdapter(this, nicePlacesList);
        recyclerView.setAdapter(adapterHorizental);

    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}
