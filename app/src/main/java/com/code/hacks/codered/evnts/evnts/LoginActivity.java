package com.code.hacks.codered.evnts.evnts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.code.hacks.codered.evnts.evnts.util.Util;
import com.code.hacks.codered.evnts.evnts.views.CustomEditText;

import java.lang.reflect.Array;

/**
 * Created by sudharti on 11/21/15.
 */
public class LoginActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private Toolbar mToolbar;
    private CustomEditText email;
    private CustomEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        email = (CustomEditText) findViewById(R.id.email);
        password = (CustomEditText) findViewById(R.id.password);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(Util.isValidEmail(email.getText().toString().trim())){
                    Toast.makeText(getApplicationContext(), "Valid mail", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid mail", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
