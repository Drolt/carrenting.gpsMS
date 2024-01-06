package com.carrenting.gpsMS.service;

import com.carrenting.gpsMS.ports.data.Gps;
import com.carrenting.gpsMS.ports.in.GpsManager;
import com.carrenting.gpsMS.ports.out.GpsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GpsService implements GpsManager {
    private final GpsRepository gpsRepository;

    public GpsService(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

    // Constructor for dependency injection

    public Gps createGpsRecord(Integer carId) {
        Gps gps = new Gps();
        gps.setCarId(carId);
        gps.setTimestamp(new Date());
        gps.setLocation(generateRandomLocation()); // Implement this method
        return gpsRepository.save(gps);
    }

    private String generateRandomLocation() {
        // Latitude ranges from -90 to 90, Longitude ranges from -180 to 180
        double latitude = -90.0 + Math.random() * 180.0;
        double longitude = -180.0 + Math.random() * 360.0;

        // Format the string to a readable format (e.g., "Latitude: -34.12345, Longitude: 23.12345")
        return String.format("Latitude: %.5f, Longitude: %.5f", latitude, longitude);
    }

    @Override
    public Gps createGpsRecord(Gps gps) {
        gps.setTimestamp(new Date());
        if (gps.getLocation() == null)
            gps.setLocation(generateRandomLocation());
        return gpsRepository.save(gps);
    }
}

