//q1
//MainActivity.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:gravity="center"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btnAlert"
        android:text="Show Alert Dialog"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>

//MainActivity.java
package com.example.alertdialogdemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Confirmation");
            builder.setMessage("Do you want to exit?");

            builder.setPositiveButton("Yes", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "You clicked YES", Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show();
            });

            builder.setNeutralButton("Cancel", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            });

            builder.show();
        });
    }
}
