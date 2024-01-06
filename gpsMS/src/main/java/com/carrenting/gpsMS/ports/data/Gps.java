package com.carrenting.gpsMS.ports.data;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "gps_tracking")
public class Gps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackingID")
    private Integer trackingId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "carID")
    private Integer carId;
    private Date timestamp;
    private String location;

    public int getCarId() {
        return carId;
    }
}
