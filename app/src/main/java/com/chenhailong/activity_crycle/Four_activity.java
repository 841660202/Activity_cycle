package com.chenhailong.activity_crycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class Four_activity extends Activity{
    private Button btn;
    private String content = "fine thank you, and you?";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_view);

        btn =(Button) findViewById(R.id.f_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("data", content);
                setResult(4, data);
                finish(); // 销毁当前页面
            }
        });
    }
}
