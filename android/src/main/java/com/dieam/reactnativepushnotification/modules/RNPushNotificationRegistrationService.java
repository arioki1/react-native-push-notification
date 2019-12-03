package com.dieam.reactnativepushnotification.modules;

import android.app.IntentService;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.firebase.iid.FirebaseInstanceId;
public class RNPushNotificationRegistrationService extends IntentService {

    private static final String TAG = "RNPushNotification";

    public RNPushNotificationRegistrationService() {super(TAG);}

    @Override
    protected void onHandleIntent(Intent intent) {
        String SenderID = intent.getStringExtra("senderID");

        try {
            String token = FirebaseInstanceId.getInstance().getToken();
            sendRegistrationToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRegistrationToken(String token) {
        Intent intent = new Intent("RNPushNotificationRegisteredToken");
        intent.putExtra("token", token);
        sendBroadcast(intent);
    }

}