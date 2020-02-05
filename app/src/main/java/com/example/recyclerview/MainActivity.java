package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.recyclerview.adapters.RecyclerViewHorizentalAdapter;
import com.example.recyclerview.adapters.RecyclerViewVerticalAdapter;
import com.example.recyclerview.models.NicePlace;
import com.example.recyclerview.viewModels.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    private ArrayList<NicePlace> nicePlacesList ;
    private ProgressBar progressBar;
    private MainActivityViewModel mMainActivityViewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        progressBar = findViewById(R.id.progressBar);

        mMainActivityViewModel = ViewModelProvider.of(this).get(MainActivityViewModel)


        initImageBitmaps();
        initRecyclerViewVertical();
        initRecyclerViewHorizental();


    }

    private void initImageBitmaps()
    {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        nicePlacesList.add(new NicePlace("Havasu Falls","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));
        nicePlacesList.add(new NicePlace("Trondheim","https://i.redd.it/tpsnoz5bzo501.jpg"));
        nicePlacesList.add(new NicePlace("Portugal","https://i.redd.it/qn7f9oqu7o501.jpg"));
        nicePlacesList.add(new NicePlace("Rocky Mountain National Park","https://i.redd.it/j6myfqglup501.jpg"));
        nicePlacesList.add(new NicePlace("Mahahual","https://i.redd.it/0h2gm1ix6p501.jpg"));
        nicePlacesList.add(new NicePlace("Frozen Lake","https://i.redd.it/k98uzl68eh501.jpg"));
        nicePlacesList.add(new NicePlace("White Sands Desert","https://i.redd.it/glin0nwndo501.jpg"));
        nicePlacesList.add(new NicePlace("Austrailia","https://i.redd.it/obx4zydshg601.jpg"));
        nicePlacesList.add(new NicePlace("Washington","https://i.imgur.com/ZcLLrkY.jpg"));

    }

    private void initRecyclerViewVertical()
    {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewVerticalAdapter adapter = new RecyclerViewVerticalAdapter(this, nicePlacesList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initRecyclerViewHorizental()
    {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_horizental);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewHorizentalAdapter adapter = new RecyclerViewHorizentalAdapter(this, nicePlacesList);
        recyclerView.setAdapter(adapter);

    }

    private void showProgressBar(){

    }
}
