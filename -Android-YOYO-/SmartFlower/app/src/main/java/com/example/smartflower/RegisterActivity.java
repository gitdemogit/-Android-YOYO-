                      package com.example.smartflower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
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

public class RegisterActivity extends AppCompatActivity {
    EditText rg_iphone,rg_user,rg_password,rg_password_again;
    Button bt_sumit;
    SQLiteDatabase db;
    private boolean isFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       // db=SQLiteDatabase.openOrCreateDatabase(getCacheDir()+"/note",null);
        rg_iphone=findViewById(R.id.edit_iphone);
        rg_user=findViewById(R.id.edit_user);
        rg_password=findViewById(R.id.edit_password);
        rg_password_again=findViewById(R.id.edit_password_agin);
        bt_sumit=findViewById(R.id.button_register);
        initview();


//        bt_sumit.setOnClickListener(view -> {
//
//            if (rg_iphone.getText().toString().equals("") || rg_user.getText().toString().equals("") || rg_password.getText().toString().equals("") || rg_password_again.getText().toString().equals("")) {
//                Toast.makeText(RegisterActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from user where username='" + rg_user.getText().toString() + "'", null);
//            if (cursor.moveToNext()){
//                Toast.makeText(RegisterActivity.this,"账号已存在",Toast.LENGTH_SHORT).show();
//            }else {
//                ContentValues contentValues=new ContentValues();
//                contentValues.put("iphone",rg_iphone.getText().toString());
//                contentValues.put("username",rg_user.getText().toString());
//                contentValues.put("password",rg_password.getText().toString());
//                contentValues.put("password_again",rg_password_again.getText().toString());
//                db.insert("user",null,contentValues);
//                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
//                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
//
//            }
//        });
        SQLiteDatabase database = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
        String createSQL = "create table IF NOT EXISTS user(username text,password text,password2 text,phone text)";
        database.execSQL(createSQL);

        bt_sumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入信息
                String phone = rg_iphone.getText().toString();
                String username = rg_user.getText().toString();
                String password = rg_password.getText().toString();
                String password2 = rg_password_again.getText().toString();



                if (username.equals("") || password.equals("") || password2.equals("") || phone.equals("")) {
                    Toast.makeText(RegisterActivity.this, "请输入完整信息", Toast.LENGTH_SHORT).show();
                    isFlag = false;


                }

                Cursor cursor = database.query("user", new String[]{"username"}, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    if (username.equals(cursor.getString(cursor.getColumnIndex("username")))) {
                        Toast.makeText(RegisterActivity.this, "该账户已存在", Toast.LENGTH_SHORT).show();
                        isFlag = false;//
                    }
                }

                if(!password.equals(password2)) {

                    Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();


                }else if (!(phone.length() == 11)){
                    Toast.makeText(RegisterActivity.this, "请输入11位手机号！", Toast.LENGTH_SHORT).show();
                }
                else if (isFlag ) {
                    ContentValues values = new ContentValues();

                    values.put("phone", phone);
                    values.put("username", username);
                    values.put("password", password);
                    values.put("password2", password2);

                    database.insert("user", null, values);
                    Toast.makeText(RegisterActivity.this, "注册成功,请登录！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    database.close();
                }


            }
        });
    }


    void initview(){
        ((TextView) findViewById(R.id.tv_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(RegisterActivity.this);
            }
        });
    }
}

