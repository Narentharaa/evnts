package com.code.hacks.codered.evnts.evnts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.code.hacks.codered.evnts.evnts.adapters.CommentsAdaptor;
import com.code.hacks.codered.evnts.evnts.bean.Comment;
import com.code.hacks.codered.evnts.evnts.bean.Comments;
import com.code.hacks.codered.evnts.evnts.bean.EventDetail;
import com.code.hacks.codered.evnts.evnts.bean.Registration;
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
 * Created by sandeep on 11/21/15.
 */
public class DetailActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private Toolbar mToolbar;
    private ImageView image;
    private CustomTextView location;
    private CustomTextView date;
    private CustomTextView contact;
    private CustomTextView prize;
    private CustomTextView summary;
    private CustomTextViewBold name;
    private CustomButton registerButton;

    EventDetail detail;
    Intent intent;

    private SharedPreferences pref;
    private String eventPref = "EVENT_PREF";

    ListView commentsView;
    CommentsAdaptor commentsAdaptor;
    ArrayList<Comment> comments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        pref = getSharedPreferences(eventPref, MODE_PRIVATE);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        image = (ImageView) findViewById(R.id.image);
        name = (CustomTextViewBold) findViewById(R.id.name);
        location = (CustomTextView) findViewById(R.id.location);
        contact = (CustomTextView) findViewById(R.id.contact);
        //prize = (CustomTextView) findViewById(R.id.prize);
        summary = (CustomTextView) findViewById(R.id.summary);
        date = (CustomTextView) findViewById(R.id.date);
        registerButton = (CustomButton) findViewById(R.id.register_button);

        intent = getIntent();

        commentsView = (ListView) findViewById(R.id.comments_list);

        getEventDetail();
//        new FetchComments().execute();
    }


//    private class FetchComments extends AsyncTask<Void, Integer, Void> {
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            comments = fetchComments();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            commentsView.setAdapter(new CommentsAdaptor(commentsView.getContext(), comments));
//        }
//    }


    private void getEventDetail() {

//        EventDetail detail = new EventDetail("Event 1", "http://sudharti.github.io/paper/assets/img/img-8.jpg", "UT Dallas", "21 Nov 2015", "Naren", "$1000", "Random Event");

//        final EventDetail detail;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest sr = new StringRequest(Request.Method.GET, Constants.API_URL + "events/" + intent.getIntExtra("event_id", 0),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        detail = gson.fromJson(response, EventDetail.class);

                        if(detail.getImageUrl() != null) {
                            Picasso.with(getApplicationContext())
                                    .load(detail.getImageUrl())
                                    .into(image);
                        }
                        name.setText(detail.getName());
                        if(detail.getLocation() !=null && !detail.getLocation().toString().isEmpty())
                            location.setText(detail.getLocation());
                        contact.setText(detail.getContact());
                        //prize.setText("Prize :\n" + detail.getPrize());
                        summary.setText(detail.getSummary());
                        date.setText(detail.getDate());

                        registerButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //TODO registration
                            registerForEvent(getApplicationContext(),pref.getString("current_user_id", "0"), detail.getId());
                            }
                        });


                        getComments();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error while fetching event info.", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(sr);
    }

    public void getComments() {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest sr = new StringRequest(Request.Method.GET, Constants.API_URL + "events/" + intent.getIntExtra("event_id", 0) + "/comments",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(getApplicationContext(), "Comments: \n" +response, Toast.LENGTH_SHORT).show();
                        Gson gson = new Gson();
                        Comments cmnts = gson.fromJson(response, Comments.class);
                        comments = cmnts.getComments();
                        commentsView.setAdapter(new CommentsAdaptor(commentsView.getContext(), comments));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error while fetching event comments.", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(sr);

    }

    public void registerForEvent(final Context context,final String userId, final Integer eventId) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest sr = new StringRequest(Request.Method.POST, Constants.API_URL + "event_registrations/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Registration registration = gson.fromJson(response, Registration.class);

                Toast.makeText(context, "successfully registered for the event", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Cant register for event", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("event_id", String.valueOf(eventId));
                params.put("user_id", userId);

                return params;
            }
        };
        queue.add(sr);
    }
}