package com.example.elderly.simplelauncher;

/**
 * Created by nicha on 9/15/16.
 */
import com.google.gson.annotations.SerializedName;


public class MessagesModel {
    @SerializedName("Topic")
    private String Topic;
    @SerializedName("Message")
    private String Message;
    @SerializedName("DateSend")
    private String DateSend;
    @SerializedName("TimeSend")
    private String TimeSend;

    public MessagesModel(String Topic, String Message,String DateSend,String TimeSend) {
        this.Topic = Topic;
        this.Message = Message;
        this.DateSend = DateSend;
        this.TimeSend = TimeSend;
    }

    public String getTopic() {
        return Topic;
    }
    public String getMessage() {
        return Message;
    }
    public String getDateSend() {
        return DateSend;
    }
    public String getTimeSend() {
        return TimeSend;
    }
}

