package com.example.elderly.simplelauncher;

/**
 * Created by nicha on 9/13/16.
 */
public class MessagesModel implements  java.io.Serializable {

    //table 'multimediadata_from_elderly'
    public String strContentID;
    public String strDateSent;
    public String strTimeSend;
    public String strMessage;
    public String strElderlyID;
    public String strAccountID;
    public String strFlag;

    public String getStrElderlyID() {
        return strElderlyID;
    }

    public void setStrElderlyID(String strElderlyID) {
        this.strElderlyID = strElderlyID;
    }

    public String getStrContentID() {
        return strContentID;
    }

    public void setStrContentID(String strContentID) {
        this.strContentID = strContentID;
    }

    public String getStrAccountID() {
        return strAccountID;
    }

    public void setStrAccountID(String strAccountID) {
        this.strAccountID = strAccountID;
    }

    public String getStrDateSent() {
        return strDateSent;
    }

    public void setStrDateSent(String strDateSent) {
        this.strDateSent = strDateSent;
    }

    public String getStrTimeSend() {
        return strTimeSend;
    }

    public void setStrTimeSend(String strTimeSend) {
        this.strTimeSend = strTimeSend;
    }

    public String getStrMessage() {
        return strMessage;
    }

    public void setStrMessage(String strMessage) {
        this.strMessage = strMessage;
    }

    public String getStrFlag() {
        return strFlag;
    }

    public void setStrFlag(String strFlag) {
        this.strFlag = strFlag;
    }
}
