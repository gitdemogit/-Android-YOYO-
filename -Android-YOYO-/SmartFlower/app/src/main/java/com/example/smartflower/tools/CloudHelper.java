package com.example.smartflower.tools;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import cn.com.newland.nle_sdk.requestEntity.SignIn;
import cn.com.newland.nle_sdk.responseEntity.SensorInfo;
import cn.com.newland.nle_sdk.responseEntity.User;
import cn.com.newland.nle_sdk.responseEntity.base.BaseResponseEntity;
import cn.com.newland.nle_sdk.util.NCallBack;
import cn.com.newland.nle_sdk.util.NetWorkBusiness;

public class CloudHelper {

    private static final String TAG = "tagzy";
    private Context context;

    private String address;
    private String account;
    private String password;
    private String deviceId;

    private String token = "";
    //private String
    public NetWorkBusiness nb;

    public CloudHelper(Context context, String address, String account, String password, String deviceId) {
        this.context = context;
        this.address = address;
        this.account = account;
        this.password = password;
        this.deviceId = deviceId;
        signIn();
    }
   //通过signIn()这个方法来进行登录，并且通过打印语句来判断是否登陆成功。
    private void signIn() {
        nb = new NetWorkBusiness(token, address);
        nb.signIn(new SignIn(account, password), new NCallBack<BaseResponseEntity<User>>(context) {
            @Override
            protected void onResponse(BaseResponseEntity<User> response) {
                if (response.getStatus() == 0) {
                    token = response.getResultObj().getAccessToken();
                    nb = new NetWorkBusiness(token, address);
                    Log.d(TAG, "onResponse: 登录成功");
                } else {
                    toa("登录失败");
                }
            }
        });
    }

    public interface DataCallback {
        void get(String s);
    }
    //传感器获取数值的方法，通过标识符的传入以及回调函数来进行判断拿值
    public void getValue(String apiTag, DataCallback back) {
        nb.getSensor(deviceId, apiTag, new NCallBack<BaseResponseEntity<SensorInfo>>(context) {
            @Override
            protected void onResponse(BaseResponseEntity<SensorInfo> entity) {
                if (entity != null && entity.getResultObj() != null && entity.getResultObj().getValue() != null) {
                    Log.d(TAG, "onResponse: reponse   --------");
                    back.get(entity.getResultObj().getValue());
                } else {
                    toa("拿值成功");
                }
            }
        });
    }
    //执行器控制的方法，通过该标识符，以及“0”与“1”的状态来对执行器进行控制
    public void onOff(String apiTag, int state, DataCallback back) {
        nb.control(deviceId, apiTag, state, new NCallBack<BaseResponseEntity>(context) {
            @Override
            protected void onResponse(BaseResponseEntity baseResponseEntity) {
                back.get(String.valueOf(baseResponseEntity.getStatus()).equals((state + "")) ? "操作成功" : "操作失败");
            }
        });
    }

    private void toa(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

    }


    public void signOut() {
        token = "";
    }


}