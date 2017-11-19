package com.example.mapy;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;

import java.io.IOException;

public class Location {
    public static LatLng getLocationFromAddress(String address) {
        final Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("pl").getGeocoderRequest();
        try {
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
            return geocoderResponse.getResults().get(0).getGeometry().getLocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getGoogleUrlFromAddress(String address) {
        String url = "https://www.google.com/maps/embed/v1/place?key=AIzaSyAoOs0Hu5E5_c92o4-xmIN7QMgxMzXrLes&";
        url += "q=";
        url += address;
        return url;
    }
}