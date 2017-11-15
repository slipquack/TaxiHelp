package com.example.quack_do.taxihelp3;

import android.content.Intent;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;

/**
 * Created by Quack-Do on 02.10.2017.
 */

public class GeoGame extends MapsActivity {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        retriverFileFromUrl();
    }

    protected DownloadGeoJsonFile retriverFileFromUrl() {
        new DownloadGeoJsonFile().execute(getString(R.string.url_game));
        return null;
    }

    protected void addToMarker(GeoJsonLayer layer) {

        for (GeoJsonFeature feature : layer.getFeatures())
            if (feature.getProperty("address") != null && feature.hasProperty("phone") ) {

                BitmapDescriptor marker = BitmapDescriptorFactory.fromResource(R.mipmap.game);
                GeoJsonPointStyle pointStyle = new GeoJsonPointStyle();
                pointStyle.setIcon(marker);
                feature.setPointStyle(pointStyle);

                layer.setOnFeatureClickListener(new GeoJsonLayer.GeoJsonOnFeatureClickListener() {
                    @Override
                    public void onFeatureClick(Feature feature) {

                        Intent intent = new Intent(GeoGame. this, Customers.class);
                        intent.putExtra("label", feature.getProperty("label"));
                        intent.putExtra("address", feature.getProperty("address"));
                        intent.putExtra("phone", feature.getProperty("phone"));
                        intent.putExtra("img", feature.getProperty("img"));
                        intent.putExtra("text", feature.getProperty("text"));
                        intent.putExtra("site", feature.getProperty("site"));
                        startActivity(intent);
                    }
                });
            }
    }
}
