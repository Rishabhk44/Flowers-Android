package com.example.rishabhk.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rishabhk on 19-09-2016.
 */
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.MyViewHolder> {

    private List<Flower> mFlowers;
    private FlowerClickListener mListner;

    public FlowerAdapter(FlowerClickListener listner){
        mFlowers = new ArrayList<>();
        mListner = listner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Flower currFlower = mFlowers.get(position);
        holder.flowerName.setText(currFlower.getName());
        holder.flowerPrice.setText(Double.toString(currFlower.getPrice()));

        Picasso.with(holder.itemView.getContext())
                .load("http://services.hanselandpetal.com/photos/" + currFlower.getPhoto())
                .into(holder.mPhoto);
    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addFlower(Flower flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    public Flower getSelectedFlower(int position){
        return  mFlowers.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mPhoto;
        public TextView flowerName, flowerPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.rimageView);
            flowerName = (TextView) itemView.findViewById(R.id.riheadingView);
            flowerPrice = (TextView) itemView.findViewById(R.id.ripriceView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListner.onClick(getLayoutPosition());
        }
    }

    public interface FlowerClickListener {

        void onClick(int position);
    }



}
