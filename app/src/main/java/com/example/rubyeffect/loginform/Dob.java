package com.example.rubyeffect.loginform;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Dob extends AppCompatActivity {
    EditText dob;
    Calendar mcurrentDate;
    int day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob);
        dob = (EditText)findViewById(R.id.dob);

        mcurrentDate = Calendar.getInstance();
        day = mcurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mcurrentDate.get(Calendar.MONTH);
        year = mcurrentDate.get(Calendar.YEAR);

        month = month + 1;
        dob.setText(day+"/"+month+"/"+year);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Dob.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1 + 1;
                        dob.setText(i+"/"+i1+"/"+i2);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}
