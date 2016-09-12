package com.example.elderly.simplelauncher;

/**
 * Created by nicha on 9/12/16.
 */
public class MailAndMediaModel implements  java.io.Serializable {

    // Table 'tb_mail'
    public String strSender;
    public String strReceiver;
    public String strSubject;
    public String strTimeStamp;
    public String strMediaID;
    public String strFlag;

    // Table 'tb_media'
    public String strFileName;
    public String strDescription;
    public String strMediaType;

    public String getStrSender() {
        return strSender;
    }

    public void setStrSender(String strSender) {
        this.strSender = strSender;
    }

    public String getStrSubject() {
        return strSubject;
    }

    public void setStrSubject(String strSubject) {
        this.strSubject = strSubject;
    }

    public String getStrTimeStamp() {
        return strTimeStamp;
    }

    public void setStrTimeStamp(String strTimeStamp) {
        this.strTimeStamp = strTimeStamp;
    }

    public String getStrMediaID() {
        return strMediaID;
    }

    public void setStrMediaID(String strMediaID) {
        this.strMediaID = strMediaID;
    }

    public String getStrFlag() {
        return strFlag;
    }

    public void setStrFlag(String strFlag) {
        this.strFlag = strFlag;
    }

    public String getStrFileName() {
        return strFileName;
    }

    public void setStrFileName(String strFileName) {
        this.strFileName = strFileName;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public String getStrMediaType() {
        return strMediaType;
    }

    public void setStrMediaType(String strMediaType) {
        this.strMediaType = strMediaType;
    }

    public String getStrReceiver() {
        return strReceiver;
    }

    public void setStrReceiver(String strReceiver) {
        this.strReceiver = strReceiver;
    }

}
