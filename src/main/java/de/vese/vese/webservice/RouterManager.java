package de.vese.vese.webservice;

import de.vese.vese.util.AuthenticationManager;
import de.vese.vese.webservice.routers.VESERequestRouter;
import org.json.JSONObject;

public class RouterManager {


    private VESERequestRouter veseRequestRouter;

    public RouterManager() {
        this.veseRequestRouter = new VESERequestRouter("VESERequestRouter",Priority.MIDDLE);

    }

    public JSONObject handleInput(String auth,String mapping, String value, Object key) {
        if(!AuthenticationManager.isValidAuth(auth)) return new JSONObject().append("error","auth");


        if(mapping.equalsIgnoreCase("request")) {
            return veseRequestRouter.routeRequest(auth,value,key);
        }


        return new JSONObject("error","unknownRequest");
    }


}
