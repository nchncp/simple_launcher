package com.example.elderly.simplelauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicha on 9/27/16.
 */
public class MessageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MessagesModel> mArrayListMessage;

    public MessageAdapter(Context context, ArrayList<MessagesModel> arrayList){
        mContext = context;
        mArrayListMessage = arrayList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessagesModel entry = mArrayListMessage.get(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.messages_list, null);
        }

        TextView topic = (TextView)convertView.findViewById(R.id.topic);
        topic.setText(entry.getTopic());

        TextView message = (TextView)convertView.findViewById(R.id.message);
        message.setText(entry.getMessage());

        TextView timeSend = (TextView)convertView.findViewById(R.id.timeSend);
        timeSend.setText(entry.getTimeSend());

        TextView dateSend = (TextView)convertView.findViewById(R.id.dateSend);
        dateSend.setText(entry.getDateSend());

        return convertView;
    }


}
