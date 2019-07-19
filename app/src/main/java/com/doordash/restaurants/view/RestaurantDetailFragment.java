package com.doordash.restaurants.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.doordash.restaurants.R;
import com.doordash.restaurants.model.Restaurant;

public class RestaurantDetailFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    private ImageView mImageView;
    private TextView mRestaurantTitle;
    private TextView mRestaurantDesc;
    private TextView mDeliveryStatus;
    private Restaurant restaurantItem = new Restaurant();

    // Using Singleton pattern and creating one instance for the fragment.
    public static RestaurantDetailFragment newInstance() {
        return new RestaurantDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment

        View view = inflater.inflate(R.layout.fragment_restaurant_details, parent, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        mImageView = view.findViewById(R.id.restaurant_image);
        mRestaurantTitle = view.findViewById(R.id.restaurant_name);
        mRestaurantDesc = view.findViewById(R.id.restaurant_desc);
        mDeliveryStatus = view.findViewById(R.id.status);

        Bundle bundle = getActivity().getIntent().getExtras(); // Getting the Bundle object that pass from another activity

        if (bundle != null)
            restaurantItem = bundle.getParcelable(MainActivity.SELECTED_ITEM);

        if (restaurantItem != null) {

            mRestaurantTitle.setText(restaurantItem.getName());
            mRestaurantDesc.setText(restaurantItem.getDescription());
            mDeliveryStatus.setText(restaurantItem.getStatus());

            Glide.with(getActivity().getApplicationContext())
                        .load(restaurantItem.getCoverImageUrl())
                        .into(mImageView);

        }
    }
}
