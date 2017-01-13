package bestpractices.keyoutcomestracker.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bestpractices.keyoutcomestracker.R;

public class FragmentAbout extends Fragment {

    private static final String TAG = "FragmentParkingHistoryList";

    TextView appVersion;
    TextView androidVersion;
    TextView deviceModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        final View view = inflater.inflate(R.layout.fragment_about, container, false);

        deviceModel = (TextView) view.findViewById(R.id.deviceModel);
        androidVersion = (TextView) view.findViewById(R.id.androidVersion);
        appVersion = (TextView) view.findViewById(R.id.appVersion);


        deviceModel.setText("Device: " + Build.MANUFACTURER + " " + Build.MODEL);
        androidVersion.setText("Android Version: " + Build.VERSION.RELEASE);

        return view;
    }
}
