//q1
//MainActivity.xml 
<?xml version="1.0" encoding="utf-8"?> 
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android" 
    xmlns:app="http://schemas.android.com/apk/res-auto" 
    xmlns:tools="http://schemas.android.com/tools" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    tools:context=".MainActivity"> 
 
    <!-- Button to send message --> 
    <Button 
        android:id="@+id/sendMessageButton" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        android:text="Send Message" 
        app:layout_constraintTop_toTopOf="parent" 
        app:layout_constraintStart_toStartOf="parent" 
        app:layout_constraintEnd_toEndOf="parent" 
        android:layout_marginTop="100dp"/> 
 
</androidx.constraintlayout.widget.ConstraintLayout>

//MainActivity.java
package com.example.hellomessage; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    private Button sendMessageButton; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        sendMessageButton = findViewById(R.id.sendMessageButton); 
 
        sendMessageButton.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); 
             
                intent.putExtra("message", "Hello!"); 
                 
                startActivity(intent); 
            } 
        }); 
    } 
}

//SecondActivity.xml 
<?xml version="1.0" encoding="utf-8"?> 
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android" 
    xmlns:app="http://schemas.android.com/apk/res-auto" 
    xmlns:tools="http://schemas.android.com/tools" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    tools:context=".SecondActivity"> 
 
    <!-- TextView to display the received message --> 
    <TextView 
        android:id="@+id/messageTextView" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        android:text="Message will appear here" 
        android:textSize="20sp" 
        app:layout_constraintTop_toTopOf="parent" 
        app:layout_constraintStart_toStartOf="parent" 
        app:layout_constraintEnd_toEndOf="parent" 
        android:layout_marginTop="100dp"/> 
     
</androidx.constraintlayout.widget.ConstraintLayout> 
 
 
//SecondActivity.java 
package com.example.hellomessage; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class SecondActivity extends AppCompatActivity { 
 
    private TextView messageTextView; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_second); 
 
        messageTextView = findViewById(R.id.messageTextView); 
        String message = getIntent().getStringExtra("message"); 
        messageTextView.setText(message); 
    } 
}