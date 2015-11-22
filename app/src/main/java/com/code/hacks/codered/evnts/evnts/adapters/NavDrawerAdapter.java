package com.code.hacks.codered.evnts.evnts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.bean.DrawerItem;

import java.util.ArrayList;


/**
 * Created by sudharsanan on 2/21/15.
 */
public class NavDrawerAdapter extends BaseAdapter {

    private ArrayList<DrawerItem> drawerArrayList;
    private LayoutInflater mInflater;
    private int position_selected = 0;

    public NavDrawerAdapter(Context mContext, ArrayList<DrawerItem> drawerArrayList) {
        this.drawerArrayList = drawerArrayList;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return drawerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return drawerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        private ImageView icon;
        private TextView name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        final ViewHolder viewHolder;

        if(convertView == null) {
            view = mInflater.inflate(R.layout.item_nav_list, null);
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) view.findViewById(R.id.icon);
            viewHolder.name = (TextView) view.findViewById(R.id.action_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if(position == position_selected) {
            view.setBackgroundResource(R.drawable.list_action_bg_selected);
        } else {
            view.setBackgroundResource(R.drawable.list_action_bg);
        }

        viewHolder.name.setText(drawerArrayList.get(position).getAction());
        viewHolder.icon.setImageResource(drawerArrayList.get(position).getIcon());

        return view;
    }

    public void setPositionSelected(int position_selected) {
        this.position_selected = position_selected;
    }
}
