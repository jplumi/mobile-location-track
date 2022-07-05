package br.com.easytravel.routes_server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

//    {"carName": "bus", "latitude": 0.0, "longitude": 1}
    private String carName;
    private double latitude;
    private double longitude;

}
