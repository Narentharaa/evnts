package com.code.hacks.codered.evnts.evnts.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.adapters.EventListAdapter;
import com.code.hacks.codered.evnts.evnts.bean.Event;

import java.util.ArrayList;

/**
 * Created by sudharsanan on 4/15/15.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView eventRecyclerView;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private EventListAdapter eventListAdapter;

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

        new FetchEvents().execute(getArguments().getInt(ARG_SECTION_NUMBER));

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
