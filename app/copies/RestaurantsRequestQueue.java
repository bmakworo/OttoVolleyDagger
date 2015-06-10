package phibe.com.justeattest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by bmakworo on 22/05/2015.
 */
public class RestaurantsRequestQueue {

    private static RestaurantsRequestQueue mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private RestaurantsRequestQueue(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RestaurantsRequestQueue getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RestaurantsRequestQueue(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            //use getApplicationContext() to keep from leaking the Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void cancelAllRequests(String tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
