package bestpractices.keyoutcomestracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.courses.AdapterCourses;
import bestpractices.keyoutcomestracker.gettersSetters.courses.GetterSetterCourses;
import bestpractices.keyoutcomestracker.sqlite.courses.SQLiteHandlerCourses;

public class ActivityCourses extends AppCompatActivity implements AdapterCourses.ViewHolder.ClickListener {

    RecyclerView recyclerView;
    AdapterCourses adapterCourses;
    List<GetterSetterCourses> getterSetterCourses;

    FloatingActionButton addCoursesFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        SQLiteHandlerCourses database = new SQLiteHandlerCourses(this);
        getterSetterCourses = database.getAllCourses();

        adapterCourses = new AdapterCourses(this, getterSetterCourses, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.coursesRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterCourses);

        addCoursesFAB = (FloatingActionButton) findViewById(R.id.addCoursesFAB);

        addCoursesFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddCoursesActivity = new Intent(ActivityCourses.this, ActivityAddCourses.class);
                startActivity(startAddCoursesActivity);
            }
        });
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public boolean onItemLongClicked(int position) {
        return false;
    }
}
