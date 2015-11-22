package com.code.hacks.codered.evnts.evnts.fragments;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new NavDrawerAdapter(getContext(), addCategories()));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    private ArrayList<DrawerItem> addCategories() {
        ArrayList<DrawerItem> categoryList = new ArrayList<>();

        categoryList.add(new DrawerItem("Education", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Sports", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Life Skills", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Lectures", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Food", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Music", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Dance", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Community", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Cultural", R.mipmap.ic_action_events));categoryList.add(new DrawerItem("Education", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Sports", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Life Skills", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Lectures", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Food", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Music", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Dance", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Community", R.mipmap.ic_action_events));
        categoryList.add(new DrawerItem("Cultural", R.mipmap.ic_action_events));


        return categoryList;
    }

}
