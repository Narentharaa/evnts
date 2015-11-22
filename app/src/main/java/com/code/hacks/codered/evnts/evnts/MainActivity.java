package com.code.hacks.codered.evnts.evnts;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commit();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        fragmentManager = getSupportFragmentManager();
       /* mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(position == 0) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, HomeFragment.newInstance())
                            .commit();
                } else if(position == 1) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, CategoryFragment.newInstance())
                            .commit();
                }
            }
        }, 200);
*/

        if(position == 0) {
            /*fragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commit();*/
            fragment = HomeFragment.newInstance();
        } else if(position == 1) {
            /*fragmentManager.beginTransaction()
                    .replace(R.id.container, CategoryFragment.newInstance())
                    .commit();*/
            fragment = CategoryFragment.newInstance();
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
