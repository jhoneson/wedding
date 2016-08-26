package com.example.scxh.webviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView userNameTxt,pswtxt;
    private EditText userNameEdit,pswEdit;
    public Button mLoginBtns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        userNameTxt= (TextView) findViewById(R.id.web_user_name);
        pswtxt= (TextView) findViewById(R.id.web_psw_txt);
        userNameEdit= (EditText) findViewById(R.id.web_user_edit);
        pswEdit= (EditText) findViewById(R.id.web_psw_edit);
        mLoginBtns= (Button) findViewById(R.id.loginBtn);
        
    }
}
