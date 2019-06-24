package cn.gdptc.xxgcx.munetext.Activity;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Adapter.StepAdapter;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.RakeBean;

public class StepActivity extends Activity {
    private StepAdapter adapter;
    private List<RakeBean.ResultBean.DataBean> rakeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);


    }
}
