package com.eorozco.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class TapJoyPPE extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("connect")) {

            String key = data.getString(0);
            String message = "SDK Key, " + key;
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
