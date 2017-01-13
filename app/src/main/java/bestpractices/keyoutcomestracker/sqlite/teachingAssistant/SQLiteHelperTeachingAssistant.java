package bestpractices.keyoutcomestracker.sqlite.teachingAssistant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelperTeachingAssistant extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "key_out_comes_tracker_db";
    public static final String TABLE_TEACHING_ASSISTANT_PROFILE = "teaching_assistant_table";
    static final String KEY_ID_TEACHING_ASSISTANT = "id_teaching_assistant";
    static final String KEY_TEACHING_ASSISTANT_FIRST_NAME = "teaching_assistant_first_name";
    static final String KEY_TEACHING_ASSISTANT_LAST_NAME = "teaching_assistant_last_name";
    static final String KEY_TEACHING_ASSISTANT_OFFICE_NUMBER = "teaching_assistant_office_number";
    static final String KEY_TEACHING_ASSISTANT_BUILDING = "teaching_assistant_building";
    static final String KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS = "teaching_assistant_email_address";
    static final String KEY_TEACHING_ASSISTANT_PHONE_NUMBER = "teaching_assistant_phone_number";

    public SQLiteHelperTeachingAssistant(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_STUDENT_TEACHING_ASSISTANT_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_TEACHING_ASSISTANT_PROFILE + "("
                + KEY_ID_TEACHING_ASSISTANT + " INTEGER PRIMARY KEY, "
                + KEY_TEACHING_ASSISTANT_FIRST_NAME + " TEXT, "
                + KEY_TEACHING_ASSISTANT_LAST_NAME + " TEXT, "
                + KEY_TEACHING_ASSISTANT_OFFICE_NUMBER + " TEXT, "
                + KEY_TEACHING_ASSISTANT_BUILDING + " TEXT, "
                + KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS + " TEXT, "
                + KEY_TEACHING_ASSISTANT_PHONE_NUMBER + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TEACHING_ASSISTANT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHING_ASSISTANT_PROFILE);
        onCreate(sqLiteDatabase);
    }
}