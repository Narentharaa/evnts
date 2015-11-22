package com.code.hacks.codered.evnts.evnts;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.code.hacks.codered.evnts.evnts.adapters.CommentsAdaptor;
import com.code.hacks.codered.evnts.evnts.adapters.NavDrawerAdapter;
import com.code.hacks.codered.evnts.evnts.bean.Comment;
import com.code.hacks.codered.evnts.evnts.bean.EventDetail;
import com.code.hacks.codered.evnts.evnts.views.CustomTextView;
import com.code.hacks.codered.evnts.evnts.views.CustomTextViewBold;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sandeep on 11/21/15.
 */
public class DetailActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private Toolbar mToolbar;
    private ImageView image;
    private CustomTextView location;
    private CustomTextView date;
    private CustomTextView contact;
    private CustomTextView prize;
    private CustomTextView summary;
    private CustomTextViewBold name;

    ListView commentsView;
    CommentsAdaptor commentsAdaptor;
    ArrayList<Comment> comments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        image = (ImageView) findViewById(R.id.image);
        name = (CustomTextViewBold) findViewById(R.id.name);
        location = (CustomTextView) findViewById(R.id.location);
        contact = (CustomTextView) findViewById(R.id.contact);
        prize = (CustomTextView) findViewById(R.id.prize);
        summary = (CustomTextView) findViewById(R.id.summary);
        date = (CustomTextView) findViewById(R.id.date);

        EventDetail detail = getDetail();

        Picasso.with(getApplicationContext())
                .load(detail.getImageUrl())
                .into(image);
        name.setText(detail.getName());
        location.setText("Location :\n" + detail.getLocation());
        contact.setText("Contact :\n" + detail.getContact());
        prize.setText("Prize :\n" + detail.getPrize());
        summary.setText("Summary :\n" + detail.getSummary());
        date.setText("Date :\n" + detail.getDate());

        commentsView = (ListView) findViewById(R.id.comments_list);
        new FetchComments().execute();
    }

    private ArrayList<Comment> fetchComments() {
        comments.add(new Comment("Naren", "Hello", "11/22/2015"));
        comments.add(new Comment("Naren", "Hello", "11/22/2015"));
        comments.add(new Comment("Naren", "Hello", "11/22/2015"));
        comments.add(new Comment("Naren", "Hello", "11/22/2015"));
        comments.add(new Comment("Naren", "Hello", "11/22/2015"));
        return comments;
    }

    private class FetchComments extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            comments = fetchComments();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            commentsView.setAdapter(new CommentsAdaptor(commentsView.getContext(), comments));
        }
    }

    private EventDetail getDetail() {
        EventDetail detail = new EventDetail("Event 1", "http://sudharti.github.io/paper/assets/img/img-8.jpg", "UT Dallas", "21 Nov 2015", "Naren", "$1000", "Random Event");
        return detail;
    }
}