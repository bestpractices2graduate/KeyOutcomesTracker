package bestpractices.keyoutcomestracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.instructor.AdapterInstructorProfile;
import bestpractices.keyoutcomestracker.gettersSetters.instructor.GetterSetterInstructor;
import bestpractices.keyoutcomestracker.sqlite.instructor.SQLiteHandlerInstructor;

public class ActivityAddInstructorProfile extends AppCompatActivity {

    SQLiteHandlerInstructor sqLiteHandlerInstructor;

    List<GetterSetterInstructor> getterSetterInstructor;

    FloatingActionButton saveInstructorProfileFAB;

    EditText instructorFirstName;
    EditText instructorLastName;
    EditText instructorOfficeNumber;
    EditText instructorBuildingNumber;
    EditText instructorEmail;
    EditText instructorPhone;

    AdapterInstructorProfile adapterInstructorProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_instructor_profile);

        sqLiteHandlerInstructor = new SQLiteHandlerInstructor(this);

        getterSetterInstructor = sqLiteHandlerInstructor.getAllInstructorProfile();

        adapterInstructorProfile = new AdapterInstructorProfile(getApplicationContext(), getterSetterInstructor, null);

        instructorFirstName = (EditText) findViewById(R.id.instructorFirstNameEditText);
        instructorLastName = (EditText) findViewById(R.id.instructorLastNameEditText);
        instructorOfficeNumber = (EditText) findViewById(R.id.instructorOfficeNumberEditText);
        instructorBuildingNumber = (EditText) findViewById(R.id.instructorBuildingEditText);
        instructorEmail = (EditText) findViewById(R.id.instructorEmailEditText);
        instructorPhone = (EditText) findViewById(R.id.instructorPhoneEditText);

        saveInstructorProfileFAB = (FloatingActionButton) findViewById(R.id.saveInstructorProfileFAB);

        saveInstructorProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String instructorFirstNameString = instructorFirstName.getText().toString();
                final String instructorLastNameString = instructorLastName.getText().toString();
                final String instructorOfficeNumberString = instructorOfficeNumber.getText().toString();
                final String instructorBuildingNumberString = instructorBuildingNumber.getText().toString();
                final String instructorEmailString = instructorEmail.getText().toString();
                final String instructorPhoneString = instructorPhone.getText().toString();

                int _id = sqLiteHandlerInstructor.addInstructorProfile(new GetterSetterInstructor(instructorFirstNameString,
                        instructorLastNameString,
                        instructorOfficeNumberString,
                        instructorBuildingNumberString,
                        instructorEmailString,
                        instructorPhoneString));

                getterSetterInstructor.add(new GetterSetterInstructor(_id,
                        instructorFirstNameString,
                        instructorLastNameString,
                        instructorOfficeNumberString,
                        instructorBuildingNumberString,
                        instructorEmailString,
                        instructorPhoneString));

                Intent startAddCourseActivity = new Intent(ActivityAddInstructorProfile.this, ActivityMain.class);
                startAddCourseActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startAddCourseActivity);
                finish();
            }
        });
    }
}
