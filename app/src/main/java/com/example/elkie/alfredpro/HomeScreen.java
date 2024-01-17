package com.example.elkie.alfredpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by elkie on 12/02/2019.
 */

public class HomeScreen extends AppCompatActivity {

    private TextView mTextMessage;
    private Intent intent;
    private WebView mWebView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    intent = new Intent(HomeScreen.this, HomeScreen.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_users:
                    mTextMessage.setText(R.string.title_users);
                    intent = new Intent(HomeScreen.this, MainActivity.class);
                    startActivity(intent);
                    setContentView(R.layout.activity_main);
                    return true;
                case R.id.navigation_people:
                    mTextMessage.setText(R.string.title_people);
                    intent = new Intent(HomeScreen.this, PeopleScreen.class);
                    startActivity(intent);
                    setContentView(R.layout.activity_people);
                    return true;
                case R.id.navigation_plates:
                    mTextMessage.setText(R.string.title_plates);
                    intent = new Intent(HomeScreen.this, PlatesScreen.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        // Ensure correct menu item is selected (where the magic happens)
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        String ipAddr = "http://192.168.15.103:8081/";
        mWebView = (WebView) findViewById(R.id.myWebView);
        mWebView.loadUrl(ipAddr);

        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mWebView.loadUrl("file:///android_asset/myerrorpage.html");

            }
        });

    }
}