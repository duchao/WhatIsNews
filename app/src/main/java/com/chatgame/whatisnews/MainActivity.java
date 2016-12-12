package com.chatgame.whatisnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chatgame.whatisnews.ui.main.activity.WelcomeActivity;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.btn_test_welcome);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //test 版本控制
        // 分支测试
    }
}
