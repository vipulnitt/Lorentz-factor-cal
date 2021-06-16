package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button,practise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.vvalue);
        button = findViewById(R.id.button);
        practise = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
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
}