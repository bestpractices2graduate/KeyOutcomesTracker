package bestpractices.keyoutcomestracker.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.PagerAdapterTabLayout;
import bestpractices.keyoutcomestracker.adapters.instructor.AdapterInstructorProfile;
import bestpractices.keyoutcomestracker.gettersSetters.instructor.GetterSetterInstructor;

public class ActivityInstructorTAProfile extends AppCompatActivity implements AdapterInstructorProfile.ViewHolder.ClickListener {

    RecyclerView recyclerView;
    AdapterInstructorProfile adapterInstructorProfile;
    List<GetterSetterInstructor> getterSetterInstructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_taprofile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

//        SQLiteHandlerInstructor database = new SQLiteHandlerInstructor(ActivityInstructorTAProfile.this);
//        getterSetterInstructor = database.getAllInstructorProfile();
//
//        adapterInstructorProfile = new AdapterInstructorProfile(this, getterSetterInstructor, this);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.instructorTARecyclerView);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapterInstructorProfile);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            tabLayout.addTab(tabLayout.newTab().setText("Instructors"));
            //tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_car_white_24dp));
        }

        if (tabLayout != null) {
            tabLayout.addTab(tabLayout.newTab().setText("Teaching Assistants"));
            //tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_parking_pin_white_24dp));
        }

        if (tabLayout != null) {
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapterTabLayout adapter = null;
        if (tabLayout != null) {
            adapter = new PagerAdapterTabLayout(getSupportFragmentManager(), tabLayout.getTabCount());
        }

        if (viewPager != null) {
            viewPager.setAdapter(adapter);
        }

        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }

        if (tabLayout != null) {
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    if (viewPager != null) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }


    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public boolean onItemLongClicked(int position) {
        return false;
    }
}
