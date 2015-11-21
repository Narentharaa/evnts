package com.code.hacks.codered.evnts.evnts.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import com.code.hacks.codered.evnts.evnts.util.FontUtil;

/**
 * Created by sudharsanan on 4/14/15.
 */
public class CustomEditText extends EditText {
    public CustomEditText(Context context) {
        super(context);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, false);
        }
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, false);
        }
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, false);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if(!isInEditMode()) {
            FontUtil.setFont(this, context, false);
        }
    }
}
