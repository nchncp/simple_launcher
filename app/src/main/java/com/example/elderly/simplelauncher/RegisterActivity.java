package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicha on 10/24/16.
 */

public class RegisterActivity extends Activity {

    EditText Username, Password, FName, LName, Email, PhoneNum;
    Button btnRegister;
    RequestQueue requestQueue;
    String insertUrl = "http://dlab.sit.kmutt.ac.th/el_launcher/regis.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = (EditText)findViewById(R.id.Username);
        Password = (EditText)findViewById(R.id.Password);
        FName = (EditText)findViewById(R.id.FName);
        LName = (EditText)findViewById(R.id.LName);
        Email = (EditText)findViewById(R.id.Email);
        PhoneNum = (EditText)findViewById(R.id.PhoneNum);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map <String,String> parameters = new HashMap<String, String>();
                        parameters.put("Username",Username.getText().toString());
                        parameters.put("Password",Password.getText().toString());
                        parameters.put("FName",FName.getText().toString());
                        parameters.put("LName",LName.getText().toString());
                        parameters.put("Email",Email.getText().toString());
                        parameters.put("PhoneNum",PhoneNum.getText().toString());

                        return parameters;
                    }
                };

                requestQueue.add(request);


            }
        });
    }
}
