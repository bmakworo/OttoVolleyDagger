package phibe.com.ottovolleydagger;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bmakworo on 27/05/2015.
 */
public class Utils {

    public static String readJsonDataFromFile(String filename) throws IOException {
        System.out.println("------------- Reading JSON data from file ");
        BufferedReader bufferedReader;
        String inputString;
        StringBuffer stringBuffer = new StringBuffer();

        File file = new File(filename);

        bufferedReader = new BufferedReader(new FileReader(file));
        while ((inputString = bufferedReader.readLine()) != null) {
            stringBuffer.append(inputString);
        }
        return stringBuffer.toString();
    }
}
