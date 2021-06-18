package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView,textView4;
    Button button,practise;
    CountDownTimer ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.vvalue);
        button = findViewById(R.id.button);
        practise = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        textView4 = findViewById(R.id.textView4);
        ct = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                int currentHour = cal.get(Calendar.HOUR);
                int currentMinutes = cal.get(Calendar.MINUTE);
                int currentSeconds = cal.get(Calendar.SECOND);
                float spi_factor = (float) (factorial(currentHour)/(Math.pow(currentMinutes,3)+currentSeconds));
                textView4.setText("Spi Factor:"+spi_factor);
            }

            @Override
            public void onFinish() {
            ct.start();
            }
        }.start();
        practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "No Input", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String  x = editText.getText().toString();
                    long b = Long.parseLong(x);
                    if(b>=300000000||b<0)
                    {
                        Toast.makeText(MainActivity.this, "Invalid value of v", Toast.LENGTH_SHORT).show();
                        textView.setText("Invalid Value of v");
                    }
                    else
                    {
                        double d = Math.pow(Math.pow(300000000, 2) - Math.pow(b, 2), 0.5);
                        double z = 300000000 / d;
                        textView.setText("Lorentz Factor:\n" + z);
                    }
                }
            }
        });
    }


    public void OpenActivity()
    {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    int factorial(int y)
    {
        int x=1;
        for(int i=1;i<=y;i++)
        {
            x*=i;
        }
        return x;
    }

}