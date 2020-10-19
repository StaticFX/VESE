package de.vese.vese.webservice;

import de.vese.vese.VESE;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    VESE WebServiceApplication
    Version: 1.0.0
    Author: Devin
    Alias: StaticRed

 */


@SpringBootApplication
@RestController
public class WebServiceApplication {

    @GetMapping("/request")
    public String request(@RequestParam(defaultValue = "true", value = "running",required = false)boolean running, @RequestParam(value = "auth") String auth) {
        return VESE.routingManger.handleInput(auth,"request","running",running).toString();
    }
}
