package com.code.hacks.codered.evnts.evnts.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by sandeep on 11/21/2015.
 */
public class Util {

    public final static int NONE = 0;
    public final static int TOAST = 1;
    public final static int ERROR = 2;

    public final static <T extends TextView> boolean isValidEmail(T field){
        String target = field.getText().toString().trim();
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public final static <T extends TextView> boolean isEmpty(T field){
        return isEmpty(field, null, NONE);
    }

    public final static <T extends TextView> boolean isEmpty(T field, Context context, int handle){
        boolean isEmpty = field.getText().toString().trim().equals("");
        if(isEmpty && context != null){
            if(handle == TOAST) {
                Toast.makeText(context, "Please fill " +field.getHint(), Toast.LENGTH_SHORT).show();
            }
        }
        return isEmpty;
    }

}
