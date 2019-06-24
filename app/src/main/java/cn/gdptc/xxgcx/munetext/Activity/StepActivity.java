package cn.gdptc.xxgcx.munetext.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.Adapter.StepAdapter;
import cn.gdptc.xxgcx.munetext.uilt.RakeBean;

public class StepActivity extends Activity {
    private StepAdapter adapter;
    private List<RakeBean.ResultBean.DataBean> rakeList = new ArrayList<>();
    private TextView tv_title, tv_ingredients, tv_burden;
    private ImageView img_albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String alums = intent.getStringExtra("alums");
        String ingredients = intent.getStringExtra("ingredients");
        String burden = intent.getStringExtra("burden");
        tv_title = findViewById(R.id.tv_title);
        tv_ingredients = findViewById(R.id.tv_ingredients);
        tv_burden = findViewById(R.id.tv_burden);
        img_albums = findViewById(R.id.img_albums);

        tv_title.setText(title);
        tv_ingredients.setText(ingredients);
        tv_burden.setText(burden);
        Glide
                .with(StepActivity.this)
                .load(alums)
                .into(img_albums);

    }
}
