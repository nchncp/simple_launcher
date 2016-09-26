package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by nicha on 9/16/16.
 */
public class MessagesRead extends Activity {
    private ListView jsonListview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_read);
    }

    public interface APIService {
//      @GET("stayintouch/WebApplication/examples/web/json/readMessage.php?accountid={accountid}")
//      Call<List<MessagesModel>> getMessage(@Path("accountid") String accountid);
        @GET("el_launcher/readMessages.php")
        Call<List<MessagesModel>> getMessage(@Query("accountid") String accountID);
    }

    @Override
    protected void onResume() {
        super.onResume();

        jsonListview = (ListView) findViewById(R.id.listReadMessages);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dlab.sit.kmutt.ac.th/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SharedPreferences sharedPreferences = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        final String AccountID = sharedPreferences.getString("AccountID", "");

        APIService service = retrofit.create(APIService.class);
        Call<List<MessagesModel>> call = service.getMessage(AccountID);
        call.enqueue(new Callback<List<MessagesModel>>() {
            @Override
            public void onResponse(Call<List<MessagesModel>> call, Response<List<MessagesModel>> response) {
                ArrayList<String> exData = new ArrayList<String>();
                for (MessagesModel obj : response.body()) {
                    exData.add(obj.getTopic());
                }
                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MessagesRead.this, android.R.layout.simple_list_item_1, android.R.id.text1, exData);
                jsonListview.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<MessagesModel>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}
