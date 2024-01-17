package com.example.elkie.alfredpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by elkie on 12/02/2019.
 */

public class PlatesScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_plates);
        //setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        // Ensure correct menu item is selected (where the magic happens)
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        TabHost mTabHost = (TabHost)findViewById(R.id.tabHost);
        mTabHost.setup();

        //Lets add the first Tab
        TabHost.TabSpec mSpec = mTabHost.newTabSpec("Saved");
        mSpec.setContent(R.id.tab1);
        mSpec.setIndicator("Saved");
        mTabHost.addTab(mSpec);

        //Lets add the second Tab
        mSpec = mTabHost.newTabSpec("Unknown");
        mSpec.setContent(R.id.tab2);
        mSpec.setIndicator("Unknown");
        mTabHost.addTab(mSpec);



    }

    private TextView mTextMessage;
    private Intent intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_plates:
                    mTextMessage.setText(R.string.title_plates);
                    intent = new Intent(PlatesScreen.this, PlatesScreen.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    intent = new Intent(PlatesScreen.this, HomeScreen.class);
                    startActivity(intent);

                    return true;
                case R.id.navigation_users:
                    mTextMessage.setText(R.string.title_users);
                    intent = new Intent(PlatesScreen.this, MainActivity.class);
                    startActivity(intent);
                    setContentView(R.layout.activity_main);
                    return true;
                case R.id.navigation_people:
                    mTextMessage.setText(R.string.title_people);
                    intent = new Intent(PlatesScreen.this, PeopleScreen.class);
                    startActivity(intent);
                    setContentView(R.layout.activity_people);
                    return true;

            }
            return false;
        }

    };
}