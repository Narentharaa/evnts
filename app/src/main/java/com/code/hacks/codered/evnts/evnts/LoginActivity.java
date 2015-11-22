package com.code.hacks.codered.evnts.evnts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.code.hacks.codered.evnts.evnts.bean.Session;
import com.code.hacks.codered.evnts.evnts.util.Constants;
import com.code.hacks.codered.evnts.evnts.util.Util;
import com.code.hacks.codered.evnts.evnts.views.CustomButton;
import com.code.hacks.codered.evnts.evnts.views.CustomEditText;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

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
    private SharedPreferences pref;
    private SharedPreferences.Editor prefEditor;

    private RequestQueue queue;
    private String eventPref = "EVENT_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        email = (CustomEditText) findViewById(R.id.email);
        password = (CustomEditText) findViewById(R.id.password);
        loginButton = (CustomButton) findViewById(R.id.login_button);
        signupButton = (CustomButton) findViewById(R.id.signup_button);

        pref = getSharedPreferences(eventPref, MODE_PRIVATE);
        prefEditor = pref.edit();

        if(!pref.getString("current_user_id", "").isEmpty()) {
            Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainActivity);
        }

        queue = Volley.newRequestQueue(getApplicationContext());

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
                } else {
                    loginWithCredentials(getApplicationContext(), email.getText().toString().trim(), password.getText().toString().trim());
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

    private void loginWithCredentials(Context context, final String email, final String password) {

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest sr = new StringRequest(Request.Method.POST, Constants.API_URL + "sessions/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();

                Session session = gson.fromJson(response, Session.class);

                prefEditor.putString("current_user_id", session.getId());
                prefEditor.putString("current_user_email", session.getEmail());
                prefEditor.putString("current_user_token", session.getAccessToken());

                prefEditor.commit();

                Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMain);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Wrong email/password combination", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("session[email]", email);
                params.put("session[password]", password);

                return params;
            }
        };
        queue.add(sr);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}