package phibe.com.ottovolleydagger;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bmakworo on 22/05/2015.
 */
public class RestaurantsJSONObjectResquest extends JsonObjectRequest{

    public RestaurantsJSONObjectResquest(int method, String url, JSONObject jsonRequest,Response.Listener<JSONObject> listener,Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        //add our custom headers
        headers.put("Accept-Tenant", "uk");
        headers.put("Accept-Language", "en-GB");
        headers.put("Authorization", "Basic VGVjaFRlc3RBUEk6dXNlcjI=");
        headers.put("Host","api-interview.just-eat.com");
        return headers;
    }

    @Override
    public RetryPolicy getRetryPolicy() {
        return super.getRetryPolicy();
    }
}
