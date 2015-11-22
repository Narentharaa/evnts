package com.code.hacks.codered.evnts.evnts.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.code.hacks.codered.evnts.evnts.util.Constants;
import com.google.gson.Gson;

/**
 * Created by sudharsanan on 4/15/15.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String CATEGORY_ID = "category_id";
    private RecyclerView eventRecyclerView;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private EventListAdapter eventListAdapter;

    RequestQueue queue;

    private SharedPreferences pref;
    private String eventPref = "EVENT_PREF";

    public static HomeFragment newInstance(int sectionNumber, int categoryId) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt(CATEGORY_ID, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        pref = getActivity().getSharedPreferences(eventPref, getActivity().MODE_PRIVATE);

        eventRecyclerView = (RecyclerView) rootView.findViewById(R.id.event_recycler_view);
        eventRecyclerView.setHasFixedSize(true);

        recylerLayoutManager = new LinearLayoutManager(getActivity());
        eventRecyclerView.setLayoutManager(recylerLayoutManager);

        queue = Volley.newRequestQueue(getContext());

        addData();
        return rootView;
    }

    private void addData() {

        RequestQueue queue = Volley.newRequestQueue(getContext());

        String url = Constants.API_URL;

        int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        if(sectionNumber == 1) {
            url = Constants.API_URL + "events";
        } else if(sectionNumber == 3) {
            url = Constants.API_URL + "event_registrations/list?user_id=" + pref.getString("current_user_id", "-1");
        }

        int categoryId = getArguments().getInt(CATEGORY_ID);
        if (categoryId != -1)
            url = Constants.API_URL + "categories/" + categoryId + "/events";

        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
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

            }
        });

        queue.add(sr);
    }
}
