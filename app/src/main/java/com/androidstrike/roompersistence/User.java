package com.androidstrike.roompersistence;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//By default, the table name of an entity is the class name, to change the tableName, we use the below statement
@Entity (tableName = "users")
public class User {

//    we create three variables that will represent the various column names of the table at default
//    if we want to assign a particular column name to the column variables, we use a certain annotation

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;

//    add getter and setters for the variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }
//    todo after generating the getters and setters we create the Dao abstract class
}

