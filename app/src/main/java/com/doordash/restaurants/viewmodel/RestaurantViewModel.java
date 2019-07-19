package com.doordash.restaurants.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doordash.restaurants.model.Restaurant;
import com.doordash.restaurants.repository.RestaurantRepository;

import java.util.List;

public class RestaurantViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository = RestaurantRepository.getInstance();

    public LiveData<List<Restaurant>> getRestaurantList() {
        MutableLiveData<List<Restaurant>> movies;
        movies = restaurantRepository.fetchDataFromServer();
        return movies;
    }
}
