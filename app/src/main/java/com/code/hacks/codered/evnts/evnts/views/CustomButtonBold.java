package com.code.hacks.codered.evnts.evnts.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import com.code.hacks.codered.evnts.evnts.util.FontUtil;

/**
 * Created by sudharti on 11/21/15.
 */
public class CustomButtonBold extends Button {

    public CustomButtonBold(Context context) {
        super(context);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, true);
        }
    }

    public CustomButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, true);
        }
    }

    public CustomButtonBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, true);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomButtonBold(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, true);
        }
    }
}
