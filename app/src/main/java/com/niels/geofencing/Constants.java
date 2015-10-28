package com.niels.geofencing;

import com.google.android.gms.maps.model.LatLng;
import java.util.HashMap;

/**
 * Created by niels on 11/10/2015.
 */

public final class Constants {

    private Constants() {
    }

    public static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";

    public static final String SHARED_PREFERENCES_NAME = PACKAGE_NAME + ".SHARED_PREFERENCES_NAME";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    /**
     * Used to set an expiration time for a geofence. After this amount of time Location Services
     * stops tracking the geofence.
     */
    public static final long GEOFENCE_EXPIRATION_IN_HOURS = 999999;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    public static final float GEOFENCE_RADIUS_IN_METERS = 100;

    /**
     * Map for storing information about Oulu landmarks.
     */
    public static final HashMap<String, LatLng> OULU_LANDMARKS = new HashMap<String, LatLng>();
    static {
        OULU_LANDMARKS.put("University", new LatLng(65.059294, 25.467327));

        OULU_LANDMARKS.put("University office", new LatLng(65.0576855, 25.4685685));

        OULU_LANDMARKS.put("Niels", new LatLng(65.059182, 25.473887));

        OULU_LANDMARKS.put("Babel", new LatLng(65.059917, 25.479695));

        OULU_LANDMARKS.put("Rotuaari", new LatLng(65.012336, 25.470941));
    }
}