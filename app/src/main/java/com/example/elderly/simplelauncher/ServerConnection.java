package com.example.elderly.simplelauncher;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by nicha on 9/12/16.
 */
public class ServerConnection {

    private static String TAG = "ServerConnection";

    private HttpURLConnection httpURLConn = null;
    public String runHttpPost(String strURL, String strURLParams)
    {
        int reConnectCount=0;
        String strResult = "";
        InputStream inputStream = null;
        DataOutputStream dataOutputStream = null;
        BufferedWriter writer = null;
        try{
            try {
                Log.d(TAG, "===================================================");
                Log.d(TAG, "INPUT strURL: " + strURL);
                Log.d(TAG, "INPUT strURLParams: " + strURLParams);
                // To connect web server and config settings
                URL url = new URL(strURL);
                httpURLConn = (HttpURLConnection) url.openConnection();
                httpURLConn.setRequestMethod("POST");
                httpURLConn.setConnectTimeout(6 * 1000);
                httpURLConn.setReadTimeout(10 * 1000);
                httpURLConn.setUseCaches(false);
                httpURLConn.setDoInput(true);
                httpURLConn.setDoOutput(true);
                httpURLConn.setUseCaches(false);
                httpURLConn.setRequestProperty("Accept", "application/json");
                httpURLConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

                httpURLConn.connect();

                //POST data to Web Server
                OutputStream outputStream = httpURLConn.getOutputStream();
                writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(strURLParams);
                writer.flush();

                int response = httpURLConn.getResponseCode();
                Log.d(TAG, "HTTP response is " + response);

                if (response == HttpsURLConnection.HTTP_OK) {
                    inputStream = httpURLConn.getInputStream();
                    strResult = convertInputStreamToString(inputStream);
                    Log.d(TAG, "runHttpPost() strResult: " + strResult);
                }

            }catch (IOException e) {

                  /*  if (reConnectCount <= 10) {
                        reConnectCount++;
                        strResult = runHttpPost(strURL,strURLParams);
                    } else {
                        //jsonResponse.put("status", "No Internet Connection");
                        //jsonResponse.put("message", "Please check your Internet connection and try again");
                    }*/

            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e(TAG, "Exception runHttpPost() error: " + e.getLocalizedMessage());
        }finally {
            try {
                if(dataOutputStream != null){
                    dataOutputStream.close();
                }

                if(inputStream != null){
                    inputStream.close();
                }

                if(httpURLConn != null){
                    httpURLConn.disconnect();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }// [END runHttpPost()]

    public String convertInputStreamToString(InputStream inputStream)
    {
        StringBuffer strBuffer = new StringBuffer();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                strBuffer.append(line);
                strBuffer.append("\n");
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e(TAG, "Exception convertInputStreamToString() error: " + e.getLocalizedMessage());
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strBuffer.toString();
    }// [END convertInputStreamToString()]

}
