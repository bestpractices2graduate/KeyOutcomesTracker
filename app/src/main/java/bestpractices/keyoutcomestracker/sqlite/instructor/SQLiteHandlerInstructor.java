package bestpractices.keyoutcomestracker.sqlite.instructor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bestpractices.keyoutcomestracker.gettersSetters.instructor.GetterSetterInstructor;


public class SQLiteHandlerInstructor {
    private SQLiteHelperInstructor sqLiteHelperInstructor;

    public SQLiteHandlerInstructor(Context context) {
        sqLiteHelperInstructor = new SQLiteHelperInstructor(context);
    }

    public int addInstructorProfile(GetterSetterInstructor getterSetterInstructor) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqLiteHelperInstructor.KEY_INSTRUCTOR_FIRST_NAME, getterSetterInstructor.getInstructorFirstName());
        contentValues.put(sqLiteHelperInstructor.KEY_INSTRUCTOR_LAST_NAME, getterSetterInstructor.getInstructorLastName());
        contentValues.put(sqLiteHelperInstructor.KEY_INSTRUCTOR_OFFICE_NUMBER, getterSetterInstructor.getInstructorOfficeNumber());
        contentValues.put(sqLiteHelperInstructor.KEY_INSTRUCTOR_BUILDING, getterSetterInstructor.getInstructorBuilding());
        contentValues.put(sqLiteHelperInstructor.KEY_INSTRUCTOR_EMAIL_ADDRESS, getterSetterInstructor.getInstructorEmailAddress());
        contentValues.put(sqLiteHelperInstructor.KEY_INSTRUCTOR_PHONE_NUMBER, getterSetterInstructor.getInstructorPhoneNumber());

        long insertId = sqLiteDatabase.insert(sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE, null, contentValues);
        sqLiteDatabase.close();

        return (int) insertId;
    }

    GetterSetterInstructor getterSetterInstructor(int _id) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE, new String[]{
                        sqLiteHelperInstructor.KEY_INSTRUCTOR_FIRST_NAME,
                        sqLiteHelperInstructor.KEY_INSTRUCTOR_LAST_NAME,
                        sqLiteHelperInstructor.KEY_INSTRUCTOR_OFFICE_NUMBER,
                        sqLiteHelperInstructor.KEY_INSTRUCTOR_BUILDING,
                        sqLiteHelperInstructor.KEY_INSTRUCTOR_EMAIL_ADDRESS,
                        sqLiteHelperInstructor.KEY_INSTRUCTOR_PHONE_NUMBER},
                sqLiteHelperInstructor.KEY_ID_INSTRUCTOR + "=?",

                new String[]{String.valueOf(_id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        GetterSetterInstructor getterSetterInstructor = new GetterSetterInstructor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6));

        cursor.close();
        return getterSetterInstructor;
    }

    public List<GetterSetterInstructor> getAllInstructorProfile() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        List<GetterSetterInstructor> getterSetterInstructorList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GetterSetterInstructor getterSetterInstructor = new GetterSetterInstructor();
                getterSetterInstructor.setIdInstructor(Integer.parseInt(cursor.getString(0)));
                getterSetterInstructor.setInstructorFirstName(cursor.getString(1));
                getterSetterInstructor.setInstructorLastName(cursor.getString(2));
                getterSetterInstructor.setInstructorOfficeNumber(cursor.getString(3));
                getterSetterInstructor.setInstructorBuilding(cursor.getString(4));
                getterSetterInstructor.setInstructorEmailAddress(cursor.getString(5));
                getterSetterInstructor.setInstructorPhoneNumber(cursor.getString(6));

                getterSetterInstructorList.add(getterSetterInstructor);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return getterSetterInstructorList;
    }


    public String getInstructorFirstName() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperInstructor.KEY_INSTRUCTOR_FIRST_NAME + " FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String instructorFirstNameDB = null;

        if (cursor.moveToFirst()) {
            do {
                instructorFirstNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperInstructor.KEY_INSTRUCTOR_FIRST_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return instructorFirstNameDB;
    }

    public String getInstructorLastName() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperInstructor.KEY_INSTRUCTOR_LAST_NAME + " FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String instructorLastNameDB = null;

        if (cursor.moveToFirst()) {
            do {
                instructorLastNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperInstructor.KEY_INSTRUCTOR_LAST_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return instructorLastNameDB;
    }

    public String getInstructorOfficeNumber() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperInstructor.KEY_INSTRUCTOR_OFFICE_NUMBER + " FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String instructorOfficeNumberDB = null;

        if (cursor.moveToFirst()) {
            do {
                instructorOfficeNumberDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperInstructor.KEY_INSTRUCTOR_OFFICE_NUMBER));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return instructorOfficeNumberDB;
    }

    public String getInstructorBuilding() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperInstructor.KEY_INSTRUCTOR_BUILDING + " FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String instructorBuildingDB = null;

        if (cursor.moveToFirst()) {
            do {
                instructorBuildingDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperInstructor.KEY_INSTRUCTOR_BUILDING));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return instructorBuildingDB;
    }

    public String getInstructorEmailAddress() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperInstructor.KEY_INSTRUCTOR_EMAIL_ADDRESS + " FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String instructorEmailAddressDB = null;

        if (cursor.moveToFirst()) {
            do {
                instructorEmailAddressDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperInstructor.KEY_INSTRUCTOR_EMAIL_ADDRESS));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return instructorEmailAddressDB;
    }

    public String getInstructorPhoneNumber() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperInstructor.KEY_INSTRUCTOR_PHONE_NUMBER + " FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String instructorPhoneNumberDB = null;

        if (cursor.moveToFirst()) {
            do {
                instructorPhoneNumberDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperInstructor.KEY_INSTRUCTOR_PHONE_NUMBER));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return instructorPhoneNumberDB;
    }


    //public int updateStudentProfile(GetterSetterInstructor GetterSetterInstructor) {
    //SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
    //}

    public void deleteInstructorProfile(GetterSetterInstructor getterSetterInstructor) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        sqLiteDatabase.delete(sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE, sqLiteHelperInstructor.KEY_ID_INSTRUCTOR + " =? ",
                new String[]{String.valueOf(getterSetterInstructor.getIdInstructor())});
        sqLiteDatabase.close();
    }

    public void deleteAllInstructorProfile() {

        SQLiteDatabase sqLiteDatabase = sqLiteHelperInstructor.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + sqLiteHelperInstructor.TABLE_INSTRUCTOR_PROFILE);
        sqLiteDatabase.close();
    }
}
