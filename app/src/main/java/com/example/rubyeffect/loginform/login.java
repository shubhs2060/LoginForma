package com.example.rubyeffect.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class login extends AppCompatActivity {
    Button login;
    EditText email,password;
    Button register,test,browser,wallpaper ;
    private static final String TAG = "login";

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        login = (Button)findViewById(R.id.login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        register = (Button)findViewById(R.id.register);
        test = (Button)findViewById(R.id.test);
        browser = (Button)findViewById(R.id.browser);
//        wallpaper = (Button) findViewById(R.id.wallpaper);
//        wallpaper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent b = new Intent(getApplicationContext(),wallpaper.class);
//                startActivity(b);
//                finish();
//            }
//        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),REBrowser.class);
                startActivity(b);
                finish();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),Dob.class);
                startActivity(b);
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(getApplicationContext(),Reg.class);
                startActivity(a);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validEmail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";
                String testEmail = email.getText().toString();
                Matcher matcher = Pattern.compile(validEmail).matcher(testEmail);
                if (matcher.matches()){
                    Toast.makeText(getApplicationContext(),"Valid Email",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrect email",Toast.LENGTH_LONG).show();
                    if(password.getText().toString().equals("")){
                        password.setError("Enter a password");
                    }
                }
            }
        });
    }
}
