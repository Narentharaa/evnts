package com.code.hacks.codered.evnts.evnts.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.adapters.EventListAdapter;
import com.code.hacks.codered.evnts.evnts.bean.Event;
import com.code.hacks.codered.evnts.evnts.models.Events;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by sudharsanan on 4/15/15.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView eventRecyclerView;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private EventListAdapter eventListAdapter;

    Context context;
    RequestQueue queue;

    public static HomeFragment newInstance(int sectionNumber) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        eventRecyclerView = (RecyclerView) rootView.findViewById(R.id.event_recycler_view);
        eventRecyclerView.setHasFixedSize(true);

        recylerLayoutManager = new LinearLayoutManager(getActivity());
        eventRecyclerView.setLayoutManager(recylerLayoutManager);

        queue = Volley.newRequestQueue(getContext());
        context = getContext();

//        new FetchEvents().execute(getArguments().getInt(ARG_SECTION_NUMBER));

        //TODO Remove after server startup
//        events = new Events();
//        Gson gson = new Gson();
//        String eventsJSON = Util.readJSONFile("events.json", getContext());
//        events = gson.fromJson(eventsJSON, Events.class);

        addData();
        return rootView;
    }

    private class FetchEvents extends AsyncTask<Integer, Integer, ArrayList<Event>> {

        @Override
        protected ArrayList<Event> doInBackground(Integer... sectionNumber) {
            return addData();
        }

        @Override
        protected void onPostExecute(ArrayList<Event> eventArrayList) {
            super.onPostExecute(eventArrayList);

        }
    }

    private ArrayList<Event> addData() {
        ArrayList<Event> resultList = new ArrayList<Event>();

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest sr = new StringRequest(Request.Method.GET, "http://6172ea19.ngrok.io/api/v1/events", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Events events = gson.fromJson(response, Events.class);
                for (Event event : events.getEvents())
                    event.setImageUrl("http://sudharti.github.io/paper/assets/img/img-8.jpg");
                eventListAdapter = new EventListAdapter(getActivity(), events.getEvents());
                eventRecyclerView.setAdapter(eventListAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error while fetching events.", Toast.LENGTH_SHORT).show();
                Log.d("EVENT", "Failed to fetch");
            }
        });

//        for (Event event : events.getEvents()) {
//            event.setImageUrl("http://sudharti.github.io/paper/assets/img/img-8.jpg");
//            resultList.add(event);
//        }

        return resultList;
    }
}
