package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

public class ChestActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        checkBox1 = (CheckBox)findViewById(R.id.checkBox_upper);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox_flat);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox_lower);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox_tri);

        checkBox1.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        checkBox2.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        checkBox3.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        checkBox4.setOnCheckedChangeListener(checkBoxOnCheckedChange);

        btn_finish = (Button) findViewById(R.id.chest_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private CompoundButton.OnCheckedChangeListener checkBoxOnCheckedChange =
            new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
                        btn_finish.setVisibility(View.VISIBLE);
                        Log.d("btn_finish", "VISIBLE");
                    }
                    else {
                        btn_finish.setVisibility(View.INVISIBLE);
                        Log.d("btn_finish", "INVISIBLE");
                    }
                }
            };
}