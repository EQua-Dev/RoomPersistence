package com.androidstrike.roompersistence;

import android.widget.ListView;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//you can specify the possible methods for the database operations using this interface
//these operations include: update, delete, insert etc

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);
}

//todo create the database abstract class
