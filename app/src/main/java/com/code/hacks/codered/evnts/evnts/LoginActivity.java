package com.code.hacks.codered.evnts.evnts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by sudharti on 11/21/15.
 */
public class LoginActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

    }
}
