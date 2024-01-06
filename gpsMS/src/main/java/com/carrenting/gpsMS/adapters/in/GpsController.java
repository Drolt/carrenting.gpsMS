package com.carrenting.gpsMS.adapters.in;

import com.carrenting.gpsMS.ports.data.Gps;
import com.carrenting.gpsMS.ports.in.GpsManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gps")
public class GpsController {
    private final GpsManager gpsManager;


    public GpsController(GpsManager gpsManager) {
        this.gpsManager = gpsManager;
    }

    /*{"carId": 12345,
       "location": "Latitude: -34.782804, Longitude: -118.828790"}*/
    @PostMapping
    public void createGpsRecord(@RequestBody Gps gps) {
        gpsManager.createGpsRecord(gps);
    }

    @GetMapping
    public ResponseEntity<List<Gps>> getAllGpsLocations() {
        List<Gps> gpsLocations = gpsManager.getAllGpsLocations();
        return ResponseEntity.ok(gpsLocations);
    }

    @GetMapping("/current")
    public ResponseEntity<List<Gps>> getNewestGpsLocationsPerCar() {
        List<Gps> newestGpsLocations = gpsManager.getNewestGpsLocationsPerCar();
        return ResponseEntity.ok(newestGpsLocations);
    }
}