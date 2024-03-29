package com.tdd.groupchat;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.core.session.Configuration;
import co.chatsdk.firebase.FirebaseModule;
import co.chatsdk.firebase.file_storage.FirebaseFileStorageModule;
import co.chatsdk.ui.manager.InterfaceManager;
import co.chatsdk.ui.manager.UserInterfaceModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();

// Create a new configuration
        Configuration.Builder builder = new Configuration.Builder(context);

// Perform any configuration steps (optional)
        builder.firebaseRootPath("prod");

// Initialize the Chat SDK
        ChatSDK.initialize(builder.build());
        UserInterfaceModule.activate(context);

// Activate the Firebase module
        FirebaseModule.activate();

// File storage is needed for profile image upload and image messages
        FirebaseFileStorageModule.activate();
        InterfaceManager.shared().a.startLoginActivity(context, true);
    }
}
