package com.example.bollez.schutdapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Bollez on 23/12/2016.
 */

public class SmsListener extends BroadcastReceiver {

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        // Als er een message binnenkomt
        if(intent.getAction().equals("android.provider.Telephony.SmsMessage")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            android.telephony.SmsMessage[] msgs = null;
            String msg_ALL;
            String msg_from;
            String msgBody;
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new android.telephony.SmsMessage[pdus.length];

                    for(int i=0; i<msgs.length; i++){
                        String format = bundle.getString("format");
                        msgs[i] = android.telephony.SmsMessage.createFromPdu((byte[])pdus[i],format);

                        msg_from = msgs[i].getOriginatingAddress();
                        msgBody = msgs[i].getMessageBody();
                        msg_ALL = "FROM:" + msg_from + "says :\n" + msgBody;

                        Log.e("SMS", msg_ALL);
                        Toast.makeText(context, msg_ALL, Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }

            }


        }
    }
}