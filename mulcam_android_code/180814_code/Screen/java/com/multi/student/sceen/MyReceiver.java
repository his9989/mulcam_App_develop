package com.multi.student.sceen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        // Toast.makeText(context,"onReceive()",Toast.LENGTH_SHORT).show();

        Bundle bundle = intent.getExtras();
        if(bundle == null) return;
        Object[] messages = (Object[])bundle.get("pdus");
        SmsMessage[] smsMessage = new SmsMessage[messages.length];
        int n = 0;
        for(Object msg: messages){
            smsMessage[n++] = SmsMessage.createFromPdu((byte[]) msg);
        }
        Toast.makeText(context,"MyReceiver : " + smsMessage[0].getMessageBody(),Toast.LENGTH_LONG).show();
    }
}
