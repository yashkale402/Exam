//q1
//MainActivity.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:gravity="center"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView"
        android:src="@drawable/image1"
        android:layout_width="200dp"
        android:layout_height="200dp"/>

    <Button
        android:id="@+id/btnChange"
        android:text="Change Image"
        android:layout_marginTop="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>

//MainActivity.java
package com.example.imagechange;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnChange;
    boolean imageChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnChange = findViewById(R.id.btnChange);

        btnChange.setOnClickListener(v -> {

            if(imageChanged){
                imageView.setImageResource(R.drawable.image1);
                imageChanged = false;
            } else {
                imageView.setImageResource(R.drawable.image2);
                imageChanged = true;
            }

        });
    }
}
