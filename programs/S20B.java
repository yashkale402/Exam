//q2b
//mainactivity.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:text="List of Countries"
        android:textSize="22sp"
        android:layout_marginBottom="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <ListView
        android:id="@+id/listViewCountry"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>

//MainActivity.java
package com.example.countrylist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] countries = {
            "India",
            "USA",
            "Canada",
            "Australia",
            "Germany",
            "Japan",
            "Brazil"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewCountry);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            String selectedCountry = countries[position];

            Toast.makeText(MainActivity.this,
                    "Selected: " + selectedCountry,
                    Toast.LENGTH_SHORT).show();
        });
    }
}
