package com.androidstrike.roompersistence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

//        we then initialize the app database
//        thus using the created object of the MyAppDatabase class, we can perform the database transactions
//        TODO Note! it is not good practice to perform database queries on the main thread...LEARN ASYNCTASK or RXANDROID
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class, "userdb").allowMainThreadQueries().build();

        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}
