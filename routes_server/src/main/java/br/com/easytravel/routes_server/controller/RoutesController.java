package br.com.easytravel.routes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("routes")
public class RoutesController {

    @GetMapping
    public void listenToRoute() {

    }

}
