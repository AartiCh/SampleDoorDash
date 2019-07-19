package com.doordash.restaurants.repository;

import android.app.ProgressDialog;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.doordash.restaurants.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository class for connecting to server and fetching data.
 */
public class RestaurantRepository {
    private static RestaurantRepository instance;

    private static final String TAG = "Repository";

    public static RestaurantRepository getInstance() {
        if (instance == null)
            instance = new RestaurantRepository();
        return instance;
    }

    /**
     * Method to query the server and retrieve data using retrofit.
     *
     * @return livedata containing list of restaurants
     */
    public MutableLiveData<List<Restaurant>> fetchDataFromServer() {

        final MutableLiveData<List<Restaurant>> data = new MutableLiveData<>();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Restaurant>> call = service.getRestaurantList(37.422740, -122.139956, 0, 50);

        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(@NonNull Call<List<Restaurant>> call, @NonNull Response<List<Restaurant>> response) {
                if (response != null && response.isSuccessful()) {
                    data.postValue(response.body());
                    if (response.body() != null)
                        Log.i("Successful response", response.body().toString());

                } else
                    Log.i(RestaurantRepository.TAG + "No response", "Response is null");
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
}
