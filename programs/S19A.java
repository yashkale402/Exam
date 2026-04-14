//q1
//activity_main.xml 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:orientation="vertical" 
android:gravity="center" 
android:padding="20dp"> 
<ImageView 
android:id="@+id/imageViewBulb" 
android:layout_width="200dp" 
android:layout_height="200dp" 
android:src="@drawable/bulb_off"/> 
<ToggleButton 
android:id="@+id/toggleButton" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:textOn="Turn OFF" 
android:textOff="Turn ON" 
android:layout_marginTop="20dp"/> 
</LinearLayout>

//MainActivity.java 
package com.example.lightbulbtoggle; 
import android.os.Bundle; 
import android.widget.ImageView; 
import android.widget.ToggleButton; 
import androidx.appcompat.app.AppCompatActivity; 
public class MainActivity extends AppCompatActivity { 
ToggleButton toggleButton; 
ImageView imageViewBulb; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
toggleButton = findViewById(R.id.toggleButton); 
imageViewBulb = findViewById(R.id.imageViewBulb); 
imageViewBulb.setImageResource(R.drawable.bulb_off); 
toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> { 
if (isChecked) { 
imageViewBulb.setImageResource(R.drawable.bulb_on); 
} else { 
imageViewBulb.setImageResource(R.drawable.bulb_off); 
} 
}); 
} 
}