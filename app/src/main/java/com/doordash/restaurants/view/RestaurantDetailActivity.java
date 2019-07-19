package com.doordash.restaurants.view;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.doordash.restaurants.R;

public class RestaurantDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_activity_container, RestaurantDetailFragment.newInstance())
                    .commit();
        }
    }
}
