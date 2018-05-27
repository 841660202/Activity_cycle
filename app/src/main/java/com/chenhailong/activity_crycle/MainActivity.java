package com.chenhailong.activity_crycle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Button go_sec_view;
    private Button go_thr_view;
    private Button go_sec_view_by_second_way;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this; // 为了内部实例访问到this
        go_sec_view = (Button) findViewById(R.id.go_sec_view);
        go_sec_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSec = new Intent(MainActivity.this, Second_activity.class);
                MainActivity.this.startActivity(intentSec);
            }
        });

        go_thr_view = (Button) findViewById(R.id.go_thr_view);
        go_thr_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThr = new Intent(MainActivity.this, Three_activity.class);
                MainActivity.this.startActivity(intentThr);
            }
        });

        go_sec_view_by_second_way = (Button) findViewById(R.id.go_sec_view_by_second_way);
        go_sec_view_by_second_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFour = new Intent(context, Four_activity.class);
                /**
                 * 第一个参数是Intent 对象
                 * 第二个参数是请求的一个标识
                 */
                startActivityForResult(intentFour, 1);
            }
        });
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    /**
     * 通过startActivityForResult 跳转，接受返回数据的方法
     *
     * @param requestCode 请求标识
     * @param resultCode  第二个页面返回的标识
     * @param data        第二个页面回传的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 4) {
            String content = data.getStringExtra("data");
            tvResult.setText(content);
        }
    }
}
