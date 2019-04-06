package com.aditya_bhatt.utills;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressBar {
    public static ProgressDialog showProgressDialog(Context context, String message){
        ProgressDialog m_Dialog = new ProgressDialog(context);
        m_Dialog.setMessage(message);
        m_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        m_Dialog.setCancelable(false);
        m_Dialog.show();
        return m_Dialog;
    }
//    ProgressDialog myDialog= ProgressDialog.showProgressDialog(Home.this,"some message");

//    myDialog.dismiss();
}