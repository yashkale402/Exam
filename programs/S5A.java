//q1
//activity_main.xml 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:orientation="vertical" 
    android:padding="16dp" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <EditText 
        android:id="@+id/et1" 
        android:hint="Enter Number 1" 
        android:inputType="number" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <EditText 
        android:id="@+id/et2" 
        android:hint="Enter Number 2" 
        android:inputType="number" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:text="Calculate" 
        android:onClick="cal" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
</LinearLayout>

//MainActivity.java 
package com.example.poweravg; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.EditText; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    EditText n1, n2; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        n1 = findViewById(R.id.et1); 
        n2 = findViewById(R.id.et2); 
    } 
 
    public void cal(View v) { 
        int a = Integer.parseInt(n1.getText().toString()); 
        int b1 = Integer.parseInt(n2.getText().toString()); 
 
        Intent i = new Intent(this, SecondActivity.class); 
        i.putExtra("a", a); 
        i.putExtra("b", b1); 
        startActivity(i); 
    } 
}


//activity_second.xml 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:padding="16dp" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <TextView 
        android:id="@+id/tvRes" 
        android:textSize="18sp" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
</LinearLayout> 

//SecondActivity.java 
package com.example.poweravg; 
 
import android.os.Bundle; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class SecondActivity extends AppCompatActivity { 
 
    TextView tv; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_second); 
 
        tv = findViewById(R.id.tvRes); 
 
        int a = getIntent().getIntExtra("a", 0); 
        int b1 = getIntent().getIntExtra("b", 0); 
 
        double p = Math.pow(a, b1); 
        double avg = (a + b1) / 2.0; 
 
        tv.setText("Power = " + p + "\nAverage = " + avg); 
    } 
}