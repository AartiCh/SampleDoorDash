package com.doordash.restaurants.repository;

import com.doordash.restaurants.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface GetDataService {
    /*
        API used: https://api.doordash.com/v2/restaurant/?lat=37.422740&lng=-122.139956&offset=0&limit=5
     */
    @GET("restaurant")
    Call<List<Restaurant>> getRestaurantList(
            @Query("lat") double lat,
            @Query("lng") double lng,
            @Query("offset") int offset,
            @Query("limit") int limit
    );
}