//q1
//MainActivity.xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

<LinearLayout
    android:orientation="vertical"
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <EditText
        android:id="@+id/name"
        android:hint="Name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/surname"
        android:hint="Surname"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/classname"
        android:hint="Class"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <TextView
        android:text="Gender"/>

    <RadioGroup
        android:id="@+id/genderGroup">

        <RadioButton
            android:id="@+id/male"
            android:text="Male"/>

        <RadioButton
            android:id="@+id/female"
            android:text="Female"/>
    </RadioGroup>

    <TextView
        android:text="Hobbies"/>

    <CheckBox
        android:id="@+id/sports"
        android:text="Sports"/>

    <CheckBox
        android:id="@+id/music"
        android:text="Music"/>

    <CheckBox
        android:id="@+id/reading"
        android:text="Reading"/>

    <EditText
        android:id="@+id/marks"
        android:hint="Marks"
        android:inputType="number"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/submit"
        android:text="Submit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
</ScrollView>

//MainActivity.java
package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, surname, classname, marks;
    RadioGroup genderGroup;
    CheckBox sports, music, reading;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        classname = findViewById(R.id.classname);
        marks = findViewById(R.id.marks);
        genderGroup = findViewById(R.id.genderGroup);

        sports = findViewById(R.id.sports);
        music = findViewById(R.id.music);
        reading = findViewById(R.id.reading);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            String n = name.getText().toString();
            String s = surname.getText().toString();
            String c = classname.getText().toString();
            String m = marks.getText().toString();

            int genderId = genderGroup.getCheckedRadioButtonId();
            RadioButton genderBtn = findViewById(genderId);
            String gender = genderBtn.getText().toString();

            String hobbies = "";
            if (sports.isChecked()) hobbies += "Sports ";
            if (music.isChecked()) hobbies += "Music ";
            if (reading.isChecked()) hobbies += "Reading ";

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("name", n);
            intent.putExtra("surname", s);
            intent.putExtra("class", c);
            intent.putExtra("gender", gender);
            intent.putExtra("hobbies", hobbies);
            intent.putExtra("marks", m);

            startActivity(intent);
        });
    }
}

//SecondActivity.xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TableRow>
        <TextView android:text="Name"/>
        <TextView android:id="@+id/tName"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Surname"/>
        <TextView android:id="@+id/tSurname"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Class"/>
        <TextView android:id="@+id/tClass"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Gender"/>
        <TextView android:id="@+id/tGender"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Hobbies"/>
        <TextView android:id="@+id/tHobbies"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Marks"/>
        <TextView android:id="@+id/tMarks"/>
    </TableRow>

</TableLayout>

//SecondActivity.java
package com.example.studentapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView name = findViewById(R.id.tName);
        TextView surname = findViewById(R.id.tSurname);
        TextView clas = findViewById(R.id.tClass);
        TextView gender = findViewById(R.id.tGender);
        TextView hobbies = findViewById(R.id.tHobbies);
        TextView marks = findViewById(R.id.tMarks);

        name.setText(getIntent().getStringExtra("name"));
        surname.setText(getIntent().getStringExtra("surname"));
        clas.setText(getIntent().getStringExtra("class"));
        gender.setText(getIntent().getStringExtra("gender"));
        hobbies.setText(getIntent().getStringExtra("hobbies"));
        marks.setText(getIntent().getStringExtra("marks"));
    }
}
