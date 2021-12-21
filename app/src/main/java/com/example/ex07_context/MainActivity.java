package com.example.ex07_context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 버튼을 롱 클릭했을 때 컨텍스트 메뉴 나타내는 코드

    LinearLayout baseLayout;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기 (컨텍스트 메뉴)");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        btn1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(btn1);

        btn2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if(v == btn1){
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.icon1);
            mInflater.inflate(R.menu.menu1,menu);
        }
        if(v == btn2){
            menu.setHeaderTitle("버튼 변경");
            mInflater.inflate(R.menu.menu2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // 1. XML 사용 시
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return false;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return false;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return false;
            case R.id.subRotate:
                btn2.setRotation(45);
                return false;
            case R.id.subSize:
                btn2.setScaleX(2);
                return false;
        }
        return super.onContextItemSelected(item);
    }
}