package bestpractices.keyoutcomestracker.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.fragments.FragmentAbout;
import bestpractices.keyoutcomestracker.fragments.FragmentAdditionalResources;
import bestpractices.keyoutcomestracker.fragments.FragmentDashBoardStats;
import bestpractices.keyoutcomestracker.fragments.FragmentStudySessions;
import bestpractices.keyoutcomestracker.fragments.FragmentTrackKeyOutcomes;

public class ActivityMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FloatingActionButton addProfileFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Key Outcomes Tracker");
        }

//        addProfileFAB = (FloatingActionButton) findViewById(R.id.addProfileFAB);
//        addProfileFAB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent addProfileIntent = new Intent(ActivityMain.this, ActivityAddStudentProfile.class);
//                startActivity(addProfileIntent);
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true); // Home
        navigationView.getMenu().getItem(1).setChecked(false); // Student Profile
        navigationView.getMenu().getItem(2).setChecked(false); // Instructor Profile
        navigationView.getMenu().getItem(3).setChecked(false); // Classes and Study Sessions
        navigationView.getMenu().getItem(4).setChecked(false); // Class Activities
        navigationView.getMenu().getItem(5).setChecked(false); // Track Key Outcomes
        navigationView.getMenu().getItem(6).setChecked(false); // Additional Resources
        navigationView.getMenu().getItem(7).setChecked(false); // Contact Developer
        navigationView.getMenu().getItem(8).setChecked(false); // Rate This App
        navigationView.getMenu().getItem(9).setChecked(false); // Share
        navigationView.getMenu().getItem(10).setChecked(false); // Settings
        navigationView.getMenu().getItem(11).setChecked(false); // About

        fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentTransaction = fragmentManager.beginTransaction();
        FragmentDashBoardStats fragmentDashBoardStats = new FragmentDashBoardStats();
        fragmentTransaction.replace(R.id.fragment_container, fragmentDashBoardStats);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            // Home
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Key Outcomes Tracker") {
                    super.onBackPressed();
                }
            }

            // Student Profile
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Student Profile") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(1).setChecked(false); // Student Profile
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }

            // Instructor Profile
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Instructor Profile") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(2).setChecked(false); // Instructor Profile
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }

            // Classes and Study Sessions
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Study Sessions") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(3).setChecked(false); // Classes and Study Sessions
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }

            // Class Activities
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Class Activities") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(4).setChecked(false); // Class Activities
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }

            // Track Key Outcomes
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Track Key Outcomes") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(5).setChecked(false); // Track Key Outcomes
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }

            // Additional Resources
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "Additional Resources") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(6).setChecked(false); // Additional Resources
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }

            // About
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "About") {
                    super.onBackPressed();
                    getSupportActionBar().setTitle("Key Outcomes Tracker");
                    navigationView.getMenu().getItem(0).setChecked(true); // Home
                    navigationView.getMenu().getItem(11).setChecked(false); // About
                    //navigationView.getMenu().getItem(2).setChecked(false); // Parking History
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.over_flow_menu_activity_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            item.setChecked(true);
            if (getSupportActionBar() != null) {
                if (getSupportActionBar().getTitle() == "About") {
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                        getSupportActionBar().setTitle("Key Outcomes Tracker");
                        super.onBackPressed();
                    }
                }

                if (getSupportActionBar().getTitle() == "Additional Resources") {
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                        getSupportActionBar().setTitle("Key Outcomes Tracker");
                        super.onBackPressed();
                    }
                }

                if (getSupportActionBar().getTitle() == "Track Key Outcomes") {
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                        getSupportActionBar().setTitle("Key Outcomes Tracker");
                        super.onBackPressed();
                    }
                }

                if (getSupportActionBar().getTitle() == "Study Sessions") {
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                        getSupportActionBar().setTitle("Key Outcomes Tracker");
                        super.onBackPressed();
                    }
                }
            }
        } else if (id == R.id.student_profile) {
            navigationView.getMenu().getItem(0).setChecked(true); // Home
            if (getSupportActionBar() != null) {
                //getSupportActionBar().setTitle("Student Profile");
            }

//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            fragmentTransaction = fragmentManager.beginTransaction();
//            FragmentStudentProfile fragmentStudentProfile = new FragmentStudentProfile();
//            fragmentTransaction.replace(R.id.fragment_container, fragmentStudentProfile);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();

            //Intent studentProfileIntent = new Intent(this, ActivityStudentProfile.class);
            //startActivity(studentProfileIntent);

            Intent studentProfileIntent = new Intent(this, ActivityMyProfile.class);
            startActivity(studentProfileIntent);

        } else if (id == R.id.instructor_profile) {
            navigationView.getMenu().getItem(0).setChecked(true); // Home
            if (getSupportActionBar() != null) {
                //getSupportActionBar().setTitle("Instructor Profile");
            }

//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            fragmentTransaction = fragmentManager.beginTransaction();
//            FragmentInstructorProfile fragmentInstructorProfile = new FragmentInstructorProfile();
//            fragmentTransaction.replace(R.id.fragment_container, fragmentInstructorProfile);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();

            Intent intent = new Intent(this, ActivityInstructorTAProfile.class);
            startActivity(intent);


        } else if (id == R.id.study_sessions) {
            navigationView.getMenu().getItem(0).setChecked(false); // Home
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Study Sessions");
            }

            fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentStudySessions fragmentStudySessions = new FragmentStudySessions();
            fragmentTransaction.replace(R.id.fragment_container, fragmentStudySessions);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (id == R.id.courses) {
            navigationView.getMenu().getItem(0).setChecked(true); // Home
            if (getSupportActionBar() != null) {
                //getSupportActionBar().setTitle("Class Activities");
            }

//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            fragmentTransaction = fragmentManager.beginTransaction();
//            FragmentClassActivities fragmentClassActivities = new FragmentClassActivities();
//            fragmentTransaction.replace(R.id.fragment_container, fragmentClassActivities);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();

            Intent intent = new Intent(ActivityMain.this, ActivityCourses.class);
            startActivity(intent);

        } else if (id == R.id.track_key_outcomes) {
            navigationView.getMenu().getItem(0).setChecked(false); // Home
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Track Key Outcomes");
            }

            fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentTrackKeyOutcomes fragmentTrackKeyOutcomes = new FragmentTrackKeyOutcomes();
            fragmentTransaction.replace(R.id.fragment_container, fragmentTrackKeyOutcomes);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.additional_resources) {
            navigationView.getMenu().getItem(0).setChecked(false); // Home
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Additional Resources");
            }

            fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentAdditionalResources fragmentAdditionalResources = new FragmentAdditionalResources();
            fragmentTransaction.replace(R.id.fragment_container, fragmentAdditionalResources);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            //openPDF();

            //Toast.makeText(this, "Open PDF", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.contact_us) {

            Intent contactUsIntent = new Intent(Intent.ACTION_SEND);
            contactUsIntent.setData(Uri.parse("mailto:"));
            contactUsIntent.setType("text/plain");
            contactUsIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"barrykjf@gmail.com"});
            contactUsIntent.putExtra(Intent.EXTRA_SUBJECT, "Key Outcomes Tracker");
            startActivity(contactUsIntent);

        } else if (id == R.id.rate_this_app) {

            //Intent rateThisAppIntent = new Intent(Intent.ACTION_VIEW);
            //rateThisAppIntent.setData(Uri.parse("market://details?id=bestpractices.keyoutcomestracker"));
            //startActivity(rateThisAppIntent);

            Toast.makeText(this, "Sorry my friend, this app is not yet published to the Google Play Store and thus you cannot rate it.", Toast.LENGTH_LONG).show();

        } else if (id == R.id.share_app) {

            Intent shartAppIntent = new Intent();
            shartAppIntent.setAction(Intent.ACTION_SEND);
            shartAppIntent.putExtra(Intent.EXTRA_TEXT, "Key Outcomes Tracker\n\nhttps://play.google.com/store/apps/details?id=bestpractices.keyoutcomestracker");
            shartAppIntent.setType("text/plain");
            startActivity(Intent.createChooser(shartAppIntent, getResources().getText(R.string.send_to)));

            Toast.makeText(this, "Again, sorry my friend, this app is not yet published to the Google Play Store and thus you cannot share it.", Toast.LENGTH_LONG).show();

        } else if (id == R.id.settings) {
            Toast.makeText(this, "No settings just yet!", Toast.LENGTH_LONG).show();


        } else if (id == R.id.about_app) {

            item.setChecked(true);
            navigationView.getMenu().getItem(0).setChecked(false); // Home

            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("About");
            }

            fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentAbout fragmentAbout = new FragmentAbout();
            fragmentTransaction.replace(R.id.fragment_container, fragmentAbout);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openPDF() {

        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "succeeding_in_college.pdf");
        try {
            in = assetManager.open("succeeding_in_college.pdf");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

        //C:\Users\Administrator\Desktop\KeyOutcomesTracker\app\src\main\assets\succeeding_in_collegege.pdf

        //File file = new File("file:///android_asset/succeeding_in_college.pdf");
        //Uri pathUri = Uri.parse("file:///android/succeeding_in_college.pdfdf");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/succeeding_in_college.pdf"), "application/pdf");
        //intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        //intent.setDataAndType(pathUri, "application/pdf");
        //intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent createChooser = Intent.createChooser(intent, "Open File");
        try {
            startActivity(createChooser);
        } catch (Exception e) {
            Toast.makeText(this, "No activity found!", Toast.LENGTH_LONG).show();
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {

        //System.out.println("Copying");
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
