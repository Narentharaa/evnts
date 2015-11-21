package com.code.hacks.codered.evnts.evnts.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;

import com.code.hacks.codered.evnts.evnts.util.FontUtil;

/**
 * Created by sudharsanan on 4/14/15.
 */
public class CustomEditText extends EditText {

    public static int NONE = 0;
    public static int TOAST = 1;
    public static int ERROR = 2;

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

    public boolean isEmpty(){
        return isEmpty(NONE);
    }

    public boolean isEmpty(int handle){
        boolean isEmpty = this.getText().toString().trim().equals("");
        if(isEmpty && handle != NONE){
            if(handle == TOAST){
                Toast.makeText(getContext(), "Please fill " +this.getHint(), Toast.LENGTH_SHORT).show();
            } else if(handle == ERROR){
                this.setError("Please fill " +this.getHint());
            }
        }
        return isEmpty;
    }

    public boolean isValidEmail(){
        String target = this.getText().toString().trim();
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
