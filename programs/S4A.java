//q1
//activity_main.xml 
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android" 
    xmlns:app="http://schemas.android.com/apk/res-auto" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <EditText 
        android:id="@+id/et1" 
        android:hint="Number 1" 
        android:inputType="number" 
        android:layout_width="0dp" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toTopOf="parent" 
        app:layout_constraintStart_toStartOf="parent" 
        app:layout_constraintEnd_toEndOf="parent" 
        android:layout_margin="16dp"/> 
 
    <EditText 
        android:id="@+id/et2" 
        android:hint="Number 2" 
        android:inputType="number" 
        android:layout_width="0dp" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toBottomOf="@id/et1" 
        app:layout_constraintStart_toStartOf="parent" 
        app:layout_constraintEnd_toEndOf="parent" 
        android:layout_margin="16dp"/> 
 
    <Button 
        android:text="Add" 
        android:onClick="add" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toBottomOf="@id/et2" 
        app:layout_constraintStart_toStartOf="parent"/> 
 
    <Button 
        android:text="Sub" 
        android:onClick="sub" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toBottomOf="@id/et2" 
        app:layout_constraintEnd_toEndOf="parent"/> 
 
    <Button 
        android:text="Mul" 
        android:onClick="mul" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toBottomOf="@id/btnAdd" 
        app:layout_constraintStart_toStartOf="parent"/> 
 
    <Button 
        android:text="Div" 
        android:onClick="div" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toBottomOf="@id/btnSub" 
        app:layout_constraintEnd_toEndOf="parent"/> 
 
    <TextView 
        android:id="@+id/tvRes" 
        android:text="Result" 
        android:textSize="18sp" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        app:layout_constraintTop_toBottomOf="@id/et2" 
        app:layout_constraintBottom_toBottomOf="parent" 
        app:layout_constraintStart_toStartOf="parent" 
        app:layout_constraintEnd_toEndOf="parent"/> 
 
</androidx.constraintlayout.widget.ConstraintLayout>

//MainActivity.java
package com.example.calcapp; 
 
import android.os.Bundle; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    EditText n1, n2; 
    TextView tv; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        n1 = findViewById(R.id.et1); 
        n2 = findViewById(R.id.et2); 
        tv = findViewById(R.id.tvRes); 
    } 
 
    public void add(View v) { 
        int a = Integer.parseInt(n1.getText().toString()); 
        int b1 = Integer.parseInt(n2.getText().toString()); 
        tv.setText("Result = " + (a + b1)); 
    } 
 
    public void sub(View v) { 
        int a = Integer.parseInt(n1.getText().toString()); 
        int b1 = Integer.parseInt(n2.getText().toString()); 
        tv.setText("Result = " + (a - b1)); 
    } 
 
    public void mul(View v) { 
        int a = Integer.parseInt(n1.getText().toString()); 
        int b1 = Integer.parseInt(n2.getText().toString()); 
        tv.setText("Result = " + (a * b1)); 
    } 
 
    public void div(View v) { 
        int a = Integer.parseInt(n1.getText().toString()); 
        int b1 = Integer.parseInt(n2.getText().toString()); 
        tv.setText("Result = " + (a / b1)); 
    } 
}
