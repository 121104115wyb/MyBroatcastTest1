package com.btzh.mybroatcasttest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    private int typeStr = -10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getType = this.getIntent();
        typeStr = Integer.parseInt(getType.getStringExtra("type"));
        if (123==typeStr){
            setContentView(R.layout.constraintlayout_one);
        }else {
            setContentView(R.layout.activity_main2);
        }

    }
    public void onClick_btn(View view){
        int ID = view.getId();
        if (ID == R.id.button_dl){
            Intent new_intent = new Intent(Main2Activity.this,LoginActivity.class);
            startActivity(new_intent);
        }else if (ID == R.id.button_zc){

        }else {

        }
    }
}
