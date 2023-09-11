package com.example.smartflower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.smartflower.tools.CloudHelper;

import java.util.Timer;
import java.util.TimerTask;

public class DataActivity extends Activity {

    private double tem=0,humd=0,sun1=0,shidu1=0;
    private TextView temp,hum,sun,shidu;
    Context context = this;
    private static final String TAG = "tagzy";
    CloudHelper ch = new CloudHelper(context,
            "http://www.nlecloud.com",
            "13356339605",
            "asdf751206",
            "709801");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        initView();
        temp=findViewById(R.id.temp);
        hum=findViewById(R.id.hum);
        sun=findViewById(R.id.sun);
        shidu=findViewById(R.id.shidu);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ch.getValue("z_temp", new CloudHelper.DataCallback() {
                    @Override
                    public void get(String s) {
                        tem = Double.parseDouble(s);
                        setUI(temp, s + "");
                        Log.d(TAG, "get: value is " + s);
                    }
                });
            }
        }, 0, 1000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ch.getValue("z_hum", new CloudHelper.DataCallback() {
                    @Override
                    public void get(String s) {
                        humd = Double.parseDouble(s);
                        setUI(hum, s + "");
                        Log.d(TAG, "get: value is " + s);
                    }
                });
            }
        }, 0, 1000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ch.getValue("z_light", new CloudHelper.DataCallback() {
                    @Override
                    public void get(String s) {
                        sun1 = Double.parseDouble(s);
                        setUI(sun, s + "");
                        Log.d(TAG, "get: value is " + s);
                    }
                });
            }
        }, 0, 1000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ch.getValue("s_soil", new CloudHelper.DataCallback() {
                    @Override
                    public void get(String s) {
                        shidu1 = Double.parseDouble(s);
                        setUI(shidu, s + "");
                        Log.d(TAG, "get: value is " + s);
                    }
                });
            }
        }, 0, 1000);
    }

    private void setUI(TextView textView, String value) {
        runOnUiThread(() -> textView.setText(value));
    }

    public double getTem() {
        return tem;
    }

    public double getHumd() {
        return humd;
    }

    public double getSun1() {
        return sun1;
    }

    public double getShidu1() {
        return shidu1;
    }

    void initView() {
        ((TextView) findViewById(R.id.tv_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(DataActivity.this);
            }
        });
    }
}