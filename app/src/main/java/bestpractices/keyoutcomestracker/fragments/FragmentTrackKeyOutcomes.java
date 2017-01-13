package bestpractices.keyoutcomestracker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bestpractices.keyoutcomestracker.R;

public class FragmentTrackKeyOutcomes extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);


        return inflater.inflate(R.layout.fragment_track_key_outcomes, container, false);
    }
}
