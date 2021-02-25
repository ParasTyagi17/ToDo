package com.example.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class todoDbHelper extends SQLiteOpenHelper {

    public todoDbHelper(Context context) {
        super(context, todoContract.DB_NAME, null, todoContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + todoContract.TaskEntry.TABLE + " ( " +
                todoContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                todoContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + todoContract.TaskEntry.TABLE);
        onCreate(db);
    }
}
