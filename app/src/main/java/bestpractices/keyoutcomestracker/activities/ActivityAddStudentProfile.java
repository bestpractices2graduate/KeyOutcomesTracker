package bestpractices.keyoutcomestracker.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.student.AdapterStudentProfile;
import bestpractices.keyoutcomestracker.gettersSetters.student.GetterSetterStudentProfile;
import bestpractices.keyoutcomestracker.sqlite.student.SQLiteHandlerStudentProfile;

public class ActivityAddStudentProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private SQLiteHandlerStudentProfile sqLiteHandlerStudentProfile;
    private List<GetterSetterStudentProfile> getterSetterStudentProfile;
    EditText firstName;
    EditText lastName;
    EditText studentID;
    EditText semester;
    EditText numberOfClasses;
    EditText schoolName;
    Spinner semesterSpinner;
    Spinner numberOfClassesSpinner;
    ArrayAdapter<String> arraySemesterSpinnerAdapter;
    ArrayAdapter<String> arrayNumberOfClassesAdapter;

    String semesterString;
    String numberOfClassesString;

    String semesterSpinnerOptionChosen;
    String[] semesterSpinnerOptions = {
            "Select Semester",
            "Spring 2017",
            "Summer 2017",
            "Fall 2017",
            "Spring 2018",
            "Summer 2018",
            "Fall 2018",
            "Spring 2019",
            "Summer 2019",
            "Fall 2019",
            "Spring 2010",
            "Summer 2020",
            "Fall 2020",
            "Spring 2021"
    };

    String numberOfClassesOptionsChosen;
    String[] numberOfClassesOptions = {
            "Select number of classes",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
    };

    AdapterStudentProfile adapterStudentProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_profile);

        sqLiteHandlerStudentProfile = new SQLiteHandlerStudentProfile(this);
        getterSetterStudentProfile = sqLiteHandlerStudentProfile.getAllStudentProfile();
        adapterStudentProfile = new AdapterStudentProfile(getApplicationContext(), getterSetterStudentProfile, null);

        FloatingActionButton saveStudentProfileFAB = (FloatingActionButton) findViewById(R.id.saveStudentProfileFAB);
        ImageButton takeProfilePicture = (ImageButton) findViewById(R.id.takeProfilePicture);

        firstName = (EditText) findViewById(R.id.firstNameEditText);
        lastName = (EditText) findViewById(R.id.lastNameEditText);
        studentID = (EditText) findViewById(R.id.studentIDEditText);
        //semester = (EditText) findViewById(R.id.semesterEditText);
        //numberOfClasses = (EditText) findViewById(R.id.numberOfClassesEditText);
        schoolName = (EditText) findViewById(R.id.schoolNameEditText);

        semesterSpinner = (Spinner) findViewById(R.id.semesterSpinnerOptions);
        numberOfClassesSpinner = (Spinner) findViewById(R.id.numberOfClassesSpinner);

        semesterSpinner.setOnItemSelectedListener(ActivityAddStudentProfile.this);
        numberOfClassesSpinner.setOnItemSelectedListener(this);

        arraySemesterSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesterSpinnerOptions);
        arraySemesterSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(arraySemesterSpinnerAdapter);

        arrayNumberOfClassesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numberOfClassesOptions);
        arrayNumberOfClassesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfClassesSpinner.setAdapter(arrayNumberOfClassesAdapter);


        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                semesterString = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        numberOfClassesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numberOfClassesString = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        saveStudentProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String firstNameString = firstName.getText().toString();
                final String lastNameString = lastName.getText().toString();
                final String studentIDString = studentID.getText().toString();
                //final String semesterString = "Summer 2016";
                final String schoolNameString = schoolName.getText().toString();

                AlertDialog.Builder createStudentProfileDialog = new AlertDialog.Builder(ActivityAddStudentProfile.this);
                createStudentProfileDialog.setTitle("Hold on there!");
                createStudentProfileDialog.setMessage("Is everything correctly entered?");
                //saveMeetingInfoDialog.setView(meetingDescriptionEntry);
                createStudentProfileDialog.setCancelable(false);

                createStudentProfileDialog.setPositiveButton("Create", new DialogInterface.OnClickListener() {

//                    String firstNameString = firstName.getText().toString();
//                    String lastNameString = lastName.getText().toString();
//                    String studentIDString = studentID.getText().toString();
//                    String semesterString = semester.getText().toString();
//                    String numberOfClassesString = numberOfClasses.getText().toString();
//                    String schoolNameString = schoolName.getText().toString();


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int _id = sqLiteHandlerStudentProfile.addStudentProfile(new GetterSetterStudentProfile(firstNameString,
                                lastNameString,
                                studentIDString,
                                semesterString,
                                numberOfClassesString,
                                schoolNameString));

                        getterSetterStudentProfile.add(new GetterSetterStudentProfile(_id, firstNameString,
                                lastNameString,
                                studentIDString,
                                semesterString,
                                numberOfClassesString,
                                schoolNameString));
                        adapterStudentProfile.notifyDataSetChanged();

                        Intent intent = new Intent(ActivityAddStudentProfile.this, ActivityMain.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        //overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                        finish();
                    }
                });

                createStudentProfileDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                createStudentProfileDialog.show();


            }
        });

        takeProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityAddStudentProfile.this, "Cheese!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {

        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.over_flow_menu_parking_history, menu);

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
