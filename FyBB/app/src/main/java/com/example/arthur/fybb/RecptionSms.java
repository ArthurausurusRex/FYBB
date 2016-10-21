package com.example.arthur.fybb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;

/**
 * Created by Arthur on 21/10/2016.
 */

public class RecptionSms extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){ //On impose une action liée a un evt spécifique
        if (intent.getAction().equals("android.provider.Telephony.SMS_receives")){
            Bundle bundle = intent.getExtras(); // on recupere les infos du SMS reçu
            SmsMessage [] sms = null;

                if (bundle != null){
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    sms = new SmsMessage[pdus.length];
                    String body = "";
                    for (int i= 0; i<sms.length; i++){
                        sms[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
                        body = sms[i].getMessageBody().toString();
                    }
                }
        }


    }
}
