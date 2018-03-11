package com.example.jackhuang.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Beginning of buttons
        Button quit = findViewById(R.id.QuitBtn);
        quit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });



    }
}
