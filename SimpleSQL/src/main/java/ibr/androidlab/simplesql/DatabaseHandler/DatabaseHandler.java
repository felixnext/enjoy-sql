package ibr.androidlab.simplesql.DatabaseHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import ibr.androidlab.simplesql.Database.User;

/**
 * Created by Saria on 28.11.2013.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SimpleSQL";

    // table names
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_PREFERENCES = "UserPreferences";


    private static final String KEY_ID = "id";

    // Users Table Columns names
    private static final String KEY_NAME = "userName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_SCORE = "score";
    private static final String KEY_STATE_ID = "stateId";
    private static final String KEY_PREF_ID = "prefId";

    // Preferences table columns names
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_HINTS = "hintsOn";
    private static final String KEY_TEXT_SIZE = "textSize";

    // UserState table columns
    private static final String KEY_CHAPTER = "chapter";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_TASK = "task";
    private static final String KEY_SAVED_QUERY = "query";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    // GRUD OPERATIONS

    // Adding new user
    public void addUser(User user)
    {
        // open database for writing
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_EMAIL,user.getEmail());

        // Insert row to database
        db.insert(TABLE_USERS,null, values);
        db.close(); // close the database connection
    }

    // Getting single user
    public User getUser(int userid)
    {
        // open database for reading
        SQLiteDatabase db = this.getReadableDatabase();
        // SQLite query returns a cursor object
        // query method takes parameters as query members
        Cursor cursor = db.query(TABLE_USERS, new String[]{
                KEY_ID, KEY_NAME, KEY_EMAIL, KEY_SCORE}, KEY_ID+ "?",
                new String[] { String.valueOf(userid)}, null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));

        return user;

    }

    // Getting All users
    // TODO: make to get list of user scores for high score list
    public List<User> getAllUsers()
    {
        List<User> userList = new ArrayList<User>();
        String selectQuery = "SELECT * FROM" + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        // raw query takes string as query
        Cursor cursor = db.rawQuery(selectQuery, null);

        // for each row on the list
        if (cursor.moveToFirst())
        {
            do {
                User user = new User();
                user.setID(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));

                // add user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        return userList;

    }

    // Updating single user
    // needed if the data is being updated / saved
    public int updateUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_EMAIL,user.getEmail());

        // updating a row with values where id is selected id
        return db.update(TABLE_USERS, values, KEY_ID + " = ? ",
                new String[]{ String.valueOf(user.getID())});
    }

    // Deleting single user
    public void deleteUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getID()) });
        db.close();
    }



}
