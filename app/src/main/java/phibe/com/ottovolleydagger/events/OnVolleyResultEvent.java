package phibe.com.ottovolleydagger.events;

import org.json.JSONObject;

/**
 * Created by bmakworo on 10/06/2015.
 */
public class OnVolleyResultEvent {
    public final JSONObject result;

    public OnVolleyResultEvent(JSONObject volleyResult) {
        result = volleyResult;
    }

}
