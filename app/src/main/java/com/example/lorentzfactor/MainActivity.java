package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.vvalue);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }
}