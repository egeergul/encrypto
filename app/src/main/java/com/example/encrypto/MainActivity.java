package com.example.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Properties
    Button caesarChipperBtn, vinegarChipperBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Initialize
        caesarChipperBtn = findViewById(R.id.caeserChipperBtn);
        vinegarChipperBtn = findViewById(R.id.vinegarChipperBtn);

        caesarChipperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), caesarChipperActivity.class);
                startActivity(intent);
            }
        });

        vinegarChipperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), vinegarChipperActivity.class);
                startActivity(intent);
            }
        });
    }
}