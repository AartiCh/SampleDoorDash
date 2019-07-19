package com.doordash.restaurants;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.doordash.restaurants.model.Restaurant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class RestaurantModelTest {

    private Restaurant restaurant;

    @Before
    public void initialSetup() {
        restaurant = new Restaurant();
        restaurant.setCoverImgUrl("www.google.com");
        restaurant.setDescription("Data");
        restaurant.setStatus("On time");
        restaurant.setName("Restaurant");
        restaurant.setId("1");
    }

    @Test
    public void shouldTestGetName() {
        assertEquals(restaurant.getName(), "Restaurant");
    }

    @Test
    public void shouldTestGetId() {
        assertEquals(restaurant.getId(), "1");
    }

    @Test
    public void shouldTestGetDesc() {
        assertEquals(restaurant.getDescription(), "Data");
    }

    @Test
    public void shouldTestGetCoverImageUrl() {
        assertEquals(restaurant.getCoverImageUrl(), "www.google.com");
    }

    @Test
    public void shouldTestGetStatus() {
        assertEquals(restaurant.getStatus(), "On time");
    }


}

