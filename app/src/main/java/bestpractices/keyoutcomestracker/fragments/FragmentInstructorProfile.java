package bestpractices.keyoutcomestracker.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.activities.ActivityAddInstructorProfile;
import bestpractices.keyoutcomestracker.adapters.instructor.AdapterInstructorProfile;
import bestpractices.keyoutcomestracker.gettersSetters.instructor.GetterSetterInstructor;
import bestpractices.keyoutcomestracker.sqlite.instructor.SQLiteHandlerInstructor;


public class FragmentInstructorProfile extends Fragment implements AdapterInstructorProfile.ViewHolder.ClickListener {

    RecyclerView recyclerView;
    AdapterInstructorProfile adapterInstructorProfile;
    List<GetterSetterInstructor> getterSetterInstructor;

    FloatingActionButton addInstructorProfileFAB;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_instructor_profile, container, false);

        SQLiteHandlerInstructor database = new SQLiteHandlerInstructor(getContext());
        getterSetterInstructor = database.getAllInstructorProfile();

        adapterInstructorProfile = new AdapterInstructorProfile(getContext(), getterSetterInstructor, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.instructorTARecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterInstructorProfile);

        addInstructorProfileFAB = (FloatingActionButton) view.findViewById(R.id.addInstructorProfileFAB);
        addInstructorProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(), "Work!", Toast.LENGTH_LONG).show();
                Intent startAddInstructorTAActivity = new Intent(getContext(), ActivityAddInstructorProfile.class);
                //startAddInstructorTAActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startAddInstructorTAActivity);
            }
        });

        return view;
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public boolean onItemLongClicked(int position) {
        return false;
    }
}
