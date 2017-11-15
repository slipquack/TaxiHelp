package com.example.quack_do.taxihelp3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.net.Uri.parse;


/**
 * Created by Quack-Do on 07.11.2017.
 */

public class Customers extends Activity{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info_window);

        Bundle extras = getIntent().getExtras();

        TextView textLabel = (this).findViewById(R.id.label);
        String label = extras.getString("label");
        textLabel.setText(label);

        TextView textAddress = (this).findViewById(R.id.address);
        String address = extras.getString("address");
        textAddress.setText(address);

        TextView textDescription = (this).findViewById(R.id.description);
        String description  = extras.getString("text");
        textDescription.setText(description);

        Button nameSite = (this).findViewById(R.id.site);

        Button textPhone = (this).findViewById(R.id.phone);
        String phone = extras.getString("phone");
        textPhone.setText(phone);

        String img = extras.getString("img");
        new DownloadImageTask((ImageView) findViewById(R.id.image))
                .execute(img);


    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    public void onClick(View view) {
        Bundle extras = getIntent().getExtras();
        String phone = extras.getString("phone");
        Uri number = Uri.parse("tel:" + phone);
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(intent);
    }

    public  void goToSite(View view) {
        Bundle extras = getIntent().getExtras();
        String nameSite = extras.getString("site");
        Uri name = Uri.parse("http:" + nameSite);
        Intent intent = new Intent(Intent.ACTION_VIEW, name);
        startActivity(intent);
    }
}
