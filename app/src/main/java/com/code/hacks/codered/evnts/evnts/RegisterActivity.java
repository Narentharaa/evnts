package com.code.hacks.codered.evnts.evnts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.code.hacks.codered.evnts.evnts.bean.ShortUser;
import com.code.hacks.codered.evnts.evnts.bean.User;
import com.code.hacks.codered.evnts.evnts.views.CustomButton;
import com.code.hacks.codered.evnts.evnts.views.CustomEditText;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudharti on 11/21/15.
 */
public class RegisterActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private Toolbar mToolbar;
    private CustomEditText firstName;
    private CustomEditText lastName;
    private CustomEditText univName;
    private CustomEditText email;
    private CustomEditText password;
    private CustomEditText confirmPassword;
    private CustomButton signupButton;

    private String eventPref = "EVENT_PREF";
    private SharedPreferences pref;
    private SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        firstName = (CustomEditText) findViewById(R.id.firstName);
        lastName = (CustomEditText) findViewById(R.id.lastName);
        univName = (CustomEditText) findViewById(R.id.univName);
        email = (CustomEditText) findViewById(R.id.email);
        password = (CustomEditText) findViewById(R.id.password);
        confirmPassword = (CustomEditText) findViewById(R.id.confirmPassword);
        signupButton = (CustomButton) findViewById(R.id.signup_button);

        pref = getSharedPreferences(eventPref, MODE_PRIVATE);
        prefEditor = pref.edit();

        if(!pref.getString("current_user_id", "").isEmpty()) {
            Intent mainActivity = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(mainActivity);
        }

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isComplete = true;
                isComplete = !firstName.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !lastName.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !univName.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !email.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !password.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !confirmPassword.isEmpty(CustomEditText.ERROR) && isComplete;
                if (isComplete) {
                    if (!password.isSameAs(confirmPassword)) {
                        confirmPassword.setError("Passwords do not match.");
                    } else {
                        registerUser(getApplicationContext(), firstName.getText().toString().trim(),
                                lastName.getText().toString().trim(),
                                email.getText().toString().trim(), password.getText().toString().trim());
                    }
                }
            }
        });

    }

    private void registerUser(Context context, final String firstName, final String lastName, final String email, final String password) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest sr = new StringRequest(Request.Method.POST,"http://6172ea19.ngrok.io/api/v1/users/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();

                ShortUser user = gson.fromJson(response, ShortUser.class);

                Toast.makeText(getApplicationContext(), user.getId(), Toast.LENGTH_SHORT).show();

                prefEditor.putString("current_user_id", user.getId());
                prefEditor.putString("current_user_email", user.getEmail());
                prefEditor.putString("current_user_token", user.getAccessToken());

                if(prefEditor.commit()) {

                }

                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMain);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user[email]", email);
                params.put("user[password]", password);
                params.put("user[first_name]", firstName);
                params.put("user[last_name]", lastName);

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
