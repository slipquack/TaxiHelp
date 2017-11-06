package com.example.quack_do.taxihelp3;

import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;

/**
 * Created by Quack-Do on 03.10.2017.
 */

public class GeoSink extends MapsActivity {


    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        retriveFileFromUrl();

    }


    protected DownloadGeoJsonFile retriveFileFromUrl() {
        new DownloadGeoJsonFile().execute(getString(R.string.url_sink));
        return null;
    }


    protected void addToMarker(final GeoJsonLayer layer) {

        for (final GeoJsonFeature feature : layer.getFeatures())
            if ((feature.getProperty("address") != null) && feature.hasProperty("phone")) {

                final BitmapDescriptor marker = BitmapDescriptorFactory.fromResource(R.mipmap.sink);
                final GeoJsonPointStyle pointStyle = new GeoJsonPointStyle();

                pointStyle.setIcon(marker);
                feature.setPointStyle(pointStyle);

                getmMap().setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                    View view = getLayoutInflater().inflate(R.layout.customwindow, null);
                    TextView text = (TextView) view.findViewById(R.id.title);

                    TextView text2 = (TextView)view.findViewById(R.id.text2);

                    @Override
                    public View getInfoWindow(Marker marker) {

                        return null;
                    }

                    @Override
                    public View getInfoContents(Marker marker) {
                        text.setText(marker.getTitle());
                        return view;
                    }
                });
            }


    }



}
