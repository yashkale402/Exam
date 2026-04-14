//q2b
//activity_main.xml 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:orientation="vertical" 
    android:padding="16dp"> 
 
    <EditText 
        android:id="@+id/etName" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:hint="Enter Company Name" /> 
 
    <EditText 
        android:id="@+id/etAddress" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:hint="Enter Address" /> 
 
    <EditText 
        android:id="@+id/etPhone" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:hint="Enter Phone Number" 
        android:inputType="phone" /> 
 
    <Button 
        android:id="@+id/btnInsert" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:text="Insert Company" /> 
 
    <Button 
        android:id="@+id/btnView" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:text="View All Companies" /> 
</LinearLayout> 
 
 
 
//DatabaseHelper.java 
package com.example.companyapp; 
 
import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
 
public class DatabaseHelper extends SQLiteOpenHelper { 
    private static final String DATABASE_NAME = "CompanyDB"; 
    private static final String TABLE_NAME = "Company"; 
    private static final String COL_ID = "id"; 
    private static final String COL_NAME = "name"; 
    private static final String COL_ADDRESS = "address"; 
    private static final String COL_PHONE = "phno"; 
 
    public DatabaseHelper(Context context) { 
        super(context, DATABASE_NAME, null, 1); 
    } 
 
    @Override 
    public void onCreate(SQLiteDatabase db) { 
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + 
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                COL_NAME + " TEXT, " + 
                COL_ADDRESS + " TEXT, " + 
                COL_PHONE + " TEXT)"; 
        db.execSQL(createTable); 
    } 
 
    @Override 
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); 
        onCreate(db); 
    } 
 
    public boolean insertData(String name, String address, String phone) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
        ContentValues contentValues = new ContentValues(); 
        contentValues.put(COL_NAME, name); 
        contentValues.put(COL_ADDRESS, address); 
        contentValues.put(COL_PHONE, phone); 
 
        long result = db.insert(TABLE_NAME, null, contentValues); 
        return result != -1; 
    } 
 
    public Cursor getAllData() { 
        SQLiteDatabase db = this.getReadableDatabase(); 
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null); 
    } 
} 
 
 
 
//MainActivity.java 
package com.example.companyapp; 
 
import androidx.appcompat.app.AppCompatActivity; 
import android.database.Cursor; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast; 
 
public class MainActivity extends AppCompatActivity { 
    DatabaseHelper myDb; 
    EditText etName, etAddress, etPhone; 
    Button btnInsert, btnView; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        myDb = new DatabaseHelper(this); 
 
        etName = findViewById(R.id.etName); 
        etAddress = findViewById(R.id.etAddress); 
        etPhone = findViewById(R.id.etPhone); 
 
        btnInsert = findViewById(R.id.btnInsert); 
        btnView = findViewById(R.id.btnView); 
 
        addData(); 
       display(); 
    } 
 
    public void addData() { 
        btnInsert.setOnClickListener(view -> { 
            boolean isInserted = myDb.insertData( 
                    etName.getText().toString(), 
                    etAddress.getText().toString(), 
                    etPhone.getText().toString() 
            ); 
 
            if (isInserted) { 
                Toast.makeText(MainActivity.this, "Data Inserted", 
Toast.LENGTH_LONG).show(); 
                etName.setText(""); 
                etAddress.setText(""); 
                etPhone.setText(""); 
            } else { 
                Toast.makeText(MainActivity.this, "Insertion Failed", 
Toast.LENGTH_LONG).show(); 
            } 
        }); 
    } 
 
    public void display() { 
        btnView.setOnClickListener(view -> { 
            Cursor res = myDb.getAllData(); 
            if (res.getCount() == 0) { 
                Toast.makeText(MainActivity.this, "No Data Found", 
Toast.LENGTH_LONG).show(); 
                return; 
            } 
 
            StringBuilder buffer = new StringBuilder(); 
            while (res.moveToNext()) { 
                buffer.append("ID: ").append(res.getString(0)).append("\n"); 
                buffer.append("Name: ").append(res.getString(1)).append("\n"); 
                buffer.append("Address: ").append(res.getString(2)).append("\n"); 
                buffer.append("Phone: ").append(res.getString(3)).append("\n\n"); 
            } 
 
            Toast.makeText(MainActivity.this, buffer.toString(), 
Toast.LENGTH_LONG).show(); 
        }); 
    } 
}