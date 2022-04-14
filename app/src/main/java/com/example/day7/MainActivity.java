package com.example.day7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 =findViewById(R.id.layout);
        tv1=(TextView) findViewById(R.id.textView);

        registerForContextMenu(tv1); // TextView tv1에 꾹 누르면 메뉴 나옴!, 컨텍스트 메뉴 등록
    }

    @Override
    // 컨텍스트 메뉴 추가
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // add(메뉴그룹, 메뉴아이디, 순서(order), 옵션이름(문자열))
        menu.setHeaderTitle("텍스트뷰의 배경색");
        menu.add(0,1,0,"배경 노란색 변경");
        menu.add(0,2,0,"배경 회색 변경");
        menu.add(0,3,0,"배경 흰색 변경");
    }

    @Override
    // 플로팅 컨텍스트 메뉴의 아이템 클릭시 자동 호출되는 메소드(콜백 메소드, 오버라이딩)
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                tv1.setBackgroundColor(Color.YELLOW);
                return true;
            case 2:
                tv1.setBackgroundColor(Color.GRAY);
                return true;
            case 3:
                tv1.setBackgroundColor(Color.WHITE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu); // add
        getMenuInflater().inflate(R.menu.mymenu,menu); //메뉴 팽창(메뉴 등록)
        return true;
    }

    @Override
    //옵션메뉴 아이템 클릭시 자동호출되는 메소드(콜백 메소드, 오버라이딩)
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.blue:
                view1.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.red:
                view1.setBackgroundColor(Color.RED);
                return true;
            case R.id.green:
                view1.setBackgroundColor(Color.GREEN);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}