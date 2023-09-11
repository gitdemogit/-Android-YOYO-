package com.example.smartflower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import com.example.smartflower.tools.Flower;
import com.example.smartflower.tools.FlowerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
   // AlertDialog.Builder dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawerLayout);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        drawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.menu_data:
                                startActivity(new Intent(MainActivity.this, DataActivity.class));
                                break;
                            case R.id.menu_control:
                                startActivity(new Intent(MainActivity.this, ControlActivity.class));
                                break;
                            case R.id.menu_exit:
                                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                                break;
                            case R.id.menu_info:
                                startActivity(new Intent(MainActivity.this,DisActivity.class));
                                break;

                        }
                        return true;
                    }
                }
        );

        listView = (ListView) findViewById(R.id.list_view);
        List<Flower> flowerList = new ArrayList<>();
        Flower at = new Flower("蔷薇", "美德", R.drawable.f1);
        flowerList.add(at);
        Flower at1 = new Flower("福禄考", "大方", R.drawable.f2);
        flowerList.add(at1);
        Flower at2 = new Flower("香雪球", "勇敢", R.drawable.f3);
        flowerList.add(at2);
        Flower at3 = new Flower("六倍利", "同情", R.drawable.f4);
        flowerList.add(at3);
        Flower at4 = new Flower("三色堇", "思念", R.drawable.f5);
        flowerList.add(at4);
        Flower at5 = new Flower("角堇", "可爱", R.drawable.f6);
        flowerList.add(at5);
        Flower at6 = new Flower("迎春", "顽强", R.drawable.f7);
        flowerList.add(at6);
        Flower at7 = new Flower("白晶菊", "阳光", R.drawable.f8);
        flowerList.add(at7);
        Flower at8 = new Flower("瓜叶菊", "快乐", R.drawable.f9);
        flowerList.add(at8);
        Flower at9 = new Flower("球根海", "亲切", R.drawable.f10);
        flowerList.add(at9);
        Flower at10 = new Flower("报春花", "初恋", R.drawable.f11);
        flowerList.add(at10);
        Flower at11 = new Flower("丁香", "谦逊", R.drawable.f12);
        flowerList.add(at11);
        Flower at12 = new Flower("石竹", "大胆", R.drawable.f13);
        flowerList.add(at12);

        FlowerAdapter adapter1 = new FlowerAdapter(MainActivity.this, R.layout.flower_items, flowerList);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://baike.baidu.com/item/%E8%94%B7%E8%96%87/65296?fr=aladdin"));
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse("https://baike.baidu.com/item/%E7%A6%8F%E7%A6%84%E8%80%83/151822?fr=aladdin"));
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(Intent.ACTION_VIEW);
                        intent2.setData(Uri.parse("https://baike.baidu.com/item/%E9%A6%99%E9%9B%AA%E7%90%83/1425553?fr=aladdin"));
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(Intent.ACTION_VIEW);
                        intent3.setData(Uri.parse("https://baike.baidu.com/link?url=PwR8uVSsVt1KsvKsae0Tt_tSJJ-Oh7LWiT0siLc3F_wqVnovmCmvU-iA9bfdwTAxFdmQkiI-bgexgtg7yHjLYV_aaDsZ2kYBhNZ38UsMS097oB9JdVFi_N3ryFkcXvq2"));
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(Intent.ACTION_VIEW);
                        intent4.setData(Uri.parse("https://baike.baidu.com/link?url=rAEjwNwkC59ap5JUJCDuAMqoQWeCBYEmxj-Nbj6fGGn_jM5Kb86skNzm0S-kzFauVvn8tivwq65QjZ1wf94YE2U94-PeCsBBNj_6QXXsUTNCntZFkl1LPHpSmAFf-WZ7"));
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=new Intent(Intent.ACTION_VIEW);
                        intent5.setData(Uri.parse("https://baike.baidu.com/link?url=SjfBNou5WUf4uEZ9THnzBpbBdcLI7f_565yzSjCY4FLh0tpSaiy7JmpOP_2eGbWrdzzBWihaQW0q5wSWVRmE7vIGNcWsRft4OIHBQylScMi"));
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6=new Intent(Intent.ACTION_VIEW);
                        intent6.setData(Uri.parse("https://baike.baidu.com/link?url=L4plYpC3CpdrLgMwjIM3nlplHNn9s8qK0WYOiNNExoNrpOSdkld9Z4lw9Lz6jgJMETrPPcTuiEpwOqbievmKjSqYxiKpKUqTH3GCFuHKowKRLeIoZo9y3Y33ssV-oXsH"));
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7=new Intent(Intent.ACTION_VIEW);
                        intent7.setData(Uri.parse("https://baike.baidu.com/link?url=XAF5_WWn68s1f0F6nU71bUF92y2YEdklnQnSdgPmNPzsUMMSW-I7UwLjwceg-k6lg3hkNvNYOQwhZ4vdH8yFKg8DiBiWDRCkohHraG41eZD50Ro0l2Hlk1llXe_IxFMt"));
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8=new Intent(Intent.ACTION_VIEW);
                        intent8.setData(Uri.parse("https://baike.baidu.com/link?url=JsoxGUGpWanwz0JrKalUBHWxkwJTXpGglKetMaWgPzyIuoGbLIbKMcu122m_xLoMoa1QxyhyL7eNnAdVtOPACYyqqAuvGiJnlbj5n57tdx0tjVK0-GfGBpVAIWFpciVi"));
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9=new Intent(Intent.ACTION_VIEW);
                        intent9.setData(Uri.parse("https://baike.baidu.com/link?url=ciX7Lug1IQ6WlMmQWJeqmGAKDIPgKLP4Ip_-LN5yTj8gxHVwFSwzWuf2vFFVmZLGE0ubQCoHyh0DaltK_8g_83J6IOtrJ9bHZhSt2kYQWmg-oVUa6uWUNlD1SIu9diYd32RnhY6TSbcsc7rP_Bn6VK"));
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10=new Intent(Intent.ACTION_VIEW);
                        intent10.setData(Uri.parse("https://baike.baidu.com/link?url=pHBxHMxc4Kejw30ofCfxUJKqSCCj2UVHsTX6gNzjUFjfA2TJetGU6EJCHeV4kMcVkPE7IRfvs6vGYA-9vhv9emw3FTOW71BWdK2CZOkMm3zABD5MJ-W-LnvmSxmSo_0c"));
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11=new Intent(Intent.ACTION_VIEW);
                        intent11.setData(Uri.parse("https://baike.baidu.com/item/%E4%B8%81%E9%A6%99/6069?fr=aladdin"));
                        startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12=new Intent(Intent.ACTION_VIEW);
                        intent12.setData(Uri.parse("https://baike.baidu.com/link?url=bWE5-m2qvUAA7ztvpwPesYSHDV1quBlnyDWCr6wNm1LCDr0-y0SyczqjmJV0JNVpxwgZo0w5WG8kjXKLklAQQORiKXrO1NluinomsOo9n6S"));
                        startActivity(intent12);
                        break;
                }
            }
        });

    }

}
