package com.code.hacks.codered.evnts.evnts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sudharti on 11/22/15.
 */
public class HelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
