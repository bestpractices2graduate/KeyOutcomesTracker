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
import bestpractices.keyoutcomestracker.activities.ActivityAddTeachingAssistantProfile;
import bestpractices.keyoutcomestracker.adapters.teachingAssistant.AdapterTeachingAssistantProfile;
import bestpractices.keyoutcomestracker.gettersSetters.teachingAssistant.GetterSetterTeachingAssistant;
import bestpractices.keyoutcomestracker.sqlite.teachingAssistant.SQLiteHandlerTeachingAssistant;


public class FragmentTeachingAssistantProfile extends Fragment implements AdapterTeachingAssistantProfile.ViewHolder.ClickListener {

    RecyclerView recyclerView;
    AdapterTeachingAssistantProfile adapterTeachingAssistantProfile;
    List<GetterSetterTeachingAssistant> getterSetterTeachingAssistant;

    FloatingActionButton addTeachingAssistantProfileFAB;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_teaching_assistant_profile, container, false);

        SQLiteHandlerTeachingAssistant database = new SQLiteHandlerTeachingAssistant(getContext());
        getterSetterTeachingAssistant = database.getAllTeachingAssistantProfile();

        adapterTeachingAssistantProfile = new AdapterTeachingAssistantProfile(getContext(), getterSetterTeachingAssistant, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.teachingAssitantRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTeachingAssistantProfile);

        addTeachingAssistantProfileFAB = (FloatingActionButton) view.findViewById(R.id.addTeachingAssistantProfileFAB);
        addTeachingAssistantProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(), "Work!", Toast.LENGTH_LONG).show();
                Intent startAddTeachingAssistantActivity = new Intent(getContext(), ActivityAddTeachingAssistantProfile.class);
                //startAddInstructorTAActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startAddTeachingAssistantActivity);
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
