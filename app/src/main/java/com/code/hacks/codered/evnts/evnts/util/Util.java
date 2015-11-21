package com.code.hacks.codered.evnts.evnts.util;

import android.text.TextUtils;

/**
 * Created by sandeep on 11/21/2015.
 */
public class Util {

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
