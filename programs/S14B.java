//q2a

//activitymain.xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:orientation="vertical" 
    android:padding="16dp"> 
 
    <TextView 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content" 
        android:text="Coffee?" 
        android:textSize="18sp" 
        android:textStyle="bold" 
        android:paddingBottom="10dp"/> 
 
    <Spinner 
        android:id="@+id/spinner" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content" 
        android:textSize="18sp" 
        android:background="@android:drawable/btn_dropdown" 
        android:popupBackground="#FFFFFF"/> 
 
</LinearLayout> 
 
//String.xml 
 
<resources> 
    <string name="app_name">Spinner Style</string> 
 
    <!-- Define coffee options for Spinner --> 
    <string-array name="coffee_options"> 
        <item>Filter</item> 
        <item>Americano</item> 
        <item>Latte</item> 
        <item>Espresso</item> 
        <item>Cappuccino</item> 
        <item>Mocha</item> 
        <item>Skinny Latte</item> 
        <item>Espresso Corretto</item> 
    </string-array> 
 
</resources>
