package com.code.hacks.codered.evnts.evnts.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.code.hacks.codered.evnts.evnts.DetailActivity;
import com.code.hacks.codered.evnts.evnts.MainActivity;
import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.bean.Event;
import com.code.hacks.codered.evnts.evnts.bean.Favored;
import com.code.hacks.codered.evnts.evnts.bean.Session;
import com.code.hacks.codered.evnts.evnts.util.Constants;
import com.code.hacks.codered.evnts.evnts.views.CustomButton;
import com.code.hacks.codered.evnts.evnts.views.CustomTextView;
import com.code.hacks.codered.evnts.evnts.views.CustomTextViewBold;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        holder.eventLocation.setText(event.getLocation());
        holder.eventDate.setText(event.getDate());
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
        private CustomTextView eventDate;
        private CustomTextView eventLocation;
        private ImageButton shareButton;
        private ImageButton bookmarkButton;
        private CustomButton moreDetailButton;
        private SharedPreferences pref;
        private String eventPref = "EVENT_PREF";

        public ViewHolder(View itemView) {
            super(itemView);
            eventImage = (ImageView) itemView.findViewById(R.id.event_image);
            eventName = (CustomTextViewBold) itemView.findViewById(R.id.event_name);
            eventLocation = (CustomTextView) itemView.findViewById(R.id.event_location);
            eventDate = (CustomTextView) itemView.findViewById(R.id.event_date);
            shareButton = (ImageButton) itemView.findViewById(R.id.share_button);
            bookmarkButton = (ImageButton) itemView.findViewById(R.id.bookmark_button);
            moreDetailButton = (CustomButton) itemView.findViewById(R.id.more_detail_button);

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Here is the share content body";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    v.getContext().startActivity(Intent.createChooser(sharingIntent, "Share via"));
                    Toast.makeText(v.getContext(), "Sharing event", Toast.LENGTH_SHORT).show();
                }
            });

            bookmarkButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    for(Event event : eventArrayList) {
                        if (event.getName().trim().equals(eventName.getText().toString().trim())) {
                            pref = context.getSharedPreferences(eventPref, Context.MODE_PRIVATE);
                            createBookmark(context, event.getId(), pref.getString("current_user_id", "0"));
                            break;
                        }
                    }
                }
            });

            moreDetailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail = new Intent(v.getContext(), DetailActivity.class);
                    for(Event event : eventArrayList) {
                        if (event.getName().trim().equals(eventName.getText().toString().trim())) {
                            detail.putExtra("event_id", event.getId());
                            break;
                        }
                    }

                    v.getContext().startActivity(detail);
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent detail = new Intent(v.getContext(), DetailActivity.class);
            //Call the Event Detail Intent here
            for(Event event : eventArrayList) {
                if (event.getName().trim().equals(eventName.getText().toString().trim())) {
                    detail.putExtra("event_id", event.getId());
                    break;
                }
            }

            v.getContext().startActivity(detail);
        }
    }

    public void createBookmark(final Context context, final int eventId, final String userId) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest sr = new StringRequest(Request.Method.POST, Constants.API_URL + "favourites/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Favored favored = gson.fromJson(response, Favored.class);
                if(favored.isFavored()) {
                    Toast.makeText(context, "Bookmarked Event", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id", userId);
                params.put("event_id", String.valueOf(eventId));

                return params;
            }
        };
        queue.add(sr);
    }

}
