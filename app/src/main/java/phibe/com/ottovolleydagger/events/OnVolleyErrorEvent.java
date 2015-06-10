package phibe.com.ottovolleydagger.events;

/**
 * Created by bmakworo on 10/06/2015.
 */
public class OnVolleyErrorEvent {

    public final String message;

    public OnVolleyErrorEvent(String errorMsg) {
        message = errorMsg;
    }
}
