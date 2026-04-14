//q1
//activity_main.xml

<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:orientation="vertical" 
    android:padding="20dp" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <EditText 
        android:id="@+id/e1" 
        android:hint="Enter Phone Number" 
        android:inputType="phone" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/b1" 
        android:text="Call" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
 
</LinearLayout> 

//MainActivity.java 
package com.example.callapp; 
 
import android.content.Intent; 
import android.net.Uri; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.*; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    EditText e1; 
    Button b1; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        e1 = findViewById(R.id.e1); 
        b1 = findViewById(R.id.b1); 
 
        b1.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
 
                String no = e1.getText().toString(); 
 
                Intent i = new Intent(Intent.ACTION_CALL); 
                i.setData(Uri.parse("tel:"+no)); 
 
                startActivity(i); 
            } 
        }); 
    } 
} 
//AndroidManifest.xml 
<uses-permission android:name="android.permission.CALL_PHONE"/>