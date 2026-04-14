//q1
//activity_main.xml 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:orientation="vertical" 
    android:padding="16dp" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <EditText 
        android:id="@+id/etNum" 
        android:hint="Enter Positive Number" 
        android:inputType="number" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:text="Find Factorial" 
        android:onClick="calc" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
</LinearLayout> 


//MainActivity.java
package com.example.factapp; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.EditText; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    EditText n; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        n = findViewById(R.id.etNum); 
    } 
 
    public void calc(View v) { 
        int num = Integer.parseInt(n.getText().toString()); 
 
        Intent i = new Intent(this, SecondActivity.class); 
        i.putExtra("num", num); 
        startActivity(i); 
    } 
}

//SecondActivity.xml
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
package com.example.factapp; 
 
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
 
        int n = getIntent().getIntExtra("num", 0); 
        long f = 1; 
 
        for (int i = 1; i <= n; i++) { 
            f = f * i; 
        } 
 
        tv.setText("Factorial = " + f); 
    } 
}