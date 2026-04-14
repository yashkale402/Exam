//q2a
//activitymain.xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

<LinearLayout
    android:orientation="vertical"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <EditText
        android:id="@+id/fname"
        android:hint="First Name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/mname"
        android:hint="Middle Name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/lname"
        android:hint="Last Name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/dob"
        android:hint="Date of Birth"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/address"
        android:hint="Address"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/email"
        android:hint="Email ID"
        android:inputType="textEmailAddress"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/submit"
        android:text="Submit"
        android:layout_marginTop="15dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
</ScrollView>

//mainactivity.java
package com.example.studentinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText fname, mname, lname, dob, address, email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("fname", fname.getText().toString());
            intent.putExtra("mname", mname.getText().toString());
            intent.putExtra("lname", lname.getText().toString());
            intent.putExtra("dob", dob.getText().toString());
            intent.putExtra("address", address.getText().toString());
            intent.putExtra("email", email.getText().toString());

            startActivity(intent);

        });
    }
}

//secondactivity.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView android:id="@+id/tfname"/>
    <TextView android:id="@+id/tmname"/>
    <TextView android:id="@+id/tlname"/>
    <TextView android:id="@+id/tdob"/>
    <TextView android:id="@+id/taddress"/>
    <TextView android:id="@+id/temail"/>

</LinearLayout>

//secondactivity.java
package com.example.studentinfo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView fname = findViewById(R.id.tfname);
        TextView mname = findViewById(R.id.tmname);
        TextView lname = findViewById(R.id.tlname);
        TextView dob = findViewById(R.id.tdob);
        TextView address = findViewById(R.id.taddress);
        TextView email = findViewById(R.id.temail);

        fname.setText("First Name: " + getIntent().getStringExtra("fname"));
        mname.setText("Middle Name: " + getIntent().getStringExtra("mname"));
        lname.setText("Last Name: " + getIntent().getStringExtra("lname"));
        dob.setText("DOB: " + getIntent().getStringExtra("dob"));
        address.setText("Address: " + getIntent().getStringExtra("address"));
        email.setText("Email: " + getIntent().getStringExtra("email"));
    }
}

