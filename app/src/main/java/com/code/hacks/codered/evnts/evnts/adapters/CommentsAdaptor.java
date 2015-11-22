package com.code.hacks.codered.evnts.evnts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.code.hacks.codered.evnts.evnts.R;
import com.code.hacks.codered.evnts.evnts.bean.Comment;
import com.code.hacks.codered.evnts.evnts.views.CustomTextView;

import java.util.ArrayList;

/**
 * Created by sandeep on 11/22/2015.
 */
public class CommentsAdaptor extends BaseAdapter {

    private ArrayList<Comment> commentList;
    private Context context;
    private LayoutInflater inflater;

    private class ViewHolder {
        CustomTextView userName;
        CustomTextView comment;
        CustomTextView commentDate;
    }

    public CommentsAdaptor(Context context, ArrayList<Comment> commentList) {
        this.commentList = commentList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_comment, null);
            holder.userName = (CustomTextView) convertView.findViewById(R.id.user_name);
            holder.commentDate = (CustomTextView) convertView.findViewById(R.id.comment_date);
            holder.comment = (CustomTextView) convertView.findViewById(R.id.comment);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.userName.setText(commentList.get(position).getUserName());
        holder.commentDate.setText(commentList.get(position).getDate());
        holder.comment.setText(commentList.get(position).getComment());
        return convertView;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Comment getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
