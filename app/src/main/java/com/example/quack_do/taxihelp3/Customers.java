package com.example.quack_do.taxihelp3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


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

        Button textPhone = (this).findViewById(R.id.phone);
        String phone = extras.getString("phone");
        textPhone.setText(phone);
        /****Uri number = Uri.parse("tel:" + phone);
        Intent tel = new Intent(Intent.ACTION_DIAL, number);
        startActivity(tel);
         ****/
    }
}
