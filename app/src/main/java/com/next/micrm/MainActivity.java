package com.next.micrm;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {
    private CharSequence mTitle;
    private BoxLeftMenu mNavigationDrawerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationDrawerFragment = (BoxLeftMenu) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container,
                        MainActivityFragment.newInstace(position+1)).commit();
    }

    public void onSectionAttached(int number){
        switch (number){
            case 1:
                mTitle = getString(R.string.navigation_drawer_home);
                break;
            case 2:
                mTitle = getString(R.string.navigation_drawer_people);
                break;
            case 3:
                mTitle = getString(R.string.navigation_drawer_organization);
                break;
            case 4:
                mTitle = getString(R.string.navigation_drawer_commerce);
                break;
            case 5:
                mTitle = getString(R.string.navigation_drawer_activity);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
