package com.code.hacks.codered.evnts.evnts.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.adapters.NavDrawerAdapter;
import com.code.hacks.codered.evnts.evnts.bean.DrawerItem;

import java.util.ArrayList;

/**
 * Created by sandeep on 11/21/2015.
 */
public class CategoryFragment extends ListFragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;
    private ArrayList<DrawerItem> categoryList;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        categoryList = new ArrayList<DrawerItem>();
        new FetchCategories().execute();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    private class FetchCategories extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            categoryList = addCategories();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setListAdapter(new NavDrawerAdapter(getContext(), categoryList));
        }
    }

    private ArrayList<DrawerItem> addCategories() {
        categoryList.add(new DrawerItem("Studies", R.mipmap.ic_action_books_100));
        categoryList.add(new DrawerItem("Cultural", R.mipmap.ic_action_dancing_100));
        categoryList.add(new DrawerItem("Volunteering", R.mipmap.ic_action_helping_hand_100));
        categoryList.add(new DrawerItem("Fun", R.mipmap.ic_action_wink_100));
        categoryList.add(new DrawerItem("Clubs", R.mipmap.ic_action_clubs_100));
        categoryList.add(new DrawerItem("Life Skills", R.mipmap.ic_action_life_cycle_100));
        categoryList.add(new DrawerItem("Food", R.mipmap.ic_action_food_filled_100));
        categoryList.add(new DrawerItem("Jobs", R.mipmap.ic_action_suitcase_100));
        categoryList.add(new DrawerItem("Debates", R.mipmap.ic_action_strike_100));

        return categoryList;
    }

}
