package com.code.hacks.codered.evnts.evnts.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.adapters.EventListAdapter;

/**
 * Created by sudharsanan on 4/15/15.
 */
public class HomeFragment extends Fragment {

    private RecyclerView eventRecyclerView;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private EventListAdapter recylerAdapter;

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

        return rootView;
    }

    private class FetchEvents extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }
}
