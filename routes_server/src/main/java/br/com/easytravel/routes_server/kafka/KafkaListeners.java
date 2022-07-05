package br.com.easytravel.routes_server.kafka;

import br.com.easytravel.routes_server.model.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "routes", groupId = "group01")
    public void listenRouteRequest(String message) {
        System.out.println(message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Location requestMessage = mapper.readValue(message, Location.class);
            System.out.println("Received message: " + requestMessage);
        } catch (JsonProcessingException e) {
            System.out.println("Invalid json format: " + e.getMessage());
        }
    }

}
