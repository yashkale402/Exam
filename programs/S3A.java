//q1
//activity_main.xml 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:orientation="vertical" 
    android:gravity="center" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <TextView 
        android:id="@+id/tvClg" 
        android:text="ABC College of Engineering" 
        android:textSize="24sp" 
        android:textStyle="bold|italic" 
        android:textColor="@android:color/black" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/btn" 
        android:text="Change Color" 
        android:onClick="chg" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        android:layout_marginTop="20dp"/> 
</LinearLayout> 

//MainActivity.java
package com.example.collegeapp; 
 
import android.graphics.Color; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
TextView tv; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        tv = findViewById(R.id.tvClg); 
    } 
 
    public void chg(View v) { 
tv.setTextColor(Color.RED); 
        tv.setTextSize(30); 
        tv.setTypeface(null, Typeface.BOLD_ITALIC);    } 
}

