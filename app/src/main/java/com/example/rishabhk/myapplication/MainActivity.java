package com.example.rishabhk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClickListener {

    private RecyclerView recyclerView;
    private FlowerAdapter mAdapter;
    private RestManager mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachAdapter();

        mManager = new RestManager();
        Call<List<Flower>> listCall = mManager.getFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if(response.isSuccessful()){
                    List<Flower> flowerList = response.body();

                    for (int i = 0 ; i<flowerList.size() ; i++){
                        Flower flower = flowerList.get(i);
                        mAdapter.addFlower(flower);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });

    }

    private void attachAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FlowerAdapter(this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(int position){
        Flower selectedFlower = mAdapter.getSelectedFlower(position);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER , selectedFlower);
        startActivity(intent);
    }

}
