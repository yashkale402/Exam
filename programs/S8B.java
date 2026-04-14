//q2a
//activity_main.xml 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:orientation="vertical" 
    android:padding="20dp" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <Button 
        android:id="@+id/b1" 
        android:text="Download File" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
 
</LinearLayout>

//MainActivity.java 
package com.example.downloadapp; 
 
import android.content.*; 
import android.os.Bundle; 
import android.widget.*; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    Button b1; 
 
    BroadcastReceiver br = new BroadcastReceiver() { 
        @Override 
        public void onReceive(Context c, Intent i) { 
            Toast.makeText(c,"Download Complete",Toast.LENGTH_LONG).show(); 
        } 
    }; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        b1 = findViewById(R.id.b1); 
 
        registerReceiver(br,new IntentFilter("DOWN")); 
 
        b1.setOnClickListener(v -> { 
            Intent i = new Intent(MainActivity.this,MyService.class); 
            startService(i); 
        }); 
    } 
} 


//MyService.java 
package com.example.downloadapp; 
 
import android.app.Service; 
import android.content.Intent; 
import android.os.IBinder; 
 
import java.io.InputStream; 
import java.net.URL; 
 
public class MyService extends Service { 
 
    @Override 
    public int onStartCommand(Intent i,int f,int s) { 
 
        new Thread(() -> { 
 
            try { 
 
                URL u = new URL("https://example.com/file.pdf"); 
                InputStream in = u.openStream(); 
 
                while(in.read()!=-1) { } 
 
                Intent b = new Intent("DOWN"); 
                sendBroadcast(b); 
 
            } catch(Exception e){ } 
 
        }).start(); 
 
        return START_STICKY; 
    } 
 
    @Override 
    public IBinder onBind(Intent i) { 
        return null; 
} 
}

//AndroidManifest.xml 
<uses-permission android:name="android.permission.INTERNET"/> 
<application> 
<service android:name=".MyService"/> 
</application>