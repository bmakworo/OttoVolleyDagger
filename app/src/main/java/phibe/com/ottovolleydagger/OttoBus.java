package phibe.com.ottovolleydagger;

import com.squareup.otto.Bus;

/**
 * Created by bmakworo on 10/06/2015.
 */
public class OttoBus {
    private static Bus instance;

    private OttoBus(){}

    public static Bus getInstance(){
        if(instance == null){
            instance= new Bus();
        }
        return instance;
    }
}
