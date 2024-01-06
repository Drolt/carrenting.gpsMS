package com.carrenting.gpsMS.ports.in;

import com.carrenting.gpsMS.ports.data.Gps;
import java.util.List;

public interface GpsManager {
    Gps createGpsRecord(Gps gps);
    List<Gps> getAllGpsLocations();
    List<Gps> getNewestGpsLocationsPerCar();
}
