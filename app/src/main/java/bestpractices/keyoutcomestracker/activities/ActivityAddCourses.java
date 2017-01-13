package bestpractices.keyoutcomestracker.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.courses.AdapterCourses;
import bestpractices.keyoutcomestracker.gettersSetters.courses.GetterSetterCourses;
import bestpractices.keyoutcomestracker.sqlite.courses.SQLiteHandlerCourses;

public class ActivityAddCourses extends AppCompatActivity {

    FloatingActionButton saveCourseInformationFAB;
    Button semesterStartDateButton;
    Button semesterEndDateButton;
    Button lectureStartTimeButton;
    Button lectureEndTimeButton;
    EditText semesterStartDateEditText;
    EditText semesterEndDateEditText;
    EditText selectLectureStartTimeEditText;
    EditText selectLectureEndTimeEditText;

    EditText courseNumber;
    EditText courseName;
    EditText courseDescription;
    EditText courseRoomNumber;
    EditText courseInstructor;
    EditText courseTeachingAssistant;
    EditText courseSemesterStartDate;
    EditText courseSemesterEndDate;
    EditText courseDays;
    EditText courseLectureStartTime;
    EditText courseLectureEndTime;


    DateFormat dateFormat = DateFormat.getDateInstance();
    Calendar dateTime = Calendar.getInstance();


    SimpleDateFormat simpleDateFormat;

    SQLiteHandlerCourses sqLiteHandlerCourses;

    List<GetterSetterCourses> getterSetterCourses;

    AdapterCourses adapterCourses;

    String semStartDate;
    String semEndDate;
    String lecStarTime;
    String lecEndTime;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("h:mm a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);

        sqLiteHandlerCourses = new SQLiteHandlerCourses(this);

        getterSetterCourses = sqLiteHandlerCourses.getAllCourses();

        adapterCourses = new AdapterCourses(this, getterSetterCourses, null);

        courseNumber = (EditText) findViewById(R.id.courseIDEditText);
        courseName = (EditText) findViewById(R.id.courseNameEditText);
        courseDescription = (EditText) findViewById(R.id.courseDescriptionEditText);
        courseRoomNumber = (EditText) findViewById(R.id.courseRoomNumberEditText);
        courseInstructor = (EditText) findViewById(R.id.courseInstructorEmailEditText);
        courseTeachingAssistant = (EditText) findViewById(R.id.courseTAEditText);
        courseSemesterStartDate = (EditText) findViewById(R.id.semesterStartDateEditText);
        courseSemesterEndDate = (EditText) findViewById(R.id.semesterEndDateEditText);
        courseDays = (EditText) findViewById(R.id.selectClassDaysEditText);
        courseLectureStartTime = (EditText) findViewById(R.id.selectLectureStartTimeEditText);
        courseLectureEndTime = (EditText) findViewById(R.id.selectLectureEndTimeEditText);

        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        saveCourseInformationFAB = (FloatingActionButton) findViewById(R.id.saveCourseInformationFAB);
        semesterStartDateButton = (Button) findViewById(R.id.semesterStartDateButton);
        semesterEndDateButton = (Button) findViewById(R.id.semesterEndDateButton);
        lectureStartTimeButton = (Button) findViewById(R.id.lectureStartTimeButton);
        lectureEndTimeButton = (Button) findViewById(R.id.lectureEndTimeButton);

        saveCourseInformationFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String courseNumberString = courseNumber.getText().toString();
                final String courseNameString = courseName.getText().toString();
                final String courseDescriptionString = courseDescription.getText().toString();
                final String courseRoomNumberString = courseRoomNumber.getText().toString();
                final String courseInstructorString = courseInstructor.getText().toString();
                final String courseTeachingAssistantString = courseTeachingAssistant.getText().toString();
                final String courseSemesterStartDateString = courseSemesterStartDate.getText().toString();
                final String courseSemesterEndDateString = courseSemesterEndDate.getText().toString();
                final String courseDaysString = courseDays.getText().toString();
                final String courseLectureStartTimeString = courseLectureStartTime.getText().toString();
                final String courseLectureEndTimeString = courseLectureEndTime.getText().toString();

                //Toast.makeText(ActivityAddCourses.this, courseNumberString, Toast.LENGTH_LONG).show();

                int _id = sqLiteHandlerCourses.addCourses(new GetterSetterCourses(courseNumberString,
                        courseNameString,
                        courseDescriptionString,
                        courseRoomNumberString,
                        courseInstructorString,
                        courseTeachingAssistantString,
                        courseSemesterStartDateString,
                        courseSemesterEndDateString,
                        courseDaysString,
                        courseLectureStartTimeString,
                        courseLectureEndTimeString));

                getterSetterCourses.add(new GetterSetterCourses(_id,
                        courseNumberString,
                        courseNumberString,
                        courseDescriptionString,
                        courseRoomNumberString,
                        courseInstructorString,
                        courseTeachingAssistantString,
                        courseSemesterStartDateString,
                        courseSemesterEndDateString,
                        courseDaysString,
                        courseLectureStartTimeString,
                        courseLectureEndTimeString
                ));


                Intent startActivityMain = new Intent(ActivityAddCourses.this, ActivityMain.class);
                startActivityMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startActivityMain);
                //Toast.makeText(ActivityAddCourses.this, "All stuff was saved. You're good to go!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        semesterStartDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStartDate();
            }
        });

        semesterEndDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEndDate();
            }
        });

        lectureStartTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStartTime();
            }
        });

        lectureEndTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEndTime();
            }
        });

    }

    public void updateStartDate() {
        new DatePickerDialog(this, startDate, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void updateEndDate() {
        new DatePickerDialog(this, endDate, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void updateStartTime() {
        new TimePickerDialog(this, startTime, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show();
    }

    public void updateEndTime() {
        new TimePickerDialog(this, endTime, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show();
    }

    DatePickerDialog.OnDateSetListener startDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, monthOfYear);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            courseSemesterStartDate.setText(simpleDateFormat.format(dateTime.getTime()));

        }
    };

    DatePickerDialog.OnDateSetListener endDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, monthOfYear);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            courseSemesterEndDate.setText(simpleDateFormat.format(dateTime.getTime()));
        }
    };

    TimePickerDialog.OnTimeSetListener startTime = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            courseLectureStartTime.setText(DATE_FORMAT.format(dateTime.getTime()));
        }
    };

    TimePickerDialog.OnTimeSetListener endTime = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            courseLectureEndTime.setText(DATE_FORMAT.format(dateTime.getTime()));
        }
    };

}
