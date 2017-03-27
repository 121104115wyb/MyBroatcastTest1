package com.btzh.mybroatcasttest1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText_type);
        findViewById(R.id.send_btn).setOnClickListener(this);
        registerReceiver(return_receiver,new IntentFilter("getreturn"));
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent("activity_broadcast");
        intent.putExtra("name","测试我是mybroatcasttest1");
        intent.putExtra("action","2");
        sendBroadcast(intent);
    }
    private void return_sendcast(String inflater){

    }
    private BroadcastReceiver return_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("getreturn".equals(intent.getAction())){
                Bundle bundle = intent.getExtras();
                bundle.getString("name");
                String returnStr = intent.getStringExtra("name");
                Toast.makeText(context, "我是"+returnStr+bundle.getString("name"), Toast.LENGTH_SHORT).show();
                System.out.println("-----"+"我是返回的广播"+returnStr);
            }
        }
    };
    public void btn_onclick(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        String gettype = editText.getText().toString();
        intent.putExtra("type",gettype);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(return_receiver);
    }
}
