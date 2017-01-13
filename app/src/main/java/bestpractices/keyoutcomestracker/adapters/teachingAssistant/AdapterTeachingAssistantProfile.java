package bestpractices.keyoutcomestracker.adapters.teachingAssistant;

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
import bestpractices.keyoutcomestracker.gettersSetters.teachingAssistant.GetterSetterTeachingAssistant;
import bestpractices.keyoutcomestracker.sqlite.teachingAssistant.SQLiteHandlerTeachingAssistant;


public class AdapterTeachingAssistantProfile extends AdapterSelectable<AdapterTeachingAssistantProfile.ViewHolder> {

    private static final int TYPE_INACTIVE = 0;
    private static final int TYPE_ACTIVE = 1;

    private static List<GetterSetterTeachingAssistant> getterSetterTeachingAssistant = new ArrayList<>();
    private static Context context;
    GetterSetterTeachingAssistant getterSetterTeachingAssistantList;

    private AdapterTeachingAssistantProfile.ViewHolder.ClickListener clickListener;

    public AdapterTeachingAssistantProfile(Context context, List<GetterSetterTeachingAssistant> getterSetterTeachingAssistant, AdapterTeachingAssistantProfile.ViewHolder.ClickListener clickListener) {
        super();
        this.context = context;
        this.getterSetterTeachingAssistant = getterSetterTeachingAssistant;
        this.clickListener = clickListener;
    }

    // Removing a single item from the recyclerView
    private void removeItem(int position) {
        getterSetterTeachingAssistantList = getterSetterTeachingAssistant.get(position);
        SQLiteHandlerTeachingAssistant db = new SQLiteHandlerTeachingAssistant(context);
        db.deleteTeachingAssistantProfile(getterSetterTeachingAssistantList);
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
            getterSetterTeachingAssistantList = getterSetterTeachingAssistant.get(positionStart);
            SQLiteHandlerTeachingAssistant db = new SQLiteHandlerTeachingAssistant(context);
            db.deleteTeachingAssistantProfile(getterSetterTeachingAssistantList);
            getterSetterTeachingAssistant.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override
    public AdapterTeachingAssistantProfile.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final int layout = viewType == TYPE_INACTIVE ? R.layout.recyclerview_row_teaching_assistant_profile : R.layout.recyclerview_row_teaching_assistant_profile_active;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new AdapterTeachingAssistantProfile.ViewHolder(view, clickListener);
    }

    // Need to finsih this one!
    @Override
    public void onBindViewHolder(AdapterTeachingAssistantProfile.ViewHolder holder, final int position) {

        getterSetterTeachingAssistantList = getterSetterTeachingAssistant.get(position);

        holder.teachingAssistantFirstName.setText(getterSetterTeachingAssistantList.getTeachingAssistantFirstName());
        holder.teachingAssistantLastName.setText(getterSetterTeachingAssistantList.getTeachingAssistantLastName());
        holder.teachingAssistantOfficeNumber.setText(getterSetterTeachingAssistantList.getTeachingAssistantOfficeNumber());
        holder.teachingAssistantOfficeBuilding.setText(getterSetterTeachingAssistantList.getTeachingAssistantBuilding());
        holder.teachingAssistantEmailAddress.setText(getterSetterTeachingAssistantList.getTeachingAssistantEmailAddress());
        holder.teachingAssistantPhoneNumber.setText(getterSetterTeachingAssistantList.getTeachingAssistantPhoneNumber());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return getterSetterTeachingAssistant.size();
    }

    @Override
    public int getItemViewType(int position) {
        final GetterSetterTeachingAssistant item = getterSetterTeachingAssistant.get(position);

        return item.isTeachingAssistantActive() ? TYPE_ACTIVE : TYPE_INACTIVE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        View selectedOverlay;

        private AdapterTeachingAssistantProfile.ViewHolder.ClickListener listener;

        TextView teachingAssistantFirstName;
        TextView teachingAssistantLastName;
        TextView teachingAssistantOfficeNumber;
        TextView teachingAssistantOfficeBuilding;
        TextView teachingAssistantEmailAddress;
        TextView teachingAssistantPhoneNumber;


        ViewHolder(final View itemView, AdapterTeachingAssistantProfile.ViewHolder.ClickListener listener) {
            super(itemView);
            this.listener = listener;
            //selectedOverlay = itemView.findViewById(R.id.selectedOverlay);

            teachingAssistantFirstName = (TextView) itemView.findViewById(R.id.teachingAssistantFirstName);
            teachingAssistantLastName = (TextView) itemView.findViewById(R.id.teachingAssistantLastName);
            teachingAssistantOfficeNumber = (TextView) itemView.findViewById(R.id.teachingAssistantOfficeNumber);
            teachingAssistantOfficeBuilding = (TextView) itemView.findViewById(R.id.teachingAssistantOfficeBuilding);
            teachingAssistantEmailAddress = (TextView) itemView.findViewById(R.id.teachingAssistantEmailAddress);
            teachingAssistantPhoneNumber = (TextView) itemView.findViewById(R.id.teachingAssistantPhoneNumber);

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
