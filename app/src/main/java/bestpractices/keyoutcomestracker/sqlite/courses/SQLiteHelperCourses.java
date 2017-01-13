package bestpractices.keyoutcomestracker.sqlite.courses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelperCourses extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "key_out_comes_tracker_db";
    public static final String TABLE_COURSES = "courses_table";
    static final String KEY_ID_COURSES = "id_courses";
    static final String KEY_COURSES_COURSE_NUMBER = "courses_course_number";
    static final String KEY_COURSES_COURSE_NAME = "courses_course_name";
    static final String KEY_COURSES_COURSE_DESCRIPTION = "courses_course_description";
    static final String KEY_COURSES_COURSE_ROOM_NUMBER = "courses_course_room_number";
    static final String KEY_COURSES_COURSE_INSTRUCTOR = "courses_course_instructor";
    static final String KEY_COURSES_COURSE_TEACHING_ASSISTANT = "courses_course_teaching_assistant";
    static final String KEY_COURSES_COURSE_SEMESTER_START_DATE = "courses_course_semester_start_date";
    static final String KEY_COURSES_COURSE_SEMESTER_END_DATE = "courses_course_semester_end_date";
    static final String KEY_COURSES_COURSE_DAYS = "courses_course_days";
    static final String KEY_COURSES_LECTURE_TIMES = "courses_lecture_times";

    public SQLiteHelperCourses(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_COURSES_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_COURSES + "("
                + KEY_ID_COURSES + " INTEGER PRIMARY KEY, "
                + KEY_COURSES_COURSE_NUMBER + " TEXT, "
                + KEY_COURSES_COURSE_NAME + " TEXT, "
                + KEY_COURSES_COURSE_DESCRIPTION + " TEXT, "
                + KEY_COURSES_COURSE_ROOM_NUMBER + " TEXT, "
                + KEY_COURSES_COURSE_INSTRUCTOR + " TEXT, "
                + KEY_COURSES_COURSE_TEACHING_ASSISTANT + " TEXT, "
                + KEY_COURSES_COURSE_SEMESTER_START_DATE + " TEXT, "
                + KEY_COURSES_COURSE_SEMESTER_END_DATE + " TEXT, "
                + KEY_COURSES_COURSE_DAYS + " TEXT, "
                + KEY_COURSES_LECTURE_TIMES + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_COURSES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        onCreate(sqLiteDatabase);
    }
}