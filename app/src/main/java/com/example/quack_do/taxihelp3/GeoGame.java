package com.example.quack_do.taxihelp3;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
                pointStyle.setTitle("ЧП СОСУЛЬКА");
                pointStyle.setSnippet("Тел: " + feature.getProperty("phone"));
                pointStyle.setIcon(marker);
                feature.setPointStyle(pointStyle);
            }
    }
}
