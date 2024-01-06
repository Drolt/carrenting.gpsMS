package com.carrenting.gpsMS.adapters.in;

import com.carrenting.gpsMS.ports.data.Gps;
import com.carrenting.gpsMS.ports.in.GpsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}