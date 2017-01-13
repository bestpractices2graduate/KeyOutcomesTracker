package bestpractices.keyoutcomestracker.sqlite.teachingAssistant;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bestpractices.keyoutcomestracker.gettersSetters.teachingAssistant.GetterSetterTeachingAssistant;

public class SQLiteHandlerTeachingAssistant {
    private SQLiteHelperTeachingAssistant sqLiteHelperTeachingAssistant;

    public SQLiteHandlerTeachingAssistant(Context context) {
        sqLiteHelperTeachingAssistant = new SQLiteHelperTeachingAssistant(context);
    }

    public int addTeachingAssistantProfile(GetterSetterTeachingAssistant getterSetterTeachingAssistant) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_FIRST_NAME, getterSetterTeachingAssistant.getTeachingAssistantFirstName());
        contentValues.put(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_LAST_NAME, getterSetterTeachingAssistant.getTeachingAssistantLastName());
        contentValues.put(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_OFFICE_NUMBER, getterSetterTeachingAssistant.getTeachingAssistantOfficeNumber());
        contentValues.put(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_BUILDING, getterSetterTeachingAssistant.getTeachingAssistantBuilding());
        contentValues.put(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS, getterSetterTeachingAssistant.getTeachingAssistantEmailAddress());
        contentValues.put(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_PHONE_NUMBER, getterSetterTeachingAssistant.getTeachingAssistantPhoneNumber());

        long insertId = sqLiteDatabase.insert(sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE, null, contentValues);
        sqLiteDatabase.close();

        return (int) insertId;
    }

    GetterSetterTeachingAssistant getterSetterTeachingAssistant(int _id) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE, new String[]{
                        sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_FIRST_NAME,
                        sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_LAST_NAME,
                        sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_OFFICE_NUMBER,
                        sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_BUILDING,
                        sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS,
                        sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_PHONE_NUMBER},
                sqLiteHelperTeachingAssistant.KEY_ID_TEACHING_ASSISTANT + "=?",

                new String[]{String.valueOf(_id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        GetterSetterTeachingAssistant getterSetterTeachingAssistant = new GetterSetterTeachingAssistant(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6));

        cursor.close();
        return getterSetterTeachingAssistant;
    }

    public List<GetterSetterTeachingAssistant> getAllTeachingAssistantProfile() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        List<GetterSetterTeachingAssistant> getterSetterTeachingAssistantList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GetterSetterTeachingAssistant GetterSetterTeachingAssistant = new GetterSetterTeachingAssistant();
                GetterSetterTeachingAssistant.setIdTeachingAssistant(Integer.parseInt(cursor.getString(0)));
                GetterSetterTeachingAssistant.setTeachingAssistantFirstName(cursor.getString(1));
                GetterSetterTeachingAssistant.setTeachingAssistantLastName(cursor.getString(2));
                GetterSetterTeachingAssistant.setTeachingAssistantOfficeNumber(cursor.getString(3));
                GetterSetterTeachingAssistant.setTeachingAssistantBuilding(cursor.getString(4));
                GetterSetterTeachingAssistant.setTeachingAssistantEmailAddress(cursor.getString(5));
                GetterSetterTeachingAssistant.setTeachingAssistantPhoneNumber(cursor.getString(6));

                getterSetterTeachingAssistantList.add(GetterSetterTeachingAssistant);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return getterSetterTeachingAssistantList;
    }


    public String getTeachingAssistantFirstName() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_FIRST_NAME + " FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String teachingAssistantFirstNameDB = null;

        if (cursor.moveToFirst()) {
            do {
                teachingAssistantFirstNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_FIRST_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return teachingAssistantFirstNameDB;
    }

    public String getTeachingAssistantLastName() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_LAST_NAME + " FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String teachingAssistantLastNameDB = null;

        if (cursor.moveToFirst()) {
            do {
                teachingAssistantLastNameDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_LAST_NAME));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return teachingAssistantLastNameDB;
    }

    public String getTeachingAssistantOfficeNumber() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_OFFICE_NUMBER + " FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String teachingAssistantOfficeNumberDB = null;

        if (cursor.moveToFirst()) {
            do {
                teachingAssistantOfficeNumberDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_OFFICE_NUMBER));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return teachingAssistantOfficeNumberDB;
    }

    public String getTeachingAssistantBuilding() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_BUILDING + " FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String teachingAssistantBuildingDB = null;

        if (cursor.moveToFirst()) {
            do {
                teachingAssistantBuildingDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_BUILDING));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return teachingAssistantBuildingDB;
    }

    public String getTeachingAssistantEmailAddress() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS + " FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String teachingAssistantEmailAddressDB = null;

        if (cursor.moveToFirst()) {
            do {
                teachingAssistantEmailAddressDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_EMAIL_ADDRESS));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return teachingAssistantEmailAddressDB;
    }

    public String getTeachingAssistantPhoneNumber() {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        String selectQuery = "SELECT " + sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_PHONE_NUMBER + " FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String teachingAssistantPhoneNumberDB = null;

        if (cursor.moveToFirst()) {
            do {
                teachingAssistantPhoneNumberDB = cursor.getString(cursor.getColumnIndex(sqLiteHelperTeachingAssistant.KEY_TEACHING_ASSISTANT_PHONE_NUMBER));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return teachingAssistantPhoneNumberDB;
    }


    //public int updateStudentProfile(GetterSetterTeachingAssistant GetterSetterTeachingAssistant) {
    //SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
    //}

    public void deleteTeachingAssistantProfile(GetterSetterTeachingAssistant getterSetterTeachingAssistant) {
        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        sqLiteDatabase.delete(sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE, sqLiteHelperTeachingAssistant.KEY_ID_TEACHING_ASSISTANT + " =? ",
                new String[]{String.valueOf(getterSetterTeachingAssistant.getIdTeachingAssistant())});
        sqLiteDatabase.close();
    }

    public void deleteAllTeachingAssistantProfile() {

        SQLiteDatabase sqLiteDatabase = sqLiteHelperTeachingAssistant.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + sqLiteHelperTeachingAssistant.TABLE_TEACHING_ASSISTANT_PROFILE);
        sqLiteDatabase.close();
    }
}
