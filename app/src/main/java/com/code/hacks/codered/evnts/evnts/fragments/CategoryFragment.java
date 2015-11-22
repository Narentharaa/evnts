package com.code.hacks.codered.evnts.evnts.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.adapters.NavDrawerAdapter;
import com.code.hacks.codered.evnts.evnts.bean.DrawerItem;
import com.code.hacks.codered.evnts.evnts.models.Categories;
import com.code.hacks.codered.evnts.evnts.models.Category;
import com.code.hacks.codered.evnts.evnts.util.Constants;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sandeep on 11/21/2015.
 */
public class CategoryFragment extends ListFragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;
    private ArrayList<DrawerItem> categoryList;
    Context context;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        DrawerItem item = (DrawerItem) l.getAdapter().getItem(position);

        Fragment fragment = HomeFragment.newInstance(2, item.getId());

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).attach(fragment).commit();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        context = getContext();
        addCategories();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    HashMap<String, Integer> iconMap;

    private void createIconMap() {
        iconMap = new HashMap<>();
        iconMap.put("Sports", R.mipmap.ic_action_football_100);
        iconMap.put("Cultural", R.mipmap.ic_action_dancing_100);
        iconMap.put("Volunteering", R.mipmap.ic_action_helping_hand_100);
        iconMap.put("Studies", R.mipmap.ic_action_books_100);
        iconMap.put("Fun", R.mipmap.ic_action_wink_100);
        iconMap.put("Debate/Talk", R.mipmap.ic_action_strike_100);
        iconMap.put("Clubs", R.mipmap.ic_action_clubs_100);
        iconMap.put("Life Skills", R.mipmap.ic_action_life_cycle_100);
        iconMap.put("Food", R.mipmap.ic_action_food_filled_100);
        iconMap.put("Jobs", R.mipmap.ic_action_suitcase_100);

    }

    private int getIcon(String key) {
        return iconMap != null ? iconMap.get(key) : -1;
    }

    private void addCategories() {

        RequestQueue queue = Volley.newRequestQueue(context);

        createIconMap();

        StringRequest sr = new StringRequest(Request.Method.GET, Constants.API_URL + "categories",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Categories categories = gson.fromJson(response, Categories.class);
                        ArrayList<DrawerItem> categoryList = new ArrayList<>();
                        for (Category category : categories.getCategories())
                            categoryList.add(new DrawerItem(category.getName(), iconMap.get(category.getName()), category.getId()));
                        setListAdapter(new NavDrawerAdapter(context, categoryList));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error while fetching categories.", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(sr);
    }

}
