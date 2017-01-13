package bestpractices.keyoutcomestracker.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bestpractices.keyoutcomestracker.fragments.FragmentInstructorProfile;
import bestpractices.keyoutcomestracker.fragments.FragmentTeachingAssistantProfile;

public class PagerAdapterTabLayout extends FragmentStatePagerAdapter {
    private final int numberOfTabs;

    public PagerAdapterTabLayout(FragmentManager fragmentManager, int numberOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentInstructorProfile();
            case 1:
                return new FragmentTeachingAssistantProfile();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}