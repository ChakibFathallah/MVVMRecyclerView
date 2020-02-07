package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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

    @BindView(R.id.recycler_view_horizental)
    RecyclerView recyclerViewHorizental;

    @BindView(R.id.recycler_view_vertical)
    RecyclerView recyclerViewVertical;


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

        mMainActivityViewModel.init();

        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                adapterHorizental.notifyDataSetChanged();
                adapterVertical.notifyDataSetChanged();

            }
        });

        mMainActivityViewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    showProgressBar();
                } else {
                    hideProgressBar();
                    recyclerViewHorizental.smoothScrollToPosition(mMainActivityViewModel.getNicePlaces().getValue().size() - 1);
                    recyclerViewVertical.smoothScrollToPosition(mMainActivityViewModel.getNicePlaces().getValue().size() - 1);
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivityViewModel.addNewValue(new NicePlace("Washington","https://i.imgur.com/ZcLLrkY.jpg"));
            }
        });


        initRecyclerViewVertical();
        initRecyclerViewHorizental();


    }


    private void initRecyclerViewVertical() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        adapterVertical = new RecyclerViewVerticalAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        recyclerViewVertical.setAdapter(adapterVertical);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initRecyclerViewHorizental() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizental.setLayoutManager(layoutManager);
        adapterHorizental = new RecyclerViewHorizentalAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        recyclerViewHorizental.setAdapter(adapterHorizental);

    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
