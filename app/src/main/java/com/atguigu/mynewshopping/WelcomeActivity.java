package com.atguigu.mynewshopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;


public class WelcomeActivity extends AppCompatActivity {


    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMain();
            }
        }, 2000);
    }

    private void startMain() {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            handler.removeCallbacksAndMessages(null);
            startMain();
            return true;
        }
        return super.onTouchEvent(event);
    }
}
