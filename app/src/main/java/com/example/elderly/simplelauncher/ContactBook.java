package com.example.elderly.simplelauncher;

import android.graphics.Bitmap;

/**
 * Created by nicha on 9/26/16.
 */
public class ContactBook {

    private Bitmap mAvatar;
    private String mName;
    private String mPhone;
    private String mEmail;

    public ContactBook(Bitmap mAvatar, String mName, String mPhone, String mEmail) {
        this.mAvatar = mAvatar;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mEmail = mEmail;
    }

    public Bitmap getmAvatar() {
        return mAvatar;
    }
    public String getmName() {
        return mName;
    }
    public String getmPhone() {
        return mPhone;
    }
    public String getmEmail() {
        return mEmail;
    }
    public void setmAvatar(Bitmap mAvatar) {
        this.mAvatar = mAvatar;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

}
