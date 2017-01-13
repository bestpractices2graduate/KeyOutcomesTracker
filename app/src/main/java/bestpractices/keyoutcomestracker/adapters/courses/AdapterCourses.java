package bestpractices.keyoutcomestracker.adapters.courses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bestpractices.keyoutcomestracker.R;
import bestpractices.keyoutcomestracker.adapters.AdapterSelectable;
import bestpractices.keyoutcomestracker.gettersSetters.courses.GetterSetterCourses;
import bestpractices.keyoutcomestracker.sqlite.courses.SQLiteHandlerCourses;

public class AdapterCourses extends AdapterSelectable<AdapterCourses.ViewHolder> {

    private static final int TYPE_INACTIVE = 0;
    private static final int TYPE_ACTIVE = 1;

    private static List<GetterSetterCourses> getterSetterCourses = new ArrayList<>();
    private static Context context;
    GetterSetterCourses getterSetterCoursesList;

    private AdapterCourses.ViewHolder.ClickListener clickListener;

    public AdapterCourses(Context context, List<GetterSetterCourses> getterSetterCourses,
                          AdapterCourses.ViewHolder.ClickListener clickListener) {
        super();
        this.context = context;
        this.getterSetterCourses = getterSetterCourses;
        this.clickListener = clickListener;
    }

    // Removing a single item from the recyclerview
    private void removeItem(int position) {
        getterSetterCoursesList = getterSetterCourses.get(position);
        SQLiteHandlerCourses db = new SQLiteHandlerCourses(context);
        db.deleteCourse(getterSetterCoursesList);
        getterSetterCourses.remove(position);
        notifyItemRemoved(position);
    }

    public void removeItems(List<Integer> positions) {
        //Reverse-sort the list
        Collections.sort(positions, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return rhs - lhs;
            }
        });

        // Split the list in ranges
        while (!positions.isEmpty()) {
            if (positions.size() == 1) {
                removeItem(positions.get(0));
                positions.remove(0);
            } else {
                int count = 1;
                while (positions.size() > count && positions.get(count).equals(positions.get(count - 1) - 1)) {
                    ++count;
                }

                if (count == 1) {
                    removeItem(positions.get(0));
                } else {
                    removeRange(positions.get(count - 1), count);
                }

                for (int i = 0; i < count; ++i) {
                    positions.remove(0);
                }
            }
        }
    }

    private void removeRange(int positionStart, int itemCount) {
        for (int i = 0; i < itemCount; ++i) {
            getterSetterCoursesList = getterSetterCourses.get(positionStart);
            SQLiteHandlerCourses db = new SQLiteHandlerCourses(context);
            db.deleteCourse(getterSetterCoursesList);
            getterSetterCourses.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override
    public AdapterCourses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final int layout = viewType == TYPE_INACTIVE ? R.layout.recyclerview_row_courses : R.layout.recyclerview_row_courses_active;

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new AdapterCourses.ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(AdapterCourses.ViewHolder holder, final int position) {

        getterSetterCoursesList = getterSetterCourses.get(position);

        holder.courseNumber.setText(getterSetterCoursesList.getCourseNumber());
        holder.courseName.setText(getterSetterCoursesList.getCourseName());
        holder.courseDescription.setText(getterSetterCoursesList.getCourseDescription());
        holder.courseRoomNumber.setText(getterSetterCoursesList.getCourseRoomNumber());
        holder.courseInstructor.setText(getterSetterCoursesList.getCourseInstructor());
        holder.courseTeachingAssistant.setText(getterSetterCoursesList.getCourseTeachingAssistant());
        holder.courseSemesterStartDate.setText(getterSetterCoursesList.getCourseSemesterStartDate());
        holder.courseSemesterEndDate.setText(getterSetterCoursesList.getCourseSemesterEndDate());
        holder.courseDays.setText(getterSetterCoursesList.getCourseDays());
        holder.courseLectureStartTime.setText(getterSetterCoursesList.getCourseLectureStartTime());
        holder.courseLectureEndTime.setText(getterSetterCoursesList.getCourseLectureEndTime());

//        holder.selectedOverlay.setVisibility(isSelected(position) ? View.VISIBLE : View.INVISIBLE);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {

        return getterSetterCourses.size();
    }

    @Override
    public int getItemViewType(int position) {
        final GetterSetterCourses item = getterSetterCourses.get(position);

        return item.isCoursesActive() ? TYPE_ACTIVE : TYPE_INACTIVE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        View selectedOverlay;

        private AdapterCourses.ViewHolder.ClickListener listener;

        TextView courseNumber;
        TextView courseName;
        TextView courseDescription;
        TextView courseRoomNumber;
        TextView courseInstructor;
        TextView courseTeachingAssistant;
        TextView courseSemesterStartDate;
        TextView courseSemesterEndDate;
        TextView courseDays;
        TextView courseLectureStartTime;
        TextView courseLectureEndTime;


        ViewHolder(final View itemView, AdapterCourses.ViewHolder.ClickListener listener) {
            super(itemView);
            this.listener = listener;
            //selectedOverlay = itemView.findViewById(R.id.selected_overlay);

            courseNumber = (TextView) itemView.findViewById(R.id.courseNumber);
            courseName = (TextView) itemView.findViewById(R.id.courseName);
            courseDescription = (TextView) itemView.findViewById(R.id.courseDescription);
            courseRoomNumber = (TextView) itemView.findViewById(R.id.courseRoomNumber);
            courseInstructor = (TextView) itemView.findViewById(R.id.courseInstructor);
            courseTeachingAssistant = (TextView) itemView.findViewById(R.id.courseTeachingAssistant);
            courseSemesterStartDate = (TextView) itemView.findViewById(R.id.courseSemesterStartDate);
            courseSemesterEndDate = (TextView) itemView.findViewById(R.id.courseSemesterEndDate);
            courseDays = (TextView) itemView.findViewById(R.id.courseDays);
            courseLectureStartTime = (TextView) itemView.findViewById(R.id.courseLectureStartTime);
            courseLectureEndTime = (TextView) itemView.findViewById(R.id.courseLectureEndTime);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClicked(getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {

            return listener != null && listener.onItemLongClicked(getAdapterPosition());
        }

        public interface ClickListener {
            void onItemClicked(int position);

            boolean onItemLongClicked(int position);
        }
    }
}
