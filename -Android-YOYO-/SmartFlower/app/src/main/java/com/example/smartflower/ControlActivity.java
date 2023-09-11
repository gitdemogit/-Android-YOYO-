package com.example.smartflower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartflower.tools.CloudHelper;

import java.util.Timer;
import java.util.TimerTask;

public class ControlActivity extends AppCompatActivity {
    private TextView version_info;
    private Context context;
    CloudHelper ch = new CloudHelper(context,
            "http://www.nlecloud.com",
            "13356339605",
            "asdf751206",
            "709801");
    ImageView guan1, guan2, guan3, guan4;
    private static final String TAG = "111";
    private boolean deng = false, deng1 = false, shuibeng1 = false, shuibeng2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        initView();
        guan1 = (ImageView) findViewById(R.id.guan1);
        guan2 = (ImageView) findViewById(R.id.guan2);
        guan3 = (ImageView) findViewById(R.id.guan3);
        guan4 = (ImageView) findViewById(R.id.guan4);
    }


    void initView() {
        ((TextView) findViewById(R.id.tv_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(ControlActivity.this);
            }
        });
    }

    private void setUI(ImageView imageView, int imageid) {
        runOnUiThread(() -> imageView.setImageResource(imageid));
    }

    public void clickguan1(View view) {
        guan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deng == true) {
                    new Thread() {
                        @Override
                        public void run() {
                            ch.onOff("deng1", 0, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: values " + s);
                                    setUI(guan1, R.drawable.close3);
                                }
                            });
                        }
                    }.run();
                    deng = false;
                } else {
                    new Thread() {
                        @Override
                        public void run() {
                            ch.onOff("deng1", 1, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: " + s);
                                    setUI(guan1, R.drawable.open2);
                                }
                            });
                        }
                    }.run();
                    deng = true;
                }
            }
        });
        deng = !deng;
    }

    public void clickguan2(View view) {
        guan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deng1 == true) {
                    new Thread() {
                        @Override
                        public void run() {
                            ch.onOff("deng2", 0, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: values " + s);
                                    setUI(guan2, R.drawable.close3);
                                }
                            });
                        }
                    }.run();
                    deng1 = false;
                } else {
                    new Thread() {
                        @Override
                        public void run() {
                            ch.onOff("deng2", 1, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: " + s);
                                    setUI(guan2, R.drawable.open2);
                                }
                            });
                        }
                    }.run();
                    deng1 = true;
                }
            }
        });
        deng1 = !deng1;
    }

    public void clickguan3(View view) {
        guan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shuibeng1 == true) {
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ch.onOff("beng1", 0, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: values " + s);
                                    setUI(guan3, R.drawable.close3);
                                }
                            });
                        }
                    }, 10);
                    shuibeng1 = false;
                } else {
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ch.onOff("beng1", 1, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: " + s);
                                    setUI(guan3, R.drawable.open2);
                                }
                            });
                        }
                    }, 10);
                    shuibeng1 = true;
                }
            }
        });
        shuibeng1= !shuibeng1;
    }

    public void clickguan4(View view) {
        guan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shuibeng2 == true) {
                    new Thread() {
                        @Override
                        public void run() {
                            ch.onOff("beng2", 0, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: values " + s);
                                    setUI(guan4, R.drawable.close3);
                                }
                            });
                        }
                    }.run();
                    shuibeng2 = false;
                } else {
                    new Thread() {
                        @Override
                        public void run() {
                            ch.onOff("beng2", 1, new CloudHelper.DataCallback() {
                                @Override
                                public void get(String s) {
                                    Log.d(TAG, "get: " + s);
                                    setUI(guan4, R.drawable.open2);
                                }
                            });
                        }
                    }.run();
                    shuibeng2 = true;
                }
            }
        });
        shuibeng2 = !shuibeng2;
    }
}