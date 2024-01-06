package com.carrenting.gpsMS.service;

import com.carrenting.gpsMS.ports.data.Gps;
import com.carrenting.gpsMS.ports.in.GpsManager;
import com.carrenting.gpsMS.ports.out.GpsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GpsService implements GpsManager {
    private final GpsRepository gpsRepository;

    public GpsService(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
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

    public List<Gps> getAllGpsLocations() {
        return gpsRepository.findAll();
    }

    @Override
    public List<Gps> getNewestGpsLocationsPerCar() {
        List<Gps> allGps = getAllGpsLocations();
        if (allGps != null) {
            return allGps.stream()
                    .collect(Collectors.groupingBy(
                            Gps::getCarId, // Group by carId
                            Collectors.maxBy(Comparator.comparing(Gps::getTimestamp)) // Get the latest GPS record
                    ))
                    .values()
                    .stream()
                    .filter(Optional::isPresent) // Filter out any empty optionals
                    .map(Optional::get) // Extract the Gps record from the optional
                    .collect(Collectors.toList());
        } else {
            return null;
        }

    }

}

