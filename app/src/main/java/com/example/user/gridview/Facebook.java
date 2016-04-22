package com.example.user.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

public class Facebook extends AppCompatActivity {
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    ProfilePictureView friendProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_facebook);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        friendProfilePicture = (ProfilePictureView) findViewById(R.id.friendProfilePicture);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //info.setText("User ID: " + loginResult.getAccessToken().getUserId() + "\n" + "Auth Token: " + loginResult.getAccessToken().getToken());
                friendProfilePicture.setProfileId(loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {
                info.setText("Cancel Login");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Error occured while Login");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
