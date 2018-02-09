package com.example.rubyeffect.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {
    Thread t;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        start = (Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),login.class);
                startActivity(b);
                finish();
            }
        });
        t= new Thread(){
            public void run(){
                try{
                    t.sleep(3000);
                    Intent i = new Intent(getApplicationContext(),login.class);
                    startActivity(i);
                }catch (Exception e){

                }
            }
        };
t.start();
    }
}
