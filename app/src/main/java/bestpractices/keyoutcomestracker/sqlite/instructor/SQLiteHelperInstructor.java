package bestpractices.keyoutcomestracker.sqlite.instructor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelperInstructor extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "key_out_comes_tracker_db";
    public static final String TABLE_INSTRUCTOR_PROFILE = "instructor_table";
    static final String KEY_ID_INSTRUCTOR = "id_instructor";
    static final String KEY_INSTRUCTOR_FIRST_NAME = "instructor_first_name";
    static final String KEY_INSTRUCTOR_LAST_NAME = "instructor_last_name";
    static final String KEY_INSTRUCTOR_OFFICE_NUMBER = "instructor_office_number";
    static final String KEY_INSTRUCTOR_BUILDING = "instructor_building";
    static final String KEY_INSTRUCTOR_EMAIL_ADDRESS = "instructor_email_address";
    static final String KEY_INSTRUCTOR_PHONE_NUMBER = "instructor_phone_number";

    public SQLiteHelperInstructor(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_INSTRUCTOR_PROFILE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_INSTRUCTOR_PROFILE + "("
                + KEY_ID_INSTRUCTOR + " INTEGER PRIMARY KEY, "
                + KEY_INSTRUCTOR_FIRST_NAME + " TEXT, "
                + KEY_INSTRUCTOR_LAST_NAME + " TEXT, "
                + KEY_INSTRUCTOR_OFFICE_NUMBER + " TEXT, "
                + KEY_INSTRUCTOR_BUILDING + " TEXT, "
                + KEY_INSTRUCTOR_EMAIL_ADDRESS + " TEXT, "
                + KEY_INSTRUCTOR_PHONE_NUMBER + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_INSTRUCTOR_PROFILE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INSTRUCTOR_PROFILE);
        onCreate(sqLiteDatabase);
    }
}