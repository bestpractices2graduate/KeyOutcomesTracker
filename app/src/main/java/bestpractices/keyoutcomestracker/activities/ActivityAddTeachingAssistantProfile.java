package bestpractices.keyoutcomestracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.teachingAssistant.AdapterTeachingAssistantProfile;
import bestpractices.keyoutcomestracker.gettersSetters.teachingAssistant.GetterSetterTeachingAssistant;
import bestpractices.keyoutcomestracker.sqlite.teachingAssistant.SQLiteHandlerTeachingAssistant;

public class ActivityAddTeachingAssistantProfile extends AppCompatActivity {

    SQLiteHandlerTeachingAssistant sqLiteHandlerTeachingAssistant;

    List<GetterSetterTeachingAssistant> getterSetterTeachingAssistant;

    FloatingActionButton saveTeachingAssistantProfileFAB;

    EditText teachingAssistantFirstName;
    EditText teachingAssistantLastName;
    EditText teachingAssistantOfficeNumber;
    EditText teachingAssistantBuildingNumber;
    EditText teachingAssistantEmail;
    EditText teachingAssistantPhone;

    AdapterTeachingAssistantProfile adapterTeachingAssistantProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teaching_assistant_profile);

        sqLiteHandlerTeachingAssistant = new SQLiteHandlerTeachingAssistant(this);

        getterSetterTeachingAssistant = sqLiteHandlerTeachingAssistant.getAllTeachingAssistantProfile();

        adapterTeachingAssistantProfile = new AdapterTeachingAssistantProfile(getApplicationContext(), getterSetterTeachingAssistant, null);

        teachingAssistantFirstName = (EditText) findViewById(R.id.teachingAssistantFirstNameEditText);
        teachingAssistantLastName = (EditText) findViewById(R.id.teachingAssistantLastNameEditText);
        teachingAssistantOfficeNumber = (EditText) findViewById(R.id.teachingAssistantOfficeNumberEditText);
        teachingAssistantBuildingNumber = (EditText) findViewById(R.id.teachingAssistantBuildingEditText);
        teachingAssistantEmail = (EditText) findViewById(R.id.teachingAssistantEmailEditText);
        teachingAssistantPhone = (EditText) findViewById(R.id.teachingAssistantPhoneEditText);

        saveTeachingAssistantProfileFAB = (FloatingActionButton) findViewById(R.id.saveTeachingAssistantProfileFAB);

        saveTeachingAssistantProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String teachingAssistantFirstNameString = teachingAssistantFirstName.getText().toString();
                final String teachingAssistantLastNameString = teachingAssistantLastName.getText().toString();
                final String teachingAssistantOfficeNumberString = teachingAssistantOfficeNumber.getText().toString();
                final String teachingAssistantBuildingNumberString = teachingAssistantBuildingNumber.getText().toString();
                final String teachingAssistantEmailString = teachingAssistantEmail.getText().toString();
                final String teachingAssistantPhoneString = teachingAssistantPhone.getText().toString();

                int id_teaching_assistant = sqLiteHandlerTeachingAssistant.addTeachingAssistantProfile(new GetterSetterTeachingAssistant(teachingAssistantFirstNameString,
                        teachingAssistantLastNameString,
                        teachingAssistantOfficeNumberString,
                        teachingAssistantBuildingNumberString,
                        teachingAssistantEmailString,
                        teachingAssistantPhoneString));

                getterSetterTeachingAssistant.add(new GetterSetterTeachingAssistant(id_teaching_assistant,
                        teachingAssistantFirstNameString,
                        teachingAssistantLastNameString,
                        teachingAssistantOfficeNumberString,
                        teachingAssistantBuildingNumberString,
                        teachingAssistantEmailString,
                        teachingAssistantPhoneString));

                Intent startAddCourseActivity = new Intent(ActivityAddTeachingAssistantProfile.this, ActivityMain.class);
                startAddCourseActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startAddCourseActivity);
                finish();
            }
        });
    }
}
