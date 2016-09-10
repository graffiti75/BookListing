package br.android.cericatto.booklisting.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.android.cericatto.booklisting.R;
import br.android.cericatto.booklisting.utils.Utils;

/**
 * GetDataAsyncTask.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class GetDataAsyncTask extends AsyncTask<Object, Void, String> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private Activity mActivity;
    private String mUrl;
    private LinearLayout mProgressBarLinearLayout;

    //--------------------------------------------------
    // Async Task
    //--------------------------------------------------

    @Override
    protected String doInBackground(Object... params) {
        // Params.
        mActivity = (Activity)params[0];
        mUrl = (String)params[1];
        mProgressBarLinearLayout = (LinearLayout)params[2];

        // Get data.
        String result = "";
        if (!Utils.hasConnection(mActivity)) {
            Utils.callLostConnectionDialog(mActivity);
        } else {
            result = readStream();
        }

        return result;
    }

    //--------------------------------------------------
    // Bitmap Methods
    //--------------------------------------------------

    private String readStream() {
        HttpURLConnection urlConnection = null;
        String result = "";
        URL url;
        try {
            url = new URL(mUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                result = readStream(in);
            } else {
                mProgressBarLinearLayout.setVisibility(View.GONE);
                Toast.makeText(mActivity, mActivity.getString(R.string.no_connection), Toast.LENGTH_LONG).show();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return result;
    }

    private String readStream(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}