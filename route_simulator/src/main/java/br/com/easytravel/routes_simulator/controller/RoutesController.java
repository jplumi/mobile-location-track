package br.com.easytravel.routes_simulator.controller;

import br.com.easytravel.routes_simulator.model.BusStop;
import br.com.easytravel.routes_simulator.model.Location;
import br.com.easytravel.routes_simulator.model.RouteRequestMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("init")
public class RoutesController {

    private final KafkaTemplate<String, Location> kafkaTemplate;

    public RoutesController(KafkaTemplate<String, Location> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public synchronized void sendRouteMesssages(@RequestBody RouteRequestMessage requestMessage)
            throws InterruptedException {
        List<Location> locations = readLocationsFile(requestMessage.getRouteId());
        for (Location location : locations) {
            kafkaTemplate.send("routes", location);
            wait(250);
        }
    }

    private List<Location> readLocationsFile(String fileNumber) {
        List<Location> locations = new ArrayList<>();
        try {
            File file = new File(
                    "D:\\Documents\\easytravel\\easytravel-backend\\route_simulator\\src\\destinations\\"
                            + fileNumber + ".txt");
            Scanner sc = null;
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                double lat = Double.parseDouble(line[0]);
                double lng = Double.parseDouble(line[1]);
                locations.add(new Location("busao", lat, lng));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR READING FILE: " + e.getMessage());
        }

        return locations;
    }

}
