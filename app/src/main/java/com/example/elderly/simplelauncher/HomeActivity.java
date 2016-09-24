package com.example.elderly.simplelauncher;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.PrivateKey;
import java.util.ArrayList;


public class HomeActivity extends Activity {

    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;

    private TextView notiTopic;
    private TextView notiDetail;
    private ArrayList<String> notiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        notiTopic = (TextView)findViewById(R.id.noti_title);
        notiDetail = (TextView)findViewById(R.id.noti_detail);

        popupWindow();

        notiData = new ArrayList<String>();

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    URL url = new URL("http://dlab.sit.kmutt.ac.th/el_launcher/unreadMessages.php");

                    HttpClient client = new DefaultHttpClient();
                    HttpGet request = new HttpGet();
                    request.setURI(new URI(""));

                    URLConnection urlConnection = url.openConnection();

                    HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    InputStream inputStream = null;

                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                        inputStream = httpURLConnection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);

                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;

                    while ((line=reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    inputStream.close();
                    Log.d("JSON Result", stringBuilder.toString());

                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    JSONArray exArray = jsonObject.getJSONArray("result");

                    for (int i=0; i < exArray.length(); i++) {
                        JSONObject jsonObj = exArray.getJSONObject(i);
                        notiData.add(jsonObj.getString("Topic"));
                        notiData.add(jsonObj.getString("Message"));
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute();

//        notiTopic.setText(notiData.get(2).toString());
//        notiDetail.setText(notiData.get(3).toString());

    }

    public void popupWindow() {

        // Get the application context
        mContext = getApplicationContext();

        // Get the activity
        mActivity = HomeActivity.this;

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.layout_home);
        mButton = (Button) findViewById(R.id.btnPopup);

        // Set a click listener for the text view
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.notification,null);

                /*
                    public PopupWindow (View contentView, int width, int height)
                        Create a new non focusable popup window which can display the contentView.
                        The dimension of the window must be passed to this constructor.

                        The popup does not provide any background. This should be handled by
                        the content view.

                    Parameters
                        contentView : the popup's content
                        width : the popup's width
                        height : the popup's height
                */
                // Initialize a new instance of popup window
                mPopupWindow = new PopupWindow(
                        customView,
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                // Get a reference for the custom view close button
                Button okayButton = (Button) customView.findViewById(R.id.noti_close);

                // Set a click listener for the popup window close button
                okayButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                /*
                    public void showAtLocation (View parent, int gravity, int x, int y)
                        Display the content view in a popup window at the specified location. If the
                        popup window cannot fit on screen, it will be clipped.
                        Learn WindowManager.LayoutParams for more information on how gravity and the x
                        and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
                        to specifying Gravity.LEFT | Gravity.TOP.

                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
                // Finally, show the popup window at the center location of root relative layout
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
            }
        });
    }

    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    public void showMessages(View v) {
        Intent i = new Intent(this, MessagesActivity.class);
        startActivity(i);
    }

    public void showGallery(View v) {
        Intent i = new Intent(this, GalleryActivity.class);
        startActivity(i);
    }

    public void showContacts(View v) {
        Intent i = new Intent(this, ContactsActivity.class);
        startActivity(i);
    }

    public void showCalendar(View v) {
        Intent i = new Intent(this, CalendarActivity.class);
        startActivity(i);
    }

    public void showSettings(View v) {
        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
    }

    public void popupWindow(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = ((Activity) this).getLayoutInflater();
        View alertView = inflater.inflate(R.layout.activity_popup, null);
        alertDialog.setView(alertView);
        final AlertDialog show = alertDialog.show();

        Button btnOK = (Button) alertView.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                show.dismiss();
            }
        });
    }

}
