package com.code.hacks.codered.evnts.evnts.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.bean.Event;
import com.code.hacks.codered.evnts.evnts.views.CustomTextView;
import com.code.hacks.codered.evnts.evnts.views.CustomTextViewBold;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sudharti on 11/21/15.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Event> eventArrayList;

    public EventListAdapter(Context context, ArrayList<Event> eventsArrayList)  {
        this.context = context;
        this.eventArrayList = eventsArrayList;
    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventListAdapter.ViewHolder holder, int position) {
        final Event event = eventArrayList.get(position);
        holder.eventName.setText(event.getName());
        Picasso.with(context)
                .load(event.getImageUrl())
                .into(holder.eventImage);
    }

    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView eventImage;
        private CustomTextViewBold eventName;

        public ViewHolder(View itemView) {
            super(itemView);
            eventImage = (ImageView) itemView.findViewById(R.id.event_image);
            eventName = (CustomTextViewBold) itemView.findViewById(R.id.event_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Call the Event Detail Intent here
        }
    }
}
