package com.example.rishabhk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Rishabhk on 20-09-2016.
 */
public class DetailActivity extends AppCompatActivity {

    private TextView mName, mId, mCategory, mInstruction, mPrice;
    private ImageView mPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);
        configViews();

        mId.setText("" + flower.getProductId());
        mCategory.setText(flower.getCategory());
        mInstruction.setText(flower.getInstructions());
        mName.setText(flower.getName());
        mPrice.setText("$"+ flower.getPrice());

        Picasso.with(this)
                .load("http://services.hanselandpetal.com/photos/" + flower.getPhoto())
                .into(mPhoto);
    }

    private void configViews(){

        mPhoto = (ImageView) findViewById(R.id.details_imageView);
        mName = (TextView) findViewById(R.id.flowerName);
        mInstruction = (TextView) findViewById(R.id.flowerInstruction);
        mCategory = (TextView) findViewById(R.id.flowerCategory);
        mId = (TextView) findViewById(R.id.flowerId);
        mPrice = (TextView) findViewById(R.id.flowerPrice);

    }

}
