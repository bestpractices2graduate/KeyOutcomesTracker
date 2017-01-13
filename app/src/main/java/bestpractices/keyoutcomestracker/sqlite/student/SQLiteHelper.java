package bestpractices.keyoutcomestracker.sqlite.student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "key_out_comes_tracker_db";
    public static final String TABLE_STUDENT_PROFILE = "student_profile_table";
    static final String KEY_ID_STUDENT = "id_student";
    static final String KEY_STUDENT_FIRST_NAME = "student_first_name";
    static final String KEY_STUDENT_LAST_NAME = "student_last_name";
    static final String KEY_STUDENT_SCHOOL_ID = "student_school_id";
    static final String KEY_STUDENT_SEMESTER = "student_semester";
    static final String KEY_STUDENT_NUMBER_OF_CLASSES = "student_number_of_classes";
    static final String KEY_STUDENT_SCHOOL_NAME = "student_school_name";

    public static final String TABLE_INSTRUCTOR_PROFILE = "instructor_table";
    static final String KEY_ID_INSTRUCTOR = "id_instructor";
    static final String KEY_INSTRUCTOR_FIRST_NAME = "instructor_first_name";
    static final String KEY_INSTRUCTOR_LAST_NAME = "instructor_last_name";
    static final String KEY_INSTRUCTOR_OFFICE_NUMBER = "instructor_office_number";
    static final String KEY_INSTRUCTOR_BUILDING = "instructor_building";
    static final String KEY_INSTRUCTOR_EMAIL_ADDRESS = "instructor_email_address";
    static final String KEY_INSTRUCTOR_PHONE_NUMBER = "instructor_phone_number";

    public static final String TABLE_TEACHING_ASSISTANT_PROFILE = "teaching_assistant_table";
    static final String KEY_ID_TEACHING_ASSISTANT = "id_teaching_assistant";
    static final String KEY_TEACHING_ASSISTANT_FIRST_NAME = "teaching_assistant_first_name";
    static final String KEY_TEACHING_ASSISTANT_LAST_NAME = "teaching_assistant_last_name";
    static final String KEY_TEACHING_ASSISTANT_OFFICE_NUMBER = "teaching_assistant_office_number";
    static final String KEY_TEACHING_ASSISTANT_BUILDING = "teaching_assistant_building";
    static final String KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS = "teaching_assistant_email_address";
    static final String KEY_TEACHING_ASSISTANT_PHONE_NUMBER = "teaching_assistant_phone_number";

    public static final String TABLE_COURSES = "courses_table";
    public static final String KEY_ID_COURSES = "id_courses";
    public static final String KEY_COURSES_COURSE_NUMBER = "courses_course_number";
    public static final String KEY_COURSES_COURSE_NAME = "courses_course_name";
    public static final String KEY_COURSES_COURSE_DESCRIPTION = "courses_course_description";
    public static final String KEY_COURSES_COURSE_ROOM_NUMBER = "courses_course_room_number";
    public static final String KEY_COURSES_COURSE_INSTRUCTOR = "courses_course_instructor";
    public static final String KEY_COURSES_COURSE_TEACHING_ASSISTANT = "courses_course_teaching_assistant";
    public static final String KEY_COURSES_COURSE_SEMESTER_START_DATE = "courses_course_semester_start_date";
    public static final String KEY_COURSES_COURSE_SEMESTER_END_DATE = "courses_course_semester_end_date";
    public static final String KEY_COURSES_COURSE_DAYS = "courses_course_days";
    public static final String KEY_COURSES_LECTURE_START_TIME = "courses_lecture_start_time";
    public static final String KEY_COURSES_LECTURE_END_TIME = "courses_lecture_end_time";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    // Creating student profile table
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_STUDENT_PROFILE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_STUDENT_PROFILE + "("
                + KEY_ID_STUDENT + " INTEGER PRIMARY KEY, "
                + KEY_STUDENT_FIRST_NAME + " TEXT, "
                + KEY_STUDENT_LAST_NAME + " TEXT, "
                + KEY_STUDENT_SCHOOL_ID + " TEXT, "
                + KEY_STUDENT_SEMESTER + " TEXT, "
                + KEY_STUDENT_NUMBER_OF_CLASSES + " TEXT, "
                + KEY_STUDENT_SCHOOL_NAME + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_STUDENT_PROFILE_TABLE);

        // Creating instructor profile table
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

        // Creating teaching assistant profile table
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

        // Creating courses table
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
                + KEY_COURSES_LECTURE_START_TIME + " TEXT, "
                + KEY_COURSES_LECTURE_END_TIME + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_COURSES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_PROFILE);
        onCreate(sqLiteDatabase);
    }
}
