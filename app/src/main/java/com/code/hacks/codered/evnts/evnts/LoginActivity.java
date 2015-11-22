package com.code.hacks.codered.evnts.evnts;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.code.hacks.codered.evnts.evnts.views.CustomButton;
import com.code.hacks.codered.evnts.evnts.views.CustomEditText;

/**
 * Created by sudharti on 11/21/15.
 */
public class LoginActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private Toolbar mToolbar;
    private CustomEditText CustomEditText;
    private CustomEditText email;
    private CustomEditText Password;
    private CustomButton Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        email=(CustomEditText)findViewById(R.id.email);
        // function to validate the email

        Password=(CustomEditText)findViewById(R.id)



    }

}
