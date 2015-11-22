package com.code.hacks.codered.evnts.evnts.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

/**
 * Created by sudharsanan on 4/15/15.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView eventRecyclerView;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private EventListAdapter eventListAdapter;

    RequestQueue queue;
    Intent intent;

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
        intent = getActivity().getIntent();
        addData();
        return rootView;
    }

    private void addData() {

        RequestQueue queue = Volley.newRequestQueue(getContext());

        String url = "http://6172ea19.ngrok.io/api/v1/events";
        int categoryId = intent.getIntExtra("category_id", 0);

        if (categoryId != 0)
            url = "http://6172ea19.ngrok.io/api/v1/categories/" + categoryId;

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
                Toast.makeText(getContext(), "Error while fetching events.", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(sr);
    }
}
