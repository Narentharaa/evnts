package com.code.hacks.codered.evnts.evnts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.code.hacks.codered.evnts.evnts.fragments.CategoryFragment;
import com.code.hacks.codered.evnts.evnts.fragments.HomeFragment;
import com.code.hacks.codered.evnts.evnts.fragments.NavigationDrawerFragment;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private FragmentManager fragmentManager;
    private Handler mHandler;
    private Fragment fragment;

    private SharedPreferences pref;
    private SharedPreferences.Editor prefEditor;
    private String eventPref = "EVENT_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences(eventPref, MODE_PRIVATE);
        prefEditor = pref.edit();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        fragmentManager = getSupportFragmentManager();

        fragment = HomeFragment.newInstance(position + 1);

        if(position == 1) {
            fragment = CategoryFragment.newInstance();
        }

        if(position == 6) {
            prefEditor.clear();
            prefEditor.commit();

            Intent loginAct = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginAct);
            finish();

        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentManager.beginTransaction().replace(R.id.container, fragment).attach(fragment).commit();
            }
        }, 250);
    }


}
