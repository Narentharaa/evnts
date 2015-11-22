package com.code.hacks.codered.evnts.evnts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.code.hacks.codered.evnts.evnts.util.Util;
import com.code.hacks.codered.evnts.evnts.views.CustomButton;
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
    private CustomButton loginButton;
    private CustomButton signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        email = (CustomEditText) findViewById(R.id.email);
        password = (CustomEditText) findViewById(R.id.password);
        loginButton = (CustomButton) findViewById(R.id.login_button);
        signupButton = (CustomButton) findViewById(R.id.signup_button);

        //Validates entry for email address
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!email.isValidEmail()) {
                    email.setError(getString(R.string.invalidEmail));
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check for email and password entry
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.fillEmailAndPass), Toast.LENGTH_SHORT).show();
                } else if (false) {
                    //TODO Authentication failed
                } else {
                    Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                    Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentMain);
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register);
            }
        });

    }
}
