package com.example.wildlifedetectprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ProtectYourSelfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protectyourself);

        android.widget.Toast.makeText(this, "Hello world ㅇㅏ 나 블루스크린 죽고싶어요", Toast.LENGTH_SHORT).show();
    }
}