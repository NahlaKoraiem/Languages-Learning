package ideanity.oceans.languagelearning;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_COURSE = "user_course";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_COURSE + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addNewUser(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, name);
        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PASSWORD, password);
        values.put(COLUMN_USER_COURSE, "0000");
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean ifExistsReg(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query,null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean ifExistsLog(String email, String password ){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "' " +
                "AND user_password = '"+ password + "'";
        Cursor cursor= db.rawQuery(query,null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public String getName(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT user_name FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        cursor.moveToFirst();
        String name = cursor.getString(0);
        cursor.close();
        db.close();
        return name;
    }

    public boolean ifFrench(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT user_course FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        if (cursor.moveToFirst() && cursor.getCount() >= 1){
            String course = cursor.getString(0);
            if(course.charAt(2)=='0') {
                cursor.close();
                db.close();
                return false;
            }
        }
        cursor.close();
        db.close();
        return true;
    }

    public boolean ifSpanish(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT user_course FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        if (cursor.moveToFirst() && cursor.getCount() >= 1){
            String course = cursor.getString(0);
            if(course.charAt(1)=='0') {
                cursor.close();
                db.close();
                return false;
            }
        }
        cursor.close();
        db.close();
        return true;
    }

    public boolean ifEnglish(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT user_course FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        if (cursor.moveToFirst() && cursor.getCount() >= 1){
            String course = cursor.getString(0);
            if(course.charAt(0)=='0') {
                cursor.close();
                db.close();
                return false;
            }
        }
        cursor.close();
        db.close();
        return true;
    }

    public boolean ifGerman(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT user_course FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        if (cursor.moveToFirst() && cursor.getCount() >= 1){
            String course = cursor.getString(0);
            if(course.charAt(3)=='0') {
                cursor.close();
                db.close();
                return false;
            }
        }
        cursor.close();
        db.close();
        return true;
    }

    public void enroll(int i, String email){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        String query ="SELECT user_course FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        cursor.moveToFirst();
        String course = cursor.getString(0);
        StringBuilder enrolled = new StringBuilder(course);
        enrolled.setCharAt(i, '1');

        query = "UPDATE " + TABLE_NAME + " SET user_course='" + enrolled + "' WHERE user_email='" + email +"'";
        db.execSQL(query);

        cursor.close();
        db.close();
    }

    public String getCourses(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT user_course FROM "+ TABLE_NAME +" WHERE user_email ='"+ email + "'";
        Cursor cursor= db.rawQuery(query, null);
        cursor.moveToFirst();

        String course= "";
        if (cursor.moveToFirst() && cursor.getCount() >= 1)
            course = cursor.getString(0);
        cursor.close();
        db.close();
        return course;
    }
}

