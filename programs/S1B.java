//q2b
//MainActivity.xml 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:orientation="vertical" 
android:padding="20dp"> 
<TextView 
android:id="@+id/textViewDateTime" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:text="Select Date & Time" 
android:textSize="18sp" 
android:textStyle="bold" 
android:gravity="center" 
android:padding="10dp" /> 
<Button 
android:id="@+id/btnPickDate" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:text="Pick Date" 
android:layout_marginTop="10dp"/> 
<Button 
android:id="@+id/btnPickTime" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:text="Pick Time" 
android:layout_marginTop="10dp"/> 
</LinearLayout>

//MainActivity.java
package com.example.datetimepicker; 
import android.app.DatePickerDialog; 
import android.app.TimePickerDialog; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
import android.widget.Toast; 
import androidx.appcompat.app.AppCompatActivity; 
import java.util.Calendar; 
public class MainActivity extends AppCompatActivity { 
TextView textViewDateTime; 
Button btnPickDate, btnPickTime; 
int year, month, day, hour, minute; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
textViewDateTime = findViewById(R.id.textViewDateTime); 
btnPickDate = findViewById(R.id.btnPickDate); 
btnPickTime = findViewById(R.id.btnPickTime); 
Calendar calendar = Calendar.getInstance(); 
year = calendar.get(Calendar.YEAR); 
month = calendar.get(Calendar.MONTH); 
day = calendar.get(Calendar.DAY_OF_MONTH); 
hour = calendar.get(Calendar.HOUR_OF_DAY); 
minute = calendar.get(Calendar.MINUTE); 
btnPickDate.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View v) { 
DatePickerDialog datePickerDialog = new DatePickerDialog( 
MainActivity.this, 
(view, selectedYear, selectedMonth, selectedDay) -> { 
year = selectedYear; 
month = selectedMonth; 
day = selectedDay; 
updateDateTimeText(); 
}, 
year, month, day 
); 
datePickerDialog.show(); 
} 
}); 
btnPickTime.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View v) { 
TimePickerDialog timePickerDialog = new TimePickerDialog( 
MainActivity.this, 
(view, selectedHour, selectedMinute) -> { 
hour = selectedHour; 
minute = selectedMinute; 
updateDateTimeText(); 
}, 
hour, minute, false 
); 
timePickerDialog.show(); 
} 
}); 
} 
private void updateDateTimeText() { 
String dateTime = "Selected Date & Time: " + day + "/" + (month + 1) + "/" + 
year + " " + hour + ":" + minute; 
textViewDateTime.setText(dateTime); 
} 
}
