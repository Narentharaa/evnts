package com.code.hacks.codered.evnts.evnts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.code.hacks.codered.evnts.evnts.bean.EventDetail;
import com.code.hacks.codered.evnts.evnts.views.CustomTextView;
import com.code.hacks.codered.evnts.evnts.views.CustomTextViewBold;
import com.squareup.picasso.Picasso;

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

    }

    private EventDetail getDetail() {
        EventDetail detail = new EventDetail("Event 1", "http://sudharti.github.io/paper/assets/img/img-8.jpg", "UT Dallas", "21 Nov 2015", "Naren", "$1000", "Random Event");
        return detail;
    }
}