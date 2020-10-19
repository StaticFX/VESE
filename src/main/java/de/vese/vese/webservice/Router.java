package de.vese.vese.webservice;

import org.json.JSONObject;


/*
    VESE - Router
    Version: 1.0.1
    Author: Devin


 */

public abstract class Router {

    private String name;
    private Priority priority;

    public Router(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public abstract JSONObject routeRequest(String auth, String request, Object value);

}
