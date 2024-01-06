package com.carrenting.gpsMS.ports.in;

import com.carrenting.gpsMS.ports.data.Gps;

public interface GpsManager {
    Gps createGpsRecord(Gps gps);
}
