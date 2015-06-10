package phibe.com.ottovolleydagger;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.otto.Bus;

import org.json.JSONObject;

import phibe.com.ottovolleydagger.events.OnVolleyErrorEvent;
import phibe.com.ottovolleydagger.events.OnVolleyResultEvent;

/**
 * Created by bmakworo on 10/06/2015.
 */
public class InternetConnectivityManager implements Response.Listener<JSONObject>, Response.ErrorListener{

    private static final String TAG = "OttoVolleyDagger";
    private boolean connected;
    private RequestQueue mRequestQueue;
    private static Context mContext;
    private JsonObjectRequest mJsonRequest;

    public InternetConnectivityManager(Context context){
        mContext=context.getApplicationContext();
    }

    private boolean isNetworkAvailable() {
        final ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    //TODO create enum with API call endpoints

    public void makeRequest(String url, String tag) {
        if(!isNetworkAvailable()){
            OttoBus.getInstance().post(new OnVolleyErrorEvent("No Network"));
            return;
        }

        Log.d(TAG, "------------ makeRequest");
        mJsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
 //       mJsonRequest.setTag(tag);

        // Add request to the RequestQueue.
        getRequestQueue().add(mJsonRequest);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            //use getApplicationContext() to keep from leaking the Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext);
        }

        return mRequestQueue;
    }

 //   public <T> void addToRequestQueue(Request<T> req) {
//        getRequestQueue().add(req);
//    }

    public void cancelAllRequests(String tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.d(TAG, "------------ onErrorResponse: "+volleyError.getMessage());
        OttoBus.getInstance().post(new OnVolleyErrorEvent(volleyError.getMessage()));
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        Log.d(TAG, "------------ onResponse: "+ jsonObject.toString());
        OttoBus.getInstance().post(new OnVolleyResultEvent(jsonObject));
    }

}
