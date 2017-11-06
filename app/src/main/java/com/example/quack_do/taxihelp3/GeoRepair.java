package com.example.quack_do.taxihelp3;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;

/**
 * Created by Quack-Do on 03.10.2017.
 */

public class GeoRepair extends MapsActivity{

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        retriverFileFromUrl();
    }

    protected DownloadGeoJsonFile retriverFileFromUrl() {
        new DownloadGeoJsonFile().execute(getString(R.string.url_repair));
        return null;
    }

    protected void addToMarker(GeoJsonLayer layer) {

        for (GeoJsonFeature feature : layer.getFeatures())

            if (feature.getProperty("address") != null && feature.hasProperty("phone")) {

                BitmapDescriptor marker = BitmapDescriptorFactory.fromResource(R.mipmap.repair);
                GeoJsonPointStyle pointStyle = new GeoJsonPointStyle();
                pointStyle.setTitle(feature.getProperty("name"));
                pointStyle.setSnippet("Тел: " + feature.getProperty("phone"));
                pointStyle.setIcon(marker);
                feature.setPointStyle(pointStyle);
            }
    }
}
