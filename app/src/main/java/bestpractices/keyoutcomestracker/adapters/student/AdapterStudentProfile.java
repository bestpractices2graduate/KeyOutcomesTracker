package bestpractices.keyoutcomestracker.adapters.student;


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
import bestpractices.keyoutcomestracker.gettersSetters.student.GetterSetterStudentProfile;
import bestpractices.keyoutcomestracker.sqlite.student.SQLiteHandlerStudentProfile;

public class AdapterStudentProfile extends AdapterSelectable<AdapterStudentProfile.ViewHolder> {

    private static final int TYPE_INACTIVE = 0;
    private static final int TYPE_ACTIVE = 1;

    //static ActivityStudentProfile activityStudentProfile;

    private static List<GetterSetterStudentProfile> getterSetterStudentProfile = new ArrayList<>();
    private static Context context;
    GetterSetterStudentProfile getterSetterStudentProfileList;

    private AdapterStudentProfile.ViewHolder.ClickListener clickListener;

    public AdapterStudentProfile(Context context, List<GetterSetterStudentProfile> getterSetterStudentProfile, AdapterStudentProfile.ViewHolder.ClickListener clickListener) {
        super();
        this.context = context;
        this.getterSetterStudentProfile = getterSetterStudentProfile;
        this.clickListener = clickListener;
    }

    // Removing a single item from the recyclerview
    private void removeItem(int position) {
        getterSetterStudentProfileList = getterSetterStudentProfile.get(position);
        SQLiteHandlerStudentProfile db = new SQLiteHandlerStudentProfile(context);
        db.deleteStudentProfile(getterSetterStudentProfileList);
        getterSetterStudentProfile.remove(position);
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

                for(int i = 0; i < count; ++i) {
                    positions.remove(0);
                }
            }
        }
    }


    // Removing multiple items from the RecyclerView
    private void removeRange(int positionStart, int itemCount) {
        for (int i = 0; i < itemCount; ++i){
            getterSetterStudentProfileList = getterSetterStudentProfile.get(positionStart);
            SQLiteHandlerStudentProfile db = new SQLiteHandlerStudentProfile(context);
            db.deleteStudentProfile(getterSetterStudentProfileList);
            getterSetterStudentProfile.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override
    public AdapterStudentProfile.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final int layout = viewType == TYPE_INACTIVE ? R.layout.recyclerview_row_student_profile : R.layout.recyclerview_row_student_profile_active;

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(AdapterStudentProfile.ViewHolder holder, final int position) {

        getterSetterStudentProfileList = getterSetterStudentProfile.get(position);

        holder.firstName.setText(getterSetterStudentProfileList.getStudentFirstName());
        holder.lastName.setText(getterSetterStudentProfileList.getStudentLastName());

//        holder.selectedOverlay.setVisibility(isSelected(position) ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {

        return  getterSetterStudentProfile.size();
    }

    @Override
    public int getItemViewType(int position) {
        final GetterSetterStudentProfile item = getterSetterStudentProfile.get(position);

        return item.isStudentActive() ? TYPE_ACTIVE : TYPE_INACTIVE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        View selectedOverlay;

        private ClickListener listener;

        TextView firstName;
        TextView lastName;
        TextView studentID;
        TextView semester;
        TextView numberOfClasses;
        TextView schoolName;




        ViewHolder(final View itemView, ClickListener listener) {
            super(itemView);
            this.listener = listener;
            //selectedOverlay = itemView.findViewById(R.id.selected_overlay);

            firstName = (TextView) itemView.findViewById(R.id.first);
            lastName = (TextView) itemView.findViewById(R.id.last);
            studentID = (TextView) itemView.findViewById(R.id.studentid);
            //semester = (TextView) itemView.findViewById(R.id.semester);
            numberOfClasses = (TextView) itemView.findViewById(R.id.numberofclasess);
            schoolName = (TextView) itemView.findViewById(R.id.schoolname);


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
