package br.com.easytravel.routes_simulator.kafka;

import br.com.easytravel.routes_simulator.model.RouteRequestMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

//    @KafkaListener(topics = "routes", groupId = "group01")
//    public void listenRouteRequest(String message) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            RouteRequestMessage requestMessage = mapper.readValue(message, RouteRequestMessage.class);
//            System.out.println("Received message: " + requestMessage);
//        } catch (JsonProcessingException e) {
//            System.out.println("Invalid json format: " + e.getMessage());
//        }
//    }

}
