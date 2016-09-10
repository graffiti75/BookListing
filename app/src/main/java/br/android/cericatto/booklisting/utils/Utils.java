package br.android.cericatto.booklisting.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import br.android.cericatto.booklisting.R;

/**
 * Utils.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class Utils {

    //--------------------------------------------------
    // Dialog Methods
    //--------------------------------------------------

    public static Boolean hasConnection(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        Boolean hasConnection = connectivityManager.getActiveNetworkInfo() != null;
        return hasConnection;
    }

    public static void callLostConnectionDialog(Activity activity) {
        new MaterialDialog.Builder(activity)
                .title(activity.getString(R.string.dialog__lost_connection_title))
                .content(activity.getString(R.string.dialog__lost_connection_message))
                .positiveText(activity.getString(R.string.dialog__ok))
                .show();
    }

    //--------------------------------------------------
    // String Methods
    //--------------------------------------------------

    public static Boolean isEmpty(String text) {
        Boolean result = true;
        Boolean isNull = (text == null);
        if (!isNull) {
            Boolean isZeroLength = (text.length() <= 0);
            Boolean isEmpty = (text.equals(""));
            Boolean contentOfTextIsLiteralNull = (text.equals("null"));
            result = isNull || isZeroLength || isEmpty || contentOfTextIsLiteralNull;
        }
        return result;
    }

    //--------------------------------------------------
    // Json Generics Methods
    //--------------------------------------------------

    public static <T extends Object> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static final <T> List<T> getListFromJson(String json) {
        Type type = new TypeToken<List<T>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}