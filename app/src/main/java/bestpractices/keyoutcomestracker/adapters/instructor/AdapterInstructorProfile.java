package bestpractices.keyoutcomestracker.adapters.instructor;


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
import bestpractices.keyoutcomestracker.gettersSetters.instructor.GetterSetterInstructor;
import bestpractices.keyoutcomestracker.sqlite.instructor.SQLiteHandlerInstructor;

public class AdapterInstructorProfile extends AdapterSelectable<AdapterInstructorProfile.ViewHolder> {

    private static final int TYPE_INACTIVE = 0;
    private static final int TYPE_ACTIVE = 1;

    private static List<GetterSetterInstructor> getterSetterInstructor = new ArrayList<>();
    private static Context context;
    GetterSetterInstructor getterSetterInstructorList;

    private AdapterInstructorProfile.ViewHolder.ClickListener clickListener;

    public AdapterInstructorProfile(Context context, List<GetterSetterInstructor> getterSetterInstructor, AdapterInstructorProfile.ViewHolder.ClickListener clickListener) {
        super();
        this.context = context;
        this.getterSetterInstructor = getterSetterInstructor;
        this.clickListener = clickListener;
    }

    // Removing a single item from the recyclerView
    private void removeItem(int position) {
        getterSetterInstructorList = getterSetterInstructor.get(position);
        SQLiteHandlerInstructor db = new SQLiteHandlerInstructor(context);
        db.deleteInstructorProfile(getterSetterInstructorList);
        notifyItemRemoved(position);
    }

    public void removeItems(List<Integer> positions) {
        Collections.sort(positions, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return rhs - lhs;
            }
        });

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

    // Removing multiple items from the recyclerView
    private void removeRange(int positionStart, int itemCount) {
        for (int i = 0; i < itemCount; ++i) {
            getterSetterInstructorList = getterSetterInstructor.get(positionStart);
            SQLiteHandlerInstructor db = new SQLiteHandlerInstructor(context);
            db.deleteInstructorProfile(getterSetterInstructorList);
            getterSetterInstructor.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }


    @Override
    public AdapterInstructorProfile.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final int layout = viewType == TYPE_INACTIVE ? R.layout.recyclerview_row_instructor_profile : R.layout.recyclerview_row_instructor_profile_active;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(view, clickListener);
    }

    // Need to finsih this one!
    @Override
    public void onBindViewHolder(AdapterInstructorProfile.ViewHolder holder, final int position) {

        getterSetterInstructorList = getterSetterInstructor.get(position);

        holder.instructorFirstName.setText(getterSetterInstructorList.getInstructorFirstName());
        holder.instructorLastName.setText(getterSetterInstructorList.getInstructorLastName());
        holder.instructorOfficeNumber.setText(getterSetterInstructorList.getInstructorOfficeNumber());
        holder.instructorOfficeBuilding.setText(getterSetterInstructorList.getInstructorBuilding());
        holder.instructorEmailAddress.setText(getterSetterInstructorList.getInstructorEmailAddress());
        holder.instructorPhoneNumber.setText(getterSetterInstructorList.getInstructorPhoneNumber());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return getterSetterInstructor.size();
    }

    @Override
    public int getItemViewType(int position) {
        final GetterSetterInstructor item = getterSetterInstructor.get(position);

        return item.isInstructorActive() ? TYPE_ACTIVE : TYPE_INACTIVE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        View selectedOverlay;

        private ClickListener listener;

        TextView instructorFirstName;
        TextView instructorLastName;
        TextView instructorOfficeNumber;
        TextView instructorOfficeBuilding;
        TextView instructorEmailAddress;
        TextView instructorPhoneNumber;


        ViewHolder(final View itemView, ClickListener listener) {
            super(itemView);
            this.listener = listener;
            //selectedOverlay = itemView.findViewById(R.id.selectedOverlay);

            instructorFirstName = (TextView) itemView.findViewById(R.id.instructorFirstName);
            instructorLastName = (TextView) itemView.findViewById(R.id.instructorLastName);
            instructorOfficeNumber = (TextView) itemView.findViewById(R.id.instructorOfficeNumber);
            instructorOfficeBuilding = (TextView) itemView.findViewById(R.id.instructorOfficeBuilding);
            instructorEmailAddress = (TextView) itemView.findViewById(R.id.instructorEmailAddress);
            instructorPhoneNumber = (TextView) itemView.findViewById(R.id.instructorPhoneNumber);



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
