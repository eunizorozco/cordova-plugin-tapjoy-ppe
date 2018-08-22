package org.apache.cordova.plugin;

import android.util.Log;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import com.tapjoy.TJConnectListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyConnectFlag;

import java.util.Hashtable;

public class TapJoyPPE extends CordovaPlugin {

    public static final String TAG = "TapJoyPPE";

    @Override
    protected void pluginInitialize() {
        Tapjoy.setDebugEnabled(true);
    }

    @Override
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {

        if (action.equals("connect")) {

            Hashtable<String, Object> connectFlags = new Hashtable<String, Object>();
            connectFlags.put(TapjoyConnectFlag.ENABLE_LOGGING, "true");

            String key = data.getString(0);
            String message = "SDK Key, " + key;
            callbackContext.success(message);

            Tapjoy.connect(this, key, connectFlags, new TJConnectListener() {
                @Override
                public void onConnectSuccess() {
                    Log.e(TAG, "Tapjoy connect call succeed");
                    callbackContext.success("Success");
                }

                @Override
                public void onConnectFailure() {
                    Log.e(TAG, "Tapjoy connect call failed");
                    callbackContext.error("Error");
                }
            });

            return true;

        } else {
            
            return false;

        }
    }
}
