package com.example.rishabhk.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rishabhk on 19-09-2016.
 */
public interface FlowerAPIService {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
