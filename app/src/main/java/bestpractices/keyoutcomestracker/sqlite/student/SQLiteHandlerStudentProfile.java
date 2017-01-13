package bestpractices.keyoutcomestracker.sqlite.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bestpractices.keyoutcomestracker.gettersSetters.student.GetterSetterStudentProfile;

public class SQLiteHandlerStudentProfile {

    private SQLiteHelper sqLiteHelper;

    public SQLiteHandlerStudentProfile(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public int addStudentProfile(GetterSetterStudentProfile getterSetterStudentProfile){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqLiteHelper.KEY_STUDENT_FIRST_NAME, getterSetterStudentProfile.getStudentFirstName());
        contentValues.put(sqLiteHelper.KEY_STUDENT_LAST_NAME, getterSetterStudentProfile.getStudentLastName());
        contentValues.put(sqLiteHelper.KEY_STUDENT_SCHOOL_ID, getterSetterStudentProfile.getStudentSchoolID());
        contentValues.put(sqLiteHelper.KEY_STUDENT_SEMESTER, getterSetterStudentProfile.getStudentSemester());
        contentValues.put(sqLiteHelper.KEY_STUDENT_NUMBER_OF_CLASSES, getterSetterStudentProfile.getStudentNumberOfClasses());
        contentValues.put(sqLiteHelper.KEY_STUDENT_SCHOOL_NAME, getterSetterStudentProfile.getStudentSchoolName());

        long insertId = sqLiteDatabase.insert(sqLiteHelper.TABLE_STUDENT_PROFILE, null, contentValues);
        sqLiteDatabase.close();

        return (int) insertId;
    }

    GetterSetterStudentProfile getterSetterStudentProfile(int _id) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(sqLiteHelper.TABLE_STUDENT_PROFILE, new String[]{
           sqLiteHelper.KEY_STUDENT_FIRST_NAME,
                sqLiteHelper.KEY_STUDENT_LAST_NAME,
                sqLiteHelper.KEY_STUDENT_SCHOOL_ID,
                sqLiteHelper.KEY_STUDENT_SEMESTER,
                sqLiteHelper.KEY_STUDENT_NUMBER_OF_CLASSES,
                sqLiteHelper.KEY_STUDENT_SCHOOL_NAME},
                sqLiteHelper.KEY_ID_STUDENT + "=?",

                new String[]{String.valueOf(_id)}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        GetterSetterStudentProfile getterSetterStudentProfile = new GetterSetterStudentProfile(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6));

        cursor.close();
        return getterSetterStudentProfile;
    }

    public List<GetterSetterStudentProfile> getAllStudentProfile() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        List<GetterSetterStudentProfile> getterSetterStudentProfileList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                GetterSetterStudentProfile getterSetterStudentProfile = new GetterSetterStudentProfile();
                getterSetterStudentProfile.setIdStudent(Integer.parseInt(cursor.getString(0)));
                getterSetterStudentProfile.setStudentFirstName(cursor.getString(1));
                getterSetterStudentProfile.setStudentLastName(cursor.getString(2));
                getterSetterStudentProfile.setStudentSchoolID(cursor.getString(3));
                getterSetterStudentProfile.setStudentSemester(cursor.getString(4));
                getterSetterStudentProfile.setStudentNumberOfClasses(cursor.getString(5));
                getterSetterStudentProfile.setStudentSchoolName(cursor.getString(6));

                getterSetterStudentProfileList.add(getterSetterStudentProfile);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return getterSetterStudentProfileList;
    }


    public String getStudentFirstName(){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelper.KEY_STUDENT_FIRST_NAME + " FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String studentFirstNameDB = null;

        if(cursor.moveToFirst()) {
            do{
                studentFirstNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelper.KEY_STUDENT_FIRST_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return studentFirstNameDB;
    }

    public String getStudentLastName(){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelper.KEY_STUDENT_LAST_NAME + " FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String studentLastNameDB = null;

        if(cursor.moveToFirst()) {
            do{
                studentLastNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelper.KEY_STUDENT_LAST_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return studentLastNameDB;
    }

    public String getStudentSchoolID(){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelper.KEY_STUDENT_SCHOOL_ID + " FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String studentSchoolIdDB = null;

        if(cursor.moveToFirst()) {
            do{
                studentSchoolIdDB = cursor.getString(cursor.getColumnIndex(sqLiteHelper.KEY_STUDENT_SCHOOL_ID));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return studentSchoolIdDB;
    }

    public String getStudentSemester(){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelper.KEY_STUDENT_SEMESTER + " FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String studentSemesterDB = null;

        if(cursor.moveToFirst()) {
            do{
                studentSemesterDB = cursor.getString(cursor.getColumnIndex(sqLiteHelper.KEY_STUDENT_SEMESTER));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return studentSemesterDB;
    }

    public String getStudentNumberOfClasses(){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelper.KEY_STUDENT_NUMBER_OF_CLASSES + " FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String studentNumberOfClassesDB = null;

        if(cursor.moveToFirst()) {
            do{
                studentNumberOfClassesDB = cursor.getString(cursor.getColumnIndex(sqLiteHelper.KEY_STUDENT_NUMBER_OF_CLASSES));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return studentNumberOfClassesDB;
    }

    public String getStudentSchoolName(){
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelper.KEY_STUDENT_SCHOOL_NAME + " FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String studentSchoolNameDB = null;

        if(cursor.moveToFirst()) {
            do{
                studentSchoolNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelper.KEY_STUDENT_SCHOOL_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return studentSchoolNameDB;
    }


    //public int updateStudentProfile(GetterSetterStudentProfile getterSetterStudentProfile) {
        //SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
    //}

    public void deleteStudentProfile(GetterSetterStudentProfile getterSetterStudentProfile) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        sqLiteDatabase.delete(sqLiteHelper.TABLE_STUDENT_PROFILE, sqLiteHelper.KEY_ID_STUDENT + " =? ",
                new String[]{String.valueOf(getterSetterStudentProfile.getIdStudent())});
            sqLiteDatabase.close();
    }

    public void deleteAllStudentProfile() {

        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + sqLiteHelper.TABLE_STUDENT_PROFILE);
        sqLiteDatabase.close();
    }
}
