package com.indianappsremover;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("正在检测印度应用……");
        dialog.setCancelable(false);
        dialog.show();
        final Handler handler = new Handler();
        TimerTask task = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                        findViewById(R.id.textView).setVisibility(View.VISIBLE);
                        ((Button) findViewById(R.id.button)).setText(R.string.button2);
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}