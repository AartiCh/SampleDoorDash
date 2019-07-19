package com.doordash.restaurants.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.doordash.restaurants.R;
import com.doordash.restaurants.adapter.MyRestaurantRecyclerViewAdapter;
import com.doordash.restaurants.model.Restaurant;

public class MainActivity extends AppCompatActivity implements MyRestaurantRecyclerViewAdapter.OnRestaurantClickListener {

    protected static String SELECTED_ITEM = "selectedItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = findViewById(R.id.main_activity_container);

        if (savedInstanceState == null) {

            if (isNetworkAvailable()) {
                getSupportFragmentManager().beginTransaction().add(R.id.main_activity_container, RestaurantFragment.newInstance(1))
                        .commit();
            } else {
                ProgressBar progressBar = findViewById(R.id.progress_bar);
                progressBar.setVisibility(View.GONE);

                TextView textView = new TextView(this.getApplicationContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(layoutParams);
                textView.setText("Check internet connection");
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.BLACK);
                frameLayout.addView(textView);
            }
        }
    }

    @Override
    public void onRestaurantClick(Restaurant restaurant) {
        Intent intent = new Intent(this, RestaurantDetailActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putParcelable(MainActivity.SELECTED_ITEM, restaurant);
        intent.putExtras(dataBundle);
        startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager
                connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if(connectivityManager!=null) {
           activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
