package com.doordash.restaurants.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doordash.restaurants.R;
import com.doordash.restaurants.model.Restaurant;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurant} and makes a call to the
 * specified {@link OnRestaurantClickListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurant> mValues;
    private final OnRestaurantClickListener mListener;
    private final Context mContext;

    public MyRestaurantRecyclerViewAdapter(List<Restaurant> items, OnRestaurantClickListener listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mRestaurantTitle.setText(mValues.get(position).getName());
        holder.mRestaurantDesc.setText(mValues.get(position).getDescription());
        holder.mDeliveryStatus.setText(mValues.get(position).getStatus());

        Glide.with(mContext)
                .load(mValues.get(position).getCoverImageUrl())
                .into(holder.mImageView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onRestaurantClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public Restaurant mItem;
        public final ImageView mImageView;
        public final TextView mRestaurantTitle;
        public final TextView mRestaurantDesc;
        public final TextView mDeliveryStatus;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = view.findViewById(R.id.restaurant_image);
            mRestaurantTitle = view.findViewById(R.id.restaurant_name);
            mRestaurantDesc = view.findViewById(R.id.restaurant_desc);
            mDeliveryStatus = view.findViewById(R.id.delivery_status);
        }

        @Override
        public String toString() {
            return super.toString() + mRestaurantTitle.getText();
        }
    }

    public interface OnRestaurantClickListener {
        void onRestaurantClick(Restaurant restaurant);
    }
}
