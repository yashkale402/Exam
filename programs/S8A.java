//q1
//Activity_main.xml 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:orientation="vertical" 
    android:padding="16dp" 
    android:gravity="center"> 
 
    <!-- EditText for username input --> 
    <EditText 
        android:id="@+id/editTextUsername" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:hint="Username" 
        android:inputType="textPersonName" /> 
 
    <!-- EditText for password input --> 
    <EditText 
        android:id="@+id/editTextPassword" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:hint="Password" 
        android:inputType="textPassword" /> 
 
    <!-- Login Button --> 
    <Button 
        android:id="@+id/buttonLogin" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        android:text="Login" /> 
</LinearLayout>

//MainActivity.java 
package com.example.loginapp; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    private EditText editTextUsername; 
    private EditText editTextPassword; 
    private Button buttonLogin; 
 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        editTextUsername = findViewById(R.id.editTextUsername); 
        editTextPassword = findViewById(R.id.editTextPassword); 
        buttonLogin = findViewById(R.id.buttonLogin); 
 
        buttonLogin.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                String username = editTextUsername.getText().toString(); 
                String password = editTextPassword.getText().toString(); 
 
                if (username.equals(“admin”) && password.equals(“1234”)) { 
 Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show(); 
                    Intent intent = new Intent(MainActivity.this, NextActivity.class); 
                    startActivity(intent); 
                } else { 
Toast.makeText(MainActivity.this, "Invalid Username or Password", 
Toast.LENGTH_SHORT).show(); 
                } 
            } 
        }); 
    } 
}

//SecondActivity.xml 
 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:orientation="vertical" 
    android:padding="16dp" 
    android:gravity="center"> 
 
    <!-- TextView that displays a message --> 
    <TextView 
        android:id="@+id/textViewMessage" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        android:text="Welcome to the next activity!" 
        android:textSize="18sp" /> 
</LinearLayout> 
 
 
 
//SecondActivity.java 
package com.example.loginapp; 
 
import android.os.Bundle; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class NextActivity extends AppCompatActivity { 
 
    private TextView textViewMessage; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_next); 
 
        textViewMessage = findViewById(R.id.textViewMessage); 
        textViewMessage.setText("Welcome to second activity!"); 
    } 
} 