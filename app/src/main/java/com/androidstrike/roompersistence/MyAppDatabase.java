package com.androidstrike.roompersistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database( entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

//    an abstract method that returns the object of the DAO class
    public abstract MyDao myDao();

}
