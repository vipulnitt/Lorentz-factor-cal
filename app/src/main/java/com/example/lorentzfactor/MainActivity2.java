package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    EditText vvalue,factor;
    Vibrator vibrator;
    Button button;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = this.getWindow().getDecorView();
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView3);
        vvalue = findViewById(R.id.vvalue);
        factor =findViewById(R.id.factor);
        button =findViewById(R.id.button3);
        view.setBackgroundResource(R.color.Blue);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(vvalue.getText().toString())||TextUtils.isEmpty(factor.getText().toString()))
                    Toast.makeText(MainActivity2.this, "Box is empty", Toast.LENGTH_SHORT).show();
                else
                {
                    String vv = vvalue.getText().toString();
                    long x = Long.parseLong(vv);
                    String ff = factor.getText().toString();
                    double y = Double.parseDouble(ff);
                    long c=300000000;
                    if(x<c)
                    {
                        double d = Math.pow(Math.pow(300000000, 2) - Math.pow(x, 2), 0.5);
                        double z = 300000000 / d;
                        if(z==y){
                            view.setBackgroundResource(R.color.Blue);
                            textView.setText("Correct Answer!");
                        }
                        else{
                            view.setBackgroundResource(R.color.Red);
                            textView.setText("Wrong Answer! Correct is:\n "+z);
                            vibrator.vibrate(100);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity2.this, "Invalid value of v", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }
}