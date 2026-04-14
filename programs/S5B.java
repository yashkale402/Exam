//q2a
//Activitymain.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:gravity="center"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btnFriends"
        android:text="Show Friends"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>

//customdialog.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:text="Select Friend"
        android:textSize="20sp"
        android:layout_marginBottom="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/btnRahul"
        android:text="Rahul"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/btnAmit"
        android:text="Amit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/btnPriya"
        android:text="Priya"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

</LinearLayout>

//MainActivity.java
package com.example.customdialog;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFriends = findViewById(R.id.btnFriends);

        btnFriends.setOnClickListener(v -> {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.custom_dialog, null);

            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                    .setView(view)
                    .create();

            Button rahul = view.findViewById(R.id.btnRahul);
            Button amit = view.findViewById(R.id.btnAmit);
            Button priya = view.findViewById(R.id.btnPriya);

            rahul.setOnClickListener(v1 -> {
                Toast.makeText(MainActivity.this, "Hello Rahul!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            amit.setOnClickListener(v1 -> {
                Toast.makeText(MainActivity.this, "Hello Amit!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            priya.setOnClickListener(v1 -> {
                Toast.makeText(MainActivity.this, "Hello Priya!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}
