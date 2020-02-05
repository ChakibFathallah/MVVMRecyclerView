package com.example.recyclerview.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.models.NicePlace;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewHorizentalAdapter extends RecyclerView.Adapter<RecyclerViewHorizentalAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewVerticalAdapter";

  //  private ArrayList<String> mImageNames = new ArrayList<>();
  // private ArrayList<String> mImages = new ArrayList<>();

    private ArrayList<NicePlace> nicePlaceList ;
    private Context mContext;

    private NicePlace currentPlace;

    //save the individual item in memory and then will only show the ones that are visible to the user so that  helps to improve performance
    public RecyclerViewHorizentalAdapter (Context mContext, ArrayList<NicePlace> nicePlaceList) {
        this.nicePlaceList = nicePlaceList;
        this.mContext = mContext;
    }

    //responsible for inflating the view  (view holder class responsible for holding the widgets in memory)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem_horizental,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //this method is called when any item is called to the list
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        currentPlace = nicePlaceList.get(position);

        Glide.with(mContext)
                .asBitmap()
                .load(currentPlace.getImage())
                .into(holder.image);

        holder.imageName.setText(currentPlace.getName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + currentPlace);

                Toast.makeText(mContext, currentPlace.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return nicePlaceList.size();
    }

    //THE WIDGETS ARE SAVED IN MEMORY IN VIEWHOLDER CLASS SO TO REFERNCE THEM  WE NEED TO REF THE VIEW HOLDER WHICH IS PASSED THROUGH THE CONSTRUCTOR
    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
