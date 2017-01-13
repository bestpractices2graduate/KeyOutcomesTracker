package bestpractices.keyoutcomestracker.sqlite.courses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bestpractices.keyoutcomestracker.gettersSetters.courses.GetterSetterCourses;
import bestpractices.keyoutcomestracker.sqlite.student.SQLiteHelper;


public class SQLiteHandlerCourses {

    private SQLiteHelper sqLiteHelper;

    public SQLiteHandlerCourses(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public int addCourses(GetterSetterCourses getterSetterCourses) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_NUMBER, getterSetterCourses.getCourseNumber());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_NAME, getterSetterCourses.getCourseName());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_DESCRIPTION, getterSetterCourses.getCourseDescription());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_ROOM_NUMBER, getterSetterCourses.getCourseRoomNumber());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_INSTRUCTOR, getterSetterCourses.getCourseInstructor());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_TEACHING_ASSISTANT, getterSetterCourses.getCourseTeachingAssistant());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_SEMESTER_START_DATE, getterSetterCourses.getCourseSemesterStartDate());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_SEMESTER_END_DATE, getterSetterCourses.getCourseSemesterEndDate());
        contentValues.put(sqLiteHelper.KEY_COURSES_COURSE_DAYS, getterSetterCourses.getCourseDays());
        contentValues.put(sqLiteHelper.KEY_COURSES_LECTURE_START_TIME, getterSetterCourses.getCourseLectureStartTime());
        contentValues.put(sqLiteHelper.KEY_COURSES_LECTURE_END_TIME, getterSetterCourses.getCourseLectureEndTime());

        long insertId = sqLiteDatabase.insert(sqLiteHelper.TABLE_COURSES, null, contentValues);
        sqLiteDatabase.close();

        return (int) insertId;
    }

    GetterSetterCourses getterSetterCourses(int _id) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(sqLiteHelper.TABLE_COURSES, new String[]{
                        sqLiteHelper.KEY_COURSES_COURSE_NUMBER,
                        sqLiteHelper.KEY_COURSES_COURSE_NAME,
                        sqLiteHelper.KEY_COURSES_COURSE_DESCRIPTION,
                        sqLiteHelper.KEY_COURSES_COURSE_ROOM_NUMBER,
                        sqLiteHelper.KEY_COURSES_COURSE_INSTRUCTOR,
                        sqLiteHelper.KEY_COURSES_COURSE_TEACHING_ASSISTANT,
                        sqLiteHelper.KEY_COURSES_COURSE_SEMESTER_START_DATE,
                        sqLiteHelper.KEY_COURSES_COURSE_SEMESTER_END_DATE,
                        sqLiteHelper.KEY_COURSES_COURSE_DAYS,
                        sqLiteHelper.KEY_COURSES_LECTURE_START_TIME,
                        sqLiteHelper.KEY_COURSES_LECTURE_END_TIME},
                sqLiteHelper.KEY_ID_COURSES + "=?",

                new String[]{String.valueOf(_id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        GetterSetterCourses getterSetterCourses = new GetterSetterCourses(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11));

        cursor.close();
        return getterSetterCourses;
    }


    public List<GetterSetterCourses> getAllCourses() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        List<GetterSetterCourses> getterSetterCoursesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + sqLiteHelper.TABLE_COURSES;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GetterSetterCourses getterSetterCourses = new GetterSetterCourses();
                getterSetterCourses.setIdCourses(Integer.parseInt(cursor.getString(0)));
                getterSetterCourses.setCourseNumber(cursor.getString(1));
                getterSetterCourses.setCourseName(cursor.getString(2));
                getterSetterCourses.setCourseDescription(cursor.getString(3));
                getterSetterCourses.setCourseRoomNumber(cursor.getString(4));
                getterSetterCourses.setCourseInstructor(cursor.getString(5));
                getterSetterCourses.setCourseTeachingAssistant(cursor.getString(6));
                getterSetterCourses.setCourseSemesterStartDate(cursor.getString(7));
                getterSetterCourses.setCourseSemesterEndDate(cursor.getString(8));
                getterSetterCourses.setCourseDays(cursor.getString(9));
                getterSetterCourses.setCourseLectureStartTime(cursor.getString(10));
                getterSetterCourses.setCourseLectureEndTime(cursor.getString(11));

                getterSetterCoursesList.add(getterSetterCourses);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return getterSetterCoursesList;
    }

    public void deleteCourse(GetterSetterCourses getterSetterCourses) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        sqLiteDatabase.delete(sqLiteHelper.TABLE_COURSES, sqLiteHelper.KEY_ID_COURSES + " =? ",
                new String[]{String.valueOf(getterSetterCourses.getIdCourses())});
        sqLiteDatabase.close();
    }

    public void deleteAllCourses() {

        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + sqLiteHelper.TABLE_COURSES);
        sqLiteDatabase.close();
    }
}
