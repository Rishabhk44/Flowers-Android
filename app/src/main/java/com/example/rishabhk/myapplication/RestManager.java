package com.example.rishabhk.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rishabhk on 20-09-2016.
 */
public class RestManager {

    private FlowerAPIService mFlowerAPIService;

    public FlowerAPIService getFlowerService(){
        if(mFlowerAPIService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerAPIService = retrofit.create(FlowerAPIService.class);
        }

        return mFlowerAPIService;

    }



}
