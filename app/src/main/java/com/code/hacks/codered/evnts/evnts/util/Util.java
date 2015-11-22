package com.code.hacks.codered.evnts.evnts.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

/**
 * Created by sandeep on 11/21/2015.
 */
public class Util {

    public final static int NONE = 0;
    public final static int TOAST = 1;
    public final static int ERROR = 2;

    public final static <T extends TextView> boolean isValidEmail(T field) {
        String target = field.getText().toString().trim();
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public final static <T extends TextView> boolean isEmpty(T field) {
        return isEmpty(field, null, NONE);
    }

    public final static <T extends TextView> boolean isEmpty(T field, Context context, int handle) {
        boolean isEmpty = field.getText().toString().trim().equals("");
        if (isEmpty && context != null) {
            if (handle == TOAST) {
                Toast.makeText(context, "Please fill " + field.getHint(), Toast.LENGTH_SHORT).show();
            }
        }
        return isEmpty;
    }

    public static String readJSONFile(String filename, Context context) {
        AssetManager manager = context.getAssets();
        try {
            InputStream file = manager.open(filename);
            byte[] formArray = new byte[file.available()];
            file.read(formArray);
            file.close();
            return new String(formArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
