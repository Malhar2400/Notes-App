package com.app.notesapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.notesapp.Model.Notes;

@Database(entities = Notes.class,version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB databse;
    private static String databse_name = "NoteApp";

    public synchronized static RoomDB getInstance(Context context){
        if (databse == null){
            databse = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class,databse_name)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return databse;
    }

    public abstract MainDAO mainDAO();


}
