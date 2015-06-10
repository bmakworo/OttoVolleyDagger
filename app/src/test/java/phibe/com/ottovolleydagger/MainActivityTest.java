package phibe.com.ottovolleydagger;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

//import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowConnectivityManager;
import org.robolectric.shadows.ShadowNetworkInfo;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bmakworo on 25/05/2015.
 */

@Config(constants = BuildConfig.class, emulateSdk = 21)
//@RunWith(RobolectricTestRunner.class)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private MainActivity mMainActivity;
//    private EditText postCodeEdit;
//    private ImageButton currentLocationBtn;
//    private Button searchBtn;
//    private TextView mResultTextView;
//    private static final int MOBILE = ConnectivityManager.TYPE_MOBILE;
    private static final int WIFI = ConnectivityManager.TYPE_WIFI;
    private Application app;
    private ConnectivityManager connectivityManager;
    private ShadowConnectivityManager shadowConnectivityManager;
    private static String jSonString;
    private static final String jSonStringNoRoot =" {\"coord\":{\"lon\":-0.13,\"lat\":51.51}," +
            "\"sys\":{\"message\":0.1023,\"country\":\"GB\",\"sunrise\":1432698779,\"sunset\":1432756942}," +
            "\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]," +
            "\"base\":\"stations\"," +
            "\"main\":{\"temp\":289.596,\"temp_min\":289.596,\"temp_max\":289.596,\"pressure\":1023.14,\"sea_level\":1030.87,\"grnd_level\":1023.14,\"humidity\":53}," +
            "\"wind\":{\"speed\":4.01,\"deg\":257.007},\"clouds\":{\"all\":92},\"dt\":1432751397,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
    //private static String MALFORMED_DATA_FILE= "JustEat4_No_Root.txt";
    private static String DATA_FILE= "JustEat4.txt";

    private static final String TAG = "JustEat";
 //   @Mock CustomAdapter customAdapter;

    @BeforeClass
    public static void before()throws Exception{
        String testFilePath= System.getProperty("user.dir")+File.separator+"data"+File.separator+DATA_FILE;
        System.out.println("Test File path : " + testFilePath);
        jSonString=Utils.readJsonDataFromFile(testFilePath);
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
//         mMainActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();//works when code initialising googleClient is commented out
        //  mMainActivity = Robolectric.setupActivity(MainActivity.class);

        //test that my views exist
//        postCodeEdit = (EditText) mMainActivity.findViewById(R.id.editText);
//        searchBtn = (Button) mMainActivity.findViewById(R.id.button);
//        currentLocationBtn = (ImageButton) mMainActivity.findViewById(R.id.current_location_button);
//        mResultTextView = (TextView) mMainActivity.findViewById(R.id.result_textView);
//        mRecyclerView = (RecyclerView) mMainActivity.findViewById(R.id.recycler_view);

        app = RuntimeEnvironment.application;
        System.out.println("------------ app: " + app.getPackageName());
        connectivityManager = (ConnectivityManager) app.getSystemService(Context.CONNECTIVITY_SERVICE);
        shadowConnectivityManager = Shadows.shadowOf(connectivityManager);

    }

    @Test
    public void testPreconditions() throws Exception {
        assertNotNull(mMainActivity);
//        assertNotNull(postCodeEdit);
//        assertNotNull(searchBtn);
//        assertNotNull(currentLocationBtn);
//        assertNotNull(mResultTextView);
//        assertNotNull(mRecyclerView);
        assertNotNull(app);
        assertNotNull(connectivityManager);
    }

    @Test
    public void savedBundleShouldNotContainRestaurantObjectList() throws Exception {

  //      GoogleApiClient mockApiClient= mock(GoogleApiClient.class);

 //       when(mockApiClient.connect()).thenReturn(false);

 //       MainActivity mockMainActivity= mock(MainActivity.class);
  //      RestaurantObject object = mock(RestaurantObject.class);

 //       when(object.someDummyMethod()).thenReturn(false);
//        mMainActivity.onSaveInstanceState(new Bundle());
//        System.out.println("------------ someDummyMethod(): " + object.someDummyMethod());
//
//        when(object.someDummyMethod()).thenReturn(true);
//        mMainActivity.onSaveInstanceState(new Bundle());
//        System.out.println("------------ someDummyMethod(): " + object.someDummyMethod());

//        System.out.println("------------ about to call app.startActivity");
         //       when(mockMainActivity.hasRestaurants()).thenReturn(true);
//         app.startActivity(new Intent(app.getApplicationContext(), MainActivity.class));

 //       System.out.println("------------ about to recreate mMainActivity");
//        Shadows.shadowOf(mMainActivity).recreate();

        Bundle bundle= new Bundle();
        bundle.putString("one", "this is one");
 //       mMainActivity.onSaveInstanceState(new Bundle());

 //       Sh
//mMainActivity.onRestoreInstanceState();
       mMainActivity=Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().saveInstanceState(new Bundle()).stop().destroy().get();
//        verify(mockMainActivity).hasRestaurants();
       // Shadows.shadowOf(app).getResources().getConfiguration().setTo(C);
     //   mMainActivity.s

//       int currentOrientation= app.getResources().getConfiguration().orientation;
//        System.out.println("------------ Orientation before: " + currentOrientation);
//        boolean isPortraitOrUndefined = currentOrientation == Configuration.ORIENTATION_PORTRAIT || currentOrientation == Configuration.ORIENTATION_UNDEFINED;
//        int toOrientation = isPortraitOrUndefined ? Configuration.ORIENTATION_LANDSCAPE : Configuration.ORIENTATION_PORTRAIT;
//       app.getResources().getConfiguration().orientation= toOrientation;
//        System.out.println("------------ Orientation after: " +  app.getResources().getConfiguration().orientation);
//        System.out.println("------------ hasRestaurants(): " + mMainActivity.hasRestaurants());
    }

    @Test
    public void testGoogleApiClientConnectedAfterOnStart() throws Exception {
//        mMainActivity.onStart();
//        assertTrue(mMainActivity.googleApiClientConnected());
        fail("Not yet implemented");
    }

    @Test
    public void googleApiClientDisconnectedRequestsCancelledOnStop() throws Exception {
//        mMainActivity.onStop();
//        assertFalse(mMainActivity.googleApiClientConnected());
        //assertTrue(mMainActivity.googleApiClientConnected());
        fail("Not yet implemented");
    }

//    @Test
//    public void parserReturnNullWhenInvalidParameter() throws Exception {
//        JSONObject obj=null;
//        List<RestaurantObject> list= MainActivity.parseJsonResponse(obj);
//        assertNull(list);
//
//        list= MainActivity.parseJsonResponse(jSonStringNoRoot);
//        assertNull("list should be null.", list);
//    }

//    @Test
//    public void parserReturnListOfRestaurantObjects() throws Exception {
//        List<RestaurantObject> list= MainActivity.parseJsonResponse(jSonString);
//        assertNotNull("list should be not be null", list);
//        assertFalse("list should be not be empty.", list.isEmpty());
//    }

    @Test
    public void parserMissingNodes() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testNetworkAvailability() throws Exception {
        int currentNetwork = WIFI;

        setNetwork(currentNetwork,  getDisconnectedShadowNetworkInfo(currentNetwork));
        assertFalse("Should not be connected.", getInfoActiveNetworks().isConnected());

        setNetwork(currentNetwork, getConnectedShadowNetworkInfo(currentNetwork));
        assertTrue("Should be connected.", getInfoActiveNetworks().isConnected());
    }

//    @Test
//    public void shouldShowAlertWhenNetworkNotAvailable() throws Exception {
//        int currentNetwork = WIFI;
//
//        setNetwork(currentNetwork,  getDisconnectedShadowNetworkInfo(currentNetwork));
//        assertFalse("Should not be connected.", getInfoActiveNetworks().isConnected());
//
//        mMainActivity.sendRequest("SR4 2RP", false);
//
//        Fragment dialogFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("no_network");
//        assertNotNull(dialogFragment);
//    }

    @Test
//    public void shouldNotShowAlertWhenNetworkAvailable() throws Exception {
//
//        int currentNetwork= WIFI;
//
//        setNetwork(currentNetwork,  getConnectedShadowNetworkInfo(currentNetwork));
//        assertTrue("Should be connected.", getInfoActiveNetworks().isConnected());
//
//        mMainActivity.sendRequest(" ", false);
//
//        Fragment dialogFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("no_network");
//        assertNull(dialogFragment);
//    }

    private void setNetwork(int current, NetworkInfo info){
        shadowConnectivityManager.setNetworkInfo(current, info);
        shadowConnectivityManager.setActiveNetworkInfo(info);
    }

    private NetworkInfo getInfoActiveNetworks(){
        NetworkInfo activeNetworkInfo=((ConnectivityManager) mMainActivity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        System.out.println("------------ Active network type: " + activeNetworkInfo.getType() + " isConnected: " + activeNetworkInfo.isConnected());
        return activeNetworkInfo;
    }

    private NetworkInfo getConnectedShadowNetworkInfo(int networkType){
        NetworkInfo info=ShadowNetworkInfo.newInstance(NetworkInfo.DetailedState.CONNECTED, networkType, networkType, true, true);
        System.out.println("------------ ShadowNetworkInfo Connected Type: " + info.getType() + " isConnected: " + info.isConnected());
        return info;
    }


    private NetworkInfo getDisconnectedShadowNetworkInfo(int networkType){
        NetworkInfo info= ShadowNetworkInfo.newInstance(NetworkInfo.DetailedState.DISCONNECTED, networkType, networkType, false, false);
        System.out.println("------------ ShadowNetworkInfo Disconnected Type: " + info.getType() + " isConnected: " + info.isConnected());
        return info;
    }

//    @Test
//    public void showAlertWhenPostCodeEmptyOrNull() throws Exception {
//        //make sure we have connection as method will return at isNetworkAvailable if no connection is available
//
//        assertTrue(((ConnectivityManager) mMainActivity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo().isConnected());
//        mMainActivity.sendRequest(" ", false);
//
//        Fragment dialogFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("postcode_empty");
//        assertNotNull(dialogFragment);
//    }
//
//    @Test
//    public void shouldNotshowAlertWhenPostCodeHasValue() throws Exception {
//        //make sure we have connection as method will return at isNetworkAvailable if no connection is available
//
//        assertTrue(((ConnectivityManager) mMainActivity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo().isConnected());
//        mMainActivity.sendRequest("sr4 7rp ", false);
//
//        Fragment dialogFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("postcode_empty");
//        assertNull(dialogFragment);
//    }


    @After
    public void tearDown() throws Exception {
        Shadows.shadowOf(mMainActivity).finish();
    }
}