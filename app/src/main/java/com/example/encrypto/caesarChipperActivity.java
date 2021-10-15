package com.example.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class caesarChipperActivity extends AppCompatActivity {
    //Properties
    RadioButton rbEncrypt, rbDecrypt, rbTR, rbENG;
    RadioGroup rg, rgLANG;
    Button go;
    EditText et, etKey, etAlphabet;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_chipper);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Initialize
        rbEncrypt = findViewById(R.id.rbEncrypt);
        rbEncrypt.setBackgroundColor(Color.parseColor("#28ba00"));
        rbEncrypt.setTextColor(Color.parseColor("#0d3602"));
        rbDecrypt = findViewById(R.id.rbDecrypt);
        rg = findViewById(R.id.radioGroup);
        go = findViewById(R.id.goBtn);
        et = findViewById(R.id.etInput);
        etKey = findViewById(R.id.etKey);
        result = findViewById(R.id.tvResult);
        rbTR = findViewById(R.id.rbTR);
        rbENG = findViewById(R.id.rbENG);
        rgLANG = findViewById(R.id.rgLang);
        etAlphabet = findViewById(R.id.etAlphabet);

        //Customize RadioButtons
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (radioButton.getText().equals("Encrypt")) {
                    rbEncrypt.setBackgroundColor(Color.parseColor("#28ba00"));
                    rbEncrypt.setTextColor(Color.parseColor("#0d3602"));
                    rbDecrypt.setBackgroundColor(Color.parseColor("#0d3602"));
                    rbDecrypt.setTextColor(Color.parseColor("#28ba00"));
                } else {
                    rbEncrypt.setBackgroundColor(Color.parseColor("#0d3602"));
                    rbDecrypt.setBackgroundColor(Color.parseColor("#28ba00"));
                    rbDecrypt.setTextColor(Color.parseColor("#0d3602"));
                    rbEncrypt.setTextColor(Color.parseColor("#28ba00"));
                }
            }
        });

        rgLANG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                if (radioButton.getText().equals("ENG")) {
                    rbENG.setBackgroundColor(Color.parseColor("#28ba00"));
                    rbTR.setBackgroundColor(Color.parseColor("#0d3602"));
                    etAlphabet.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
                } else {
                    rbENG.setBackgroundColor(Color.parseColor("#0d3602"));
                    rbTR.setBackgroundColor(Color.parseColor("#28ba00"));
                    etAlphabet.setText("ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz0123456789");
                }
            }
        });
        //End of customizing of RadioButtons


        //Event Listeners
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lengthOfAlphabet = etAlphabet.getText().length();
                char alphabet[] = new char[ lengthOfAlphabet];
                for (int i = 0; i < lengthOfAlphabet; i++) {
                    alphabet[i] = etAlphabet.getText().charAt(i);
                }
                cannotBeEmpty(et);
                etKeySuitable(lengthOfAlphabet);

                //Initialize
                Encrypto encrypto = new Encrypto();
                encrypto.setAlphabet(alphabet);

                int key = Integer.parseInt(etKey.getText().toString());
                String msg = et.getText().toString();
                String output = "";

                if (rbEncrypt.isChecked())
                    output = encrypto.encrypt(msg, key);
                else
                    output = encrypto.decrypt( msg, key);

                result.setText( output);
            }
        });
    }

    //METHODS
    public void cannotBeEmpty( EditText et) {
        String msg = et.getText().toString();

         if (msg.isEmpty()){
            et.setError("You cannot leave here empty!");
            et.requestFocus();
            return;
        }
    }

    private void etKeySuitable( int j){
        cannotBeEmpty( etKey);
        int key = Integer.parseInt(etKey.getText().toString());
        if ( key < 0 ){
            etKey.requestFocus();
            etKey.setError("Enter a positive number!");
        }
        else if( key > j ){
            etKey.requestFocus();
            etKey.setError("Enter a number smaller than " + j + "!");
        }
    }

}