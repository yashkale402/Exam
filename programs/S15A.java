//q1

<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:background="#3F51B5"> <!-- App background color --> 
 
    <!-- Outer Layout (Acts as the Border) --> 
    <LinearLayout 
        android:layout_width="250dp" 
        android:layout_height="250dp" 
        android:layout_centerInParent="true" 
        android:background="#CCCCCC"  <!-- Border color --> 
        android:padding="5dp">  <!-- Thickness of the border --> 
 
        <!-- Inner Layout (Actual Content) --> 
        <LinearLayout 
            android:layout_width="match_parent" 
            android:layout_height="match_parent" 
            android:gravity="center" 
            android:background="#6666FF"> <!-- Inner Background Color --> 
 
            <TextView 
                android:layout_width="wrap_content" 
                android:layout_height="wrap_content" 
                android:text="Hello World!" 
                android:textSize="20sp" 
                android:textColor="#FFFFFF"/> 
        </LinearLayout> 
 
    </LinearLayout> 
 
</RelativeLayout>