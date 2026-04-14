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
        android:text="Start Music" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/b2" 
        android:text="Stop Music" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
 
</LinearLayout> 

//MainActivity.java
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    Button b1,b2; 
 
    @Override 
    protected void onCreate(Bundle b) { 
        super.onCreate(b); 
        setContentView(R.layout.activity_main); 
 
        b1=findViewById(R.id.b1); 
        b2=findViewById(R.id.b2); 
 
        Intent i=new Intent(this,MyService.class); 
 
        b1.setOnClickListener(v -> startService(i)); 
 
        b2.setOnClickListener(v -> stopService(i)); 
    } 
}

//myservice.java
package com.example.musicbg; 
 
import android.app.Service; 
import android.content.Intent; 
import android.media.MediaPlayer; 
import android.os.IBinder; 
 
public class MyService extends Service { 
 
    MediaPlayer mp; 
 
    @Override 
    public void onCreate() { 
        super.onCreate(); 
        mp=MediaPlayer.create(this,R.raw.song); 
        mp.setLooping(true); 
        mp.start(); 
    } 
 
    @Override 
    public void onDestroy() { 
        mp.stop(); 
        super.onDestroy(); 
    } 
 
    @Override 
    public IBinder onBind(Intent i) { 
        return null; 
    } 
}

//androidmanifest.java
<service android:name=".MyService"/> 
Add Audio File 
res → raw → song.mp3