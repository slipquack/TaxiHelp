package com.example.quack_do.taxihelp3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;

/**
 * Created by Quack-Do on 01.10.2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void button_kafe(View view) {
        Intent intent = new Intent(this, GeoKafe.class);
        int type = 1;
        intent.putExtra("Type", type);
        startActivity(intent);
        clickButton(view);
    }

    public void button_repair(View view) {
        Intent intent = new Intent(this, GeoRepair.class);
        int type = 2;
        intent.putExtra("Type", type);
        startActivity(intent);
        clickButton(view);
    }

    public void button_sink(View view) {
        Intent intent = new Intent(this, GeoSink.class);
        int type = 4;
        intent.putExtra("Type", type);
        startActivity(intent);
        clickButton(view);
    }

    public void button_service(View view) {
        Intent intent = new Intent(this, GeoService.class);
        int type = 5;
        intent.putExtra("Type", type);
        startActivity(intent);
        clickButton(view);
    }

    public void button_rent(View view) {
            Intent intent = new Intent(this, RentActivity.class);
            intent.putExtra("text", "text");
            startActivity(intent);
            clickButton(view);
    }

    public void clickButton(View v) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.button_click);
        v.startAnimation(anim);
    }
}
