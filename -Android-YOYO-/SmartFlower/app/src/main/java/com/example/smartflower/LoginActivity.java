package com.example.smartflower;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText lg_name, lg_password;
    Button btn_login;
    TextView btn_register, btn_xg;
    //SQLiteDatabase db;
    boolean isFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lg_name = this.findViewById(R.id.lg_name);
        lg_password = this.findViewById(R.id.lg_password);
        btn_login = this.findViewById(R.id.btn_login);
        btn_register = this.findViewById(R.id.btn_register);
        btn_xg = this.findViewById(R.id.ed_xg);
        //       db=SQLiteDatabase.openOrCreateDatabase(getCacheDir()+"/note",null);
//        System.out.println(lg_name.getText().toString());
//
//        try {
//            db.execSQL("create table if not exists user(iphone text,username text,password text,password_again text)");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        SharedPreferences sharedPreference=getSharedPreferences("user",0);
//        lg_name.setText(sharedPreference.getString("lg_name",""));
//        lg_password.setText(sharedPreference.getString("lg_password",""));
//        btn_login.setOnClickListener(view -> {
//            if (lg_name.getText().toString().equals("")||lg_password.getText().toString().equals("")){
//                Toast.makeText(LoginActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
//                return;
//            }
//            @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from user where username="+ lg_name.getText().toString(), null);
//            if (cursor.moveToNext()){
//                //Log.d(TAG, "onCreate: 111");
//                if (cursor.getString(1).equals(lg_password.getText().toString())){
//                    SharedPreferences.Editor editor=getSharedPreferences("lg_name",0).edit();
//                    Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                    editor.apply();
//                }else {
//                    Toast.makeText(LoginActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
//                }
//            }else {
//                Toast.makeText(LoginActivity.this,"账号不存在",Toast.LENGTH_SHORT).show();
//            }
//
//        });
        SQLiteDatabase database = openOrCreateDatabase("user.db", MODE_PRIVATE, null);

        String createSQL = "create table IF NOT EXISTS user(phone text,username text,password text,password2 text)";
        database.execSQL(createSQL);//执行创表语句
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFlag = false;
                String username = lg_name.getText().toString();
                String password = lg_password.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "请输入账号或密码！", Toast.LENGTH_SHORT).show();
                    isFlag = true;
                }


                Cursor cursor = database.query("user", new String[]{"username,password"}, null, null, null, null, null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(LoginActivity.this, "请先注册账号！", Toast.LENGTH_SHORT).show();
                    isFlag = true;
                } else {
                    while (cursor.moveToNext()) {

                        if (username.equals(cursor.getString(cursor.getColumnIndex("username"))) && password.equals(cursor.getString(cursor.getColumnIndex("password")))) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            isFlag = true;
                            break;

                        }
                    }
                    if (isFlag == false) {
                        Toast.makeText(LoginActivity.this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }


            }


        });
        btn_xg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        //btn_xg.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,ForgetActivity.class)));
    }


}