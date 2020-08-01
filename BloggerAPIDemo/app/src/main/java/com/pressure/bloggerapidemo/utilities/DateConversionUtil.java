package com.pressure.bloggerapidemo.utilities;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateConversionUtil {

    //converting date to String
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
    //Parsing the given String to Date object
    DateFormat innputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public String dateConversion(String input) {
        try {
            return outputFormat.format(innputFormat.parse(input));
        } catch (Exception e) {
            Log.d("Format Exception", e.toString());
        }
        return input;
    }
}
