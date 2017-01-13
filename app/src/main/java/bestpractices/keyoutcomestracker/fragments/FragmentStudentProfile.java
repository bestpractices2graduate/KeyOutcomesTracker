package bestpractices.keyoutcomestracker.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.activities.ActivityAddStudentProfile;


public class FragmentStudentProfile extends Fragment {

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();

        final View view = inflater.inflate(R.layout.fragment_student_profile, container, false);

        RelativeLayout fragmentStudentProfileRootView = (RelativeLayout) view.findViewById(R.id.fragmentStudentProfileRootView);
        FloatingActionButton addStudentProfileFAB = (FloatingActionButton) view.findViewById(R.id.addStudentProfileFAB);

        addStudentProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addStudentProfile = new Intent(context, ActivityAddStudentProfile.class);
                context.startActivity(addStudentProfile);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                //Snackbar.make(fragmentStudentProfileRootView, "Add new student profile", Snackbar.LENGTH_LONG).show();

            }
        });

        return view;
    }

}
