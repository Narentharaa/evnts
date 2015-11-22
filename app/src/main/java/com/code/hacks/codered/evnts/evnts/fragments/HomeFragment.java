package com.code.hacks.codered.evnts.evnts.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.adapters.EventListAdapter;
import com.code.hacks.codered.evnts.evnts.bean.Event;

import java.util.ArrayList;

/**
 * Created by sudharsanan on 4/15/15.
 */
public class HomeFragment extends Fragment {

    private RecyclerView eventRecyclerView;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private EventListAdapter eventListAdapter;
    private ArrayList<Event> eventArrayList;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        eventRecyclerView = (RecyclerView) rootView.findViewById(R.id.event_recycler_view);
        eventRecyclerView.setHasFixedSize(true);

        recylerLayoutManager = new LinearLayoutManager(getActivity());
        eventRecyclerView.setLayoutManager(recylerLayoutManager);

       new FetchEvents().execute();

        return rootView;
    }

    private class FetchEvents extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            eventArrayList = addData();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            eventListAdapter = new EventListAdapter(getActivity(), eventArrayList);
            eventRecyclerView.setAdapter(eventListAdapter);
        }
    }

    private ArrayList<Event> addData() {
        // TODO Auto-generated method stub
        ArrayList<Event> resultList = new ArrayList<Event>();

        resultList.add(new Event("Event 1", "http://sudharti.github.io/paper/assets/img/img-8.jpg", "UT Dallas", "21 Nov 2015"));
        resultList.add(new Event("Event 2", "http://sudharti.github.io/paper/assets/img/img-5.jpg", "UT Dallas", "21 Nov 2015"));
        resultList.add(new Event("Event 3", "http://sudharti.github.io/paper/assets/img/img-6.jpg", "UT Dallas", "21 Nov 2015"));
        resultList.add(new Event("Event 4", "http://sudharti.github.io/paper/assets/img/img-7.jpg", "UT Dallas", "21 Nov 2015"));
        resultList.add(new Event("Event 5", "http://sudharti.github.io/paper/assets/img/img-8.jpg", "UT Dallas", "21 Nov 2015"));
        resultList.add(new Event("Event 6", "http://sudharti.github.io/paper/assets/img/img-5.jpg", "UT Dallas", "21 Nov 2015"));

        return resultList;
    }
}
