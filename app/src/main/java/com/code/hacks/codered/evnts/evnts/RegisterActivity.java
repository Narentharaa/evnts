package com.code.hacks.codered.evnts.evnts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.code.hacks.codered.evnts.evnts.util.Util;
import com.code.hacks.codered.evnts.evnts.views.CustomButton;
import com.code.hacks.codered.evnts.evnts.views.CustomEditText;

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
    private CustomButton signupButton;

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
        signupButton = (CustomButton) findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isComplete = true;
                isComplete = !firstName.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !lastName.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !univName.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !email.isEmpty(CustomEditText.ERROR) && isComplete;
                isComplete = !password.isEmpty(CustomEditText.ERROR) && isComplete;
                if (isComplete) {
                    //TODO Submit form
                }
            }
        });

    }

}
