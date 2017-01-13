package bestpractices.keyoutcomestracker.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.student.AdapterStudentProfile;
import bestpractices.keyoutcomestracker.gettersSetters.student.GetterSetterStudentProfile;
import bestpractices.keyoutcomestracker.sqlite.student.SQLiteHandlerStudentProfile;

public class ActivityStudentProfile extends AppCompatActivity implements AdapterStudentProfile.ViewHolder.ClickListener {

    private AdapterStudentProfile adapterStudentProfile;
    private ActionModeCallback actionModeCallback = new ActionModeCallback();
    private ActionMode actionMode;

    List<GetterSetterStudentProfile> getterSetterStudentProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        SQLiteHandlerStudentProfile database = new SQLiteHandlerStudentProfile(ActivityStudentProfile.this);
        getterSetterStudentProfile = database.getAllStudentProfile();

        adapterStudentProfile = new AdapterStudentProfile(this, getterSetterStudentProfile, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterStudentProfile);


        FloatingActionButton addStudentProfileFAB = (FloatingActionButton) findViewById(R.id.addStudentProfileFAB);

        addStudentProfileFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addStudentProfile = new Intent(ActivityStudentProfile.this, ActivityAddStudentProfile.class);
                startActivity(addStudentProfile);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                //Snackbar.make(fragmentStudentProfileRootView, "Add new student profile", Snackbar.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onItemClicked(int position) {
        if (actionMode != null) {
            toggleSelection(position);
        }
    }

    @Override
    public boolean onItemLongClicked(int position) {
        if (actionMode == null) {
            actionMode = startSupportActionMode(actionModeCallback);
        }

        toggleSelection(position);

        return true;
    }

    private void toggleSelection(int position) {
        adapterStudentProfile.toggleSelection(position);
        int count = adapterStudentProfile.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
            //getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        } else if (count == 1) {
            //getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.darkGrayStatusBar));
            //actionMode.setTitle(String.valueOf(count) + getString(R.string.item_selected_label));
            actionMode.invalidate();
        } else {
            //getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.darkGrayStatusBar));
            //actionMode.setTitle(String.valueOf(count) + getString(R.string.items_selected_label));
            actionMode.invalidate();
        }
    }

    private class ActionModeCallback implements ActionMode.Callback {
        @SuppressWarnings("unused")
        private final String TAG = ActionModeCallback.class.getSimpleName();

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.selected_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            return false;
        }

        @Override
        public boolean onActionItemClicked(final ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
//                case R.id.menu_remove:
//
//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActivityMeetingHistory.this);
//                    alertDialog.setTitle(R.string.hold_on_there_title_label);
//                    alertDialog.setMessage(R.string.delete_meeting_history_message_text);
//                    alertDialog.setCancelable(true);
//                    alertDialog.setPositiveButton(R.string.delete_positive_button_text, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            adapterMeetingHistory.removeItems(adapterMeetingHistory.getSelectedItems());
//                            mode.finish();
//
//
//                            Snackbar.make(findViewById(R.id.root_coordinator_layout_Activity_parking_history_list), R.string.meeting_history_deleted_message_text, Snackbar.LENGTH_SHORT).show();
//                        }
//                    })
//                            .setNegativeButton(R.string.cancel_negative_button_text, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    // Do nothing, dismiss alert dialog
//                                }
//                            })
//                            .show();


                    //return true;

                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
            adapterStudentProfile.clearSelection();
            actionMode = null;
        }
    }






//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        //getMenuInflater().inflate(R.menu.over_flow_menu_parking_history, menu);
//
//        return false;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
