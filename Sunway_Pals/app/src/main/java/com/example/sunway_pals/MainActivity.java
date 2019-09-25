package com.example.sunway_pals;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity{
    DrawerLayout myDrawerLayout;
    NavigationView myNavigationView;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *Setup the DrawerLayout and NavigationView
         */
        myDrawerLayout = findViewById(R.id.drawerLayout);
        myNavigationView = findViewById(R.id.nav_view) ;
        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the HomeFragment as the first Fragment
         */
        myFragmentManager = getSupportFragmentManager();
        myFragmentTransaction = myFragmentManager.beginTransaction();
        myFragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();


        /**
         * Setup click events on the Navigation View Items.
         */
        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem selectedMenuItem) {
                myDrawerLayout.closeDrawers();
                if (selectedMenuItem.getItemId() == R.id.nav_points) {
                    setContentView(R.layout.my_points_layout);
                } else if (selectedMenuItem.getItemId() == R.id.nav_vouchers) {
                    setContentView(R.layout.voucher_layout);
                } else if (selectedMenuItem.getItemId() == R.id.nav_benefits) {
                    setContentView(R.layout.my_benefits_layout);
                } else if (selectedMenuItem.getItemId() == R.id.nav_cards) {
                    setContentView(R.layout.manage_card_layout);
                }

                return false;
            }
        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
        myDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    public void goSetting(View view) {
        setContentView(R.layout.setting_layout);
    }

    public void goPromoTab1(View view) {
        // Do something in response to button click
        setContentView(R.layout.promo_tab_one_layout);
    }

    public void goHome(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void goVoucher(View view) {
        setContentView(R.layout.voucher_layout);
    }

}