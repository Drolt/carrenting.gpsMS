package com.carrenting.gpsMS.ports.out;

import com.carrenting.gpsMS.ports.data.Gps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GpsRepository extends JpaRepository<Gps, Integer> {
}
