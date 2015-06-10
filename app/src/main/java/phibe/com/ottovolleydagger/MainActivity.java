package phibe.com.ottovolleydagger;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.squareup.otto.Subscribe;

import phibe.com.ottovolleydagger.events.OnVolleyErrorEvent;
import phibe.com.ottovolleydagger.events.OnVolleyResultEvent;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "OttoVolleyDagger";
//    InternetConnectivityManager internetConnectivityManager;
    private static final String REQUEST_TAG = MainActivity.class.getName();
//    private Thread randomWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "##################### onCreate");
        setContentView(R.layout.activity_main);
        //Register OttoBus
        OttoBus.getInstance().register(this);

//        internetConnectivityManager= new InternetConnectivityManager(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "##################### onPause");
        OttoBus.getInstance().unregister(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void onVolleyResult(OnVolleyResultEvent event) {
       // TextView textView= (TextView) findViewById(R.id.request_result_textView);
        getResultTextView().setText(event.result.toString());
    }

    @Subscribe
    public void onVolleyError(OnVolleyErrorEvent event) {
        //TextView textView= (TextView) findViewById(R.id.request_result_textView);
        getResultTextView().setText(event.message);
    }

    private TextView getResultTextView(){
        return (TextView) findViewById(R.id.request_result_textView);

    }

    public void onSendRequestClicked(View view) {
        //String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk";

        if (view.getId() == R.id.send_request_button) {
            Log.d(TAG, "--------- Send request button clicked");
            InternetConnectivityManager internetConnectivityManager= new InternetConnectivityManager(this);
            internetConnectivityManager.makeRequest("http://api.openweathermap.org/data/2.5/weather?q=London,uk", REQUEST_TAG);
        }
    }

//
//    public void onStopClicked(View view) {
//        if (view.getId() == R.id.stop_button) {
//            Log.d(TAG, "Stop Service Button clicked");
//            stopGenerating();
//        }
//    }

//    public void updateResults(String results) {
//        getResultsTextView().setText(results);
//    }

}
