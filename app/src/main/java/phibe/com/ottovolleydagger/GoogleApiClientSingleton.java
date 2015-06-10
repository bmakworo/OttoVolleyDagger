package phibe.com.justeattest;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by bmakworo on 29/05/2015.
 */
public class GoogleApiClientSingleton implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "JustEat";
    private GoogleApiClient mGoogleApiClient;
    private static GoogleApiClientSingleton mInstance;
    private static Context mContext;

    private GoogleApiClientSingleton(Context context) {
        //use getApplicationContext() to keep from leaking the Activity or BroadcastReceiver if someone passes one in.
        mContext = context.getApplicationContext();
        mGoogleApiClient = getGoogleApiClient();
    }


    public static synchronized GoogleApiClientSingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new GoogleApiClientSingleton(context);
        }
        return mInstance;
    }


    public GoogleApiClient getGoogleApiClient() {
        if (mGoogleApiClient == null) {

            mGoogleApiClient =  new GoogleApiClient.Builder(mContext)
                    // Optionally, add additional APIs and scopes if required.
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }
        return mGoogleApiClient;
    }

    public void connect(){
        if(!googleApiClientIsConnected()){
            getGoogleApiClient().connect();
        }
    }


    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "------------- GoogleApiClient connected");
//        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "------------ GoogleApiClient connection suspended");
        retryConnecting();
    }


    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "------------------ GoogleApiClient connection failed: " + result.toString());
        if (!result.hasResolution()) {
            retryConnecting();
            return;
        }
    }

    private void retryConnecting() {
        if (!mGoogleApiClient.isConnecting()) {
            mGoogleApiClient.connect();
        }
    }

    protected boolean googleApiClientIsConnected() {
        return mGoogleApiClient != null && mGoogleApiClient.isConnected();
    }

    protected void disconnect() {
        if (googleApiClientIsConnected()) {
            mGoogleApiClient.disconnect();
            Log.i(TAG, "------------- GoogleApiClient disconnected");
        }
    }
}
