package bestpractices.keyoutcomestracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.sqlite.student.SQLiteHandlerStudentProfile;

public class ActivityMyProfile extends AppCompatActivity {

    private FloatingActionButton addStudentProfileFAB;
    private FloatingActionButton editStudentProfileFAB;
    ActionBar actionBar;

    SQLiteHandlerStudentProfile database = new SQLiteHandlerStudentProfile(ActivityMyProfile.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_tester);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("My Profile");
        }



        addStudentProfileFAB = (FloatingActionButton) findViewById(R.id.addStudentProfileFAB);
        editStudentProfileFAB = (FloatingActionButton) findViewById(R.id.editStudentProfileFAB);
        TextView firstNameTV = (TextView) findViewById(R.id.first_name_text_view);
        TextView lastNameTV = (TextView) findViewById(R.id.last_name_text_view);
        TextView studentIDTV = (TextView) findViewById(R.id.student_id_text_view);
        TextView semesterTV = (TextView) findViewById(R.id.semester_text_view);
        TextView numberOfClassesTV = (TextView) findViewById(R.id.number_of_classes_text_view);
        TextView schoolNameTV = (TextView) findViewById(R.id.school_name_text_view);

        editStudentProfileFAB.hide();

        addStudentProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addStudentProfile = new Intent(ActivityMyProfile.this, ActivityAddStudentProfile.class);
                startActivity(addStudentProfile);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                //Snackbar.make(fragmentStudentProfileRootView, "Add new student profile", Snackbar.LENGTH_LONG).show();
            }
        });

        editStudentProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityMyProfile.this, "Hold on there partner, no account editing yet! ;)", Toast.LENGTH_LONG).show();
            }
        });

        try {
            String firstName = database.getStudentFirstName();
            String lastName = database.getStudentLastName();
            String studentID = database.getStudentSchoolID();
            String semester = database.getStudentSemester();
            String numberOfClasses = database.getStudentNumberOfClasses();
            String schoolName = database.getStudentSchoolName();

//        firstNameTV.setText(firstName);
            //      lastNameTV.setText(lastName);
            studentIDTV.setText(studentID);
            semesterTV.setText(semester);
            numberOfClassesTV.setText(numberOfClasses);
            schoolNameTV.setText(schoolName);

            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle(firstName + " " + lastName);
            }

            //Toast.makeText(this, firstName, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!studentIDTV.getText().equals("") &&
                !semesterTV.getText().equals("") &&
                !numberOfClassesTV.getText().equals("") &&
                !schoolNameTV.getText().equals("")) {
            //addStudentProfileFAB.hide();
            //editStudentProfileFAB.show();

        } else {
            //addStudentProfileFAB.show();
            //editStudentProfileFAB.hide();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        //overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.over_flow_menu_my_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            finish();
            //overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);

            return true;
        }

        if (id == R.id.action_delete) {
            SQLiteHandlerStudentProfile db = new SQLiteHandlerStudentProfile(getApplicationContext());
            db.deleteAllStudentProfile();
            //Toast.makeText(ActivityMyProfile.this, "Deleted", Toast.LENGTH_SHORT).show();
            addStudentProfileFAB.show();
            editStudentProfileFAB.hide();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("My Profile");

                Intent startAddCourseActivity = new Intent(ActivityMyProfile.this, ActivityMain.class);
                startAddCourseActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startAddCourseActivity);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
