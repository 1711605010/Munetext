package cn.gdptc.xxgcx.munetext.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import cn.gdptc.xxgcx.munetext.MainActivity;
import cn.gdptc.xxgcx.munetext.R;

public class RakeActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private EditText input;
    private LinearLayout ll_seach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rake);
        imageButton=findViewById(R.id.img_btn_back);
        initView();
    }

    private void initView() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        input = findViewById(R.id.ed_input);
        ll_seach = findViewById(R.id.ll_seach);

        ll_seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input.getText().toString().trim();
                Intent intent = new Intent(RakeActivity.this,ContentActivity.class);
                intent.putExtra("content",content);
                startActivity(intent);
            }
        });

    }
}