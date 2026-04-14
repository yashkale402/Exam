//q1
//Activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:text="Select Your Favorite Language"
        android:textSize="20sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <RadioGroup
        android:id="@+id/radioGroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/radioJava"
            android:text="Java"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <RadioButton
            android:id="@+id/radioPython"
            android:text="Python"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <RadioButton
            android:id="@+id/radioCpp"
            android:text="C++"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

    </RadioGroup>

    <Button
        android:id="@+id/btnSubmit"
        android:text="Submit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>

//MainActivity.java
package com.example.radiobuttondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId == -1){
                    Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else{
                    RadioButton radioButton = findViewById(selectedId);
                    String selectedText = radioButton.getText().toString();

                    Toast.makeText(MainActivity.this, "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
