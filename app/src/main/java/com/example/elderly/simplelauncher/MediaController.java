package com.example.elderly.simplelauncher;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by nicha on 9/12/16.
 */
public class MediaController {

    private final String TAG = "MediaController";
    private final static String strURL = "http://www.argong.com/TVAppController/get_media.php";
    private String strURLParams;
    private Context myContext;
    public ArrayList<String> listNumber;
    public ArrayList<MailAndMediaModel> listMailAndMediaModel;
    public ArrayList<MailAndMediaModel> getListMailAndMediaModel()
    {
        return  listMailAndMediaModel;
    }

    public String search(Context context, String strEmail, String strMediaType)
    {
        String strResult = "";
        String strAction = "select";

        //Description: strMailType are 'image', 'text', 'sound', 'video'
        String strType = strMediaType;
        myContext = context;
        try{
            StringBuffer strBuff = new StringBuffer();
            strBuff.append(URLEncoder.encode("strAction", "UTF-8") + "=" + strAction);
            strBuff.append(URLEncoder.encode("&strType", "UTF-8") + "=" + strType);
            strBuff.append(URLEncoder.encode("&strEmail", "UTF-8") + "=" + strEmail);

            strURLParams = strBuff.toString().replace("%26","&");
            Log.d(TAG, "strURLParams = " + strURLParams);

            SendfeedbackJob job = new SendfeedbackJob();
            strResult = job.execute(strURLParams).get();

            listMailAndMediaModel = job.getListModel();
            if(listMailAndMediaModel != null){
                Log.d(TAG, "listMailAndMediaModel Size = " + listMailAndMediaModel.size());
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return strResult;
    }//END search()

    private class SendfeedbackJob extends AsyncTask<String, Void, String>
    {
        MailAndMediaModel model;
        ArrayList<MailAndMediaModel> listModel;
        public ArrayList<MailAndMediaModel> getListModel()
        {
            return  listModel;
        }
        @Override
        protected String doInBackground(String[] params)
        {
            try {
                ServerConnection serverConn = new ServerConnection();
                String strResult = serverConn.runHttpPost(strURL+"?"+params[0], strURLParams);

                //==================================================================================
                try {
                    if(!strResult.trim().equals(""))
                    {
                        Log.d(TAG, "strResult = " + strResult);

                        listModel = new ArrayList<MailAndMediaModel>();
                        JSONArray jsonArray = new JSONArray(strResult.toString());
                        Log.d(TAG, "jsonArray length: "+String.valueOf(jsonArray.length()));
                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            JSONObject objJson = jsonArray.getJSONObject(i);

                            String strTimeStamp = "";
                            if(objJson.getString("TIMESTAMP") != null) strTimeStamp = objJson.getString("TIMESTAMP");

                            String strSender = "";
                            if(objJson.getString("SENDER") != null) strSender = objJson.getString("SENDER");

                            String strReceiver = "";
                            if(objJson.getString("RECEIVER") != null) strReceiver = objJson.getString("RECEIVER");

                            String strSubject = "";
                            if(objJson.getString("SUBJECT") != null) strSubject = objJson.getString("SUBJECT");

                            String strMediaID = "";
                            if(objJson.getString("MEDIAID") != null) strMediaID = objJson.getString("MEDIAID");

                            String strFlag = "";
                            if(objJson.getString("FLAG") != null) strFlag = objJson.getString("FLAG");

                            String strFilename = "";
                            if(objJson.getString("FILENAME") != null) strFilename = objJson.getString("FILENAME");

                            String strDescription = "";
                            if(objJson.getString("DESCRIPTION") != null) strDescription = objJson.getString("DESCRIPTION");

                            String strMediaType = "";
                            if(objJson.getString("MEDIA_TYPE") != null) strMediaType = objJson.getString("MEDIA_TYPE");

                            model = new MailAndMediaModel();
                            model.setStrTimeStamp(strTimeStamp);
                            model.setStrSender(strSender);
                            model.setStrReceiver(strReceiver);
                            model.setStrSubject(strSubject);
                            model.setStrMediaID(strMediaID);
                            model.setStrFlag(strFlag);
                            model.setStrFileName(strFilename);
                            model.setStrDescription(strDescription);
                            model.setStrMediaType(strMediaType);
                            listModel.add(model);
                        }//[END for loop]
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Exception error: "+e.getLocalizedMessage());
                    return  "false";
                }
            }catch(Exception ex){
                ex.printStackTrace();
                Log.e(TAG, "Exception error: "+ex.getLocalizedMessage());
            }
            return  "true";
        }// [END doInBackground()]

        @Override
        protected void onPostExecute(String message) {} // [END onPostExecute()]


    }// [END SendfeedbackJob()]

}
