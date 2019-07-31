package com.doordash.restaurants.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.doordash.restaurants.model.Restaurant;
import com.doordash.restaurants.repository.RestaurantRepository;

import java.util.List;

public class RestaurantViewModel extends AndroidViewModel {

    MutableLiveData<List<Restaurant>> movies;

    private final RestaurantRepository restaurantRepository = RestaurantRepository.getInstance();

    public RestaurantViewModel(@NonNull Application application) {
        super(application);
        movies = restaurantRepository.fetchDataFromServer();
    }

    public LiveData<List<Restaurant>> getRestaurantList() {
        return movies;
    }


}