package cn.gdptc.xxgcx.munetext.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import cn.gdptc.xxgcx.munetext.MainActivity;
import cn.gdptc.xxgcx.munetext.R;

public class RakeActivity extends AppCompatActivity {
    private ImageButton imageButton;

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
                Intent intent = new Intent(RakeActivity.this, MainActivity.class);
                intent.putExtra("PA","1");
                startActivity(intent);
            }
        });
    }
}