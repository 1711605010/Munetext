package cn.gdptc.xxgcx.munetext.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Adapter.ListViewAdapter;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.Adapter.StepAdapter;
import cn.gdptc.xxgcx.munetext.uilt.ListViewInfo;
import cn.gdptc.xxgcx.munetext.uilt.RakeBean;

public class StepActivity extends Activity {
    private StepAdapter adapter;
    private TextView tv_title, tv_ingredients, tv_burden;
    private ImageView img_albums;
    private ListView listView;
    private RakeBean.ResultBean.DataBean bean;
    private List<RakeBean.ResultBean.DataBean> stepList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        bean = (RakeBean.ResultBean.DataBean) intent.getSerializableExtra("bean");

        listView = findViewById(R.id.lv_step);
        tv_title = findViewById(R.id.tv_title);
        tv_ingredients = findViewById(R.id.tv_ingredients);
        tv_burden = findViewById(R.id.tv_burden);
        img_albums = findViewById(R.id.img_albums);


        adapter = new StepAdapter(  bean.getSteps(),StepActivity.this);
        listView.setAdapter(adapter);

        tv_title.setText(bean.getTitle());
        tv_ingredients.setText(bean.getIngredients());
        tv_burden.setText(bean.getBurden());
        Glide
                .with(StepActivity.this)
                .load(bean.getAlbums().get(0))
                .into(img_albums);

    }

}
