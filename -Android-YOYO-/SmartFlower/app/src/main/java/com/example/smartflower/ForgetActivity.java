package com.example.smartflower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity {
    private EditText et_iphone1,et_username1,et_newpassword1,et_newpassword_again1;
    private Button button_xg;
    private boolean isFlag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        et_iphone1=this.findViewById(R.id.et_iphone);
        et_username1=this.findViewById(R.id.et_user);
        et_newpassword1=this.findViewById(R.id.et_newpassword);
        et_newpassword_again1=this.findViewById(R.id.et_newpassword_agin);
        button_xg=this.findViewById(R.id.button_xg);
        initview();

        et_iphone1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else {
                    String iphone=et_iphone1.getText().toString();
                    if(!(iphone.length()==11)){
                        Toast.makeText(ForgetActivity.this,"请输入11位手机号",Toast.LENGTH_SHORT).show();
                        et_iphone1.setText("");
                    }
                }
            }
        });
        et_newpassword_again1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                }else {
                    String newpassword=et_newpassword1.getText().toString();
                    String newpassword2=et_newpassword_again1.getText().toString();
                    if (!(newpassword.equals(newpassword2))){
                        Toast.makeText(ForgetActivity.this,"两次密码输入的不一致,请重新输入",Toast.LENGTH_SHORT).show();
                        et_newpassword_again1.setText("");
                    }

                }
            }
        });

        SQLiteDatabase database=openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        button_xg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=et_iphone1.getText().toString();
                String username=et_username1.getText().toString();
                String password=et_newpassword1.getText().toString();
                String password2=et_newpassword_again1.getText().toString();
                if (phone.equals("")||username.equals("")||password.equals("")||password2.equals("")){
                    Toast.makeText(ForgetActivity.this,"请输入完整的信息",Toast.LENGTH_SHORT).show();
                }else if(!(password.equals(password2))){
                    Toast.makeText(ForgetActivity.this,"两次密码输入的不一致",Toast.LENGTH_SHORT).show();
                }else {
                    Cursor cursor=database.query("user",new String[]{"phone,username"},null,null,null,null,null);
                    while (cursor.moveToNext()){
                        if ((phone.equals(cursor.getString(cursor.getColumnIndex("phone")))&&username.equals(cursor.getString(cursor.getColumnIndex("username"))))){
                            ContentValues values=new ContentValues();
                            String Username=et_username1.getText().toString();
                            values.put("password",password);
                            values.put("password2",password2);
                            database.update("user",values,"username=?",new String[]{username});
                            Toast.makeText(ForgetActivity.this,"修改密码成功，请重新登录",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ForgetActivity.this,LoginActivity.class);
                            startActivity(intent);
                            database.close();
                            break;
                        }
                        isFlag=false;
                    }
                }if (isFlag==false){
                    Toast.makeText(ForgetActivity.this,"用户名与手机号不匹配,修改失败",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    void initview(){
        ((TextView) findViewById(R.id.tv_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(ForgetActivity.this);
            }
        });
    }
}