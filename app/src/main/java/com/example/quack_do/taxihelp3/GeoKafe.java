package com.example.quack_do.taxihelp3;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;

/**
 * Created by Quack-Do on 02.10.2017.
 */

public class GeoKafe extends MapsActivity {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        retriverFileFromUrl();

    }


    protected DownloadGeoJsonFile retriverFileFromUrl() {
        new DownloadGeoJsonFile().execute(getString(R.string.url_kafe));
        return null;
    }


    protected void addToMarker(GeoJsonLayer layer) {

        for (GeoJsonFeature feature : layer.getFeatures()) {


                GeoJsonPointStyle pointStyle = new GeoJsonPointStyle();
                BitmapDescriptor marker = BitmapDescriptorFactory.fromResource(R.mipmap.kafe);
                pointStyle.setIcon(marker);
                feature.setPointStyle(pointStyle);

        }
        layer.setOnFeatureClickListener(new GeoJsonLayer.GeoJsonOnFeatureClickListener() {
            @Override
            public void onFeatureClick(final Feature feature) {
                Toast.makeText(GeoKafe.this,
                        "Feature clicked: " + feature.getProperty("address"),
                        Toast.LENGTH_SHORT).show();
                getmMap().setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                    @Override
                    public View getInfoWindow(Marker marker) {

                        return null;

                    }

                    @Override
                    public View getInfoContents(Marker marker) {

                        View infoView = getLayoutInflater().inflate(R.layout.info_window, null);

                        TextView label = (TextView) infoView.findViewById(R.id.label);
                        label.setText(feature.getProperty("label"));
                        TextView address = (TextView) infoView.findViewById(R.id.address);
                        address.setText(feature.getProperty("address"));
                        TextView phone = (TextView) infoView.findViewById(R.id.phone);
                        phone.setText(feature.getProperty("phone"));

                        return infoView;
                    }

                });

            }

        });


    }

}
