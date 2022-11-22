package com.example.wildlifedetectprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_remember;
    Button btn_view;
    Button btn_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
        this.SetListener();
    }

    private void InitializeView()
    {
        btn_remember = (Button)findViewById(R.id.rememberButton);
        btn_view = (Button)findViewById(R.id.viewButton);
        btn_sound = (Button)findViewById(R.id.soundButton);
    }

    public void SetListener() {
        btn_remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RememberActivity.class);
                startActivity(intent);
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProtectYourSelfActivity.class);
                startActivity(intent);
            }
        });
        btn_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UltraSoundActivity.class);
                startActivity(intent);
            }
        });
    }
}