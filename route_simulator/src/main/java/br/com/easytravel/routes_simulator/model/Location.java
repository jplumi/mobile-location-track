package br.com.easytravel.routes_simulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String carName;
    private double latitude;
    private double longitude;

}
