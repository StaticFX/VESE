package de.vese.vese.backendrouting.webservice.routers;


/*
    VESE - VESERequestRouter
    Version: 1.0.0
    Author: Devin


 */

/*
    Routing VESERequest
    VeseRequest are primitive Request which contain if the service running and other stuff like general information about the vese service

 */

import de.vese.vese.VESE;
import de.vese.vese.backendrouting.webservice.Priority;
import de.vese.vese.backendrouting.webservice.Router;
import org.json.JSONObject;

public class VESERequestRouter extends Router {

    public VESERequestRouter(String name, Priority priority) {
        super(name, priority);
    }

    @Override
    public JSONObject routeRequest(String auth, String request, Object value) {

        if(request.equalsIgnoreCase("running")) {
            return new JSONObject().append("running",true).append("version", VESE.VERSION);
        }

        return new JSONObject("error","unknownRequest");
    }

}
