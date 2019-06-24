package cn.gdptc.xxgcx.munetext.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Adapter.ContentAdapter;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.OkhttpUntil;
import cn.gdptc.xxgcx.munetext.uilt.RakeBean;
import cn.gdptc.xxgcx.munetext.uilt.TostringNetworkListining;

public class ContentActivity extends Activity {
    private RecyclerView recyclerView;
    private ContentAdapter adapter;
    private List<RakeBean.ResultBean.DataBean> rakeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        String s = intent.getStringExtra("content").toString().trim();
        String content = "http://apis.juhe.cn/cook/query?key=bd350292258cc5124e673cbac0755e57&menu="+s+"&rn=50&pn=1" ;
        recyclerView =findViewById(R.id.rv_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        GetContent(content);
        adapter = new ContentAdapter(this,rakeList);
        recyclerView.setAdapter(adapter);
    }

    public void GetContent(final String url) {
        OkhttpUntil.enqueueGetrequest(url, new TostringNetworkListining() {
            @Override
            public void BackResultFail(Exception errow) {

            }

            @Override
            public void tostring(String responseString) {
                if(responseString!=null){
                    RakeBean rakeBean = OkhttpUntil.toObject(RakeBean.class, responseString);

                    if (rakeBean != null) {
                        if ("Success".equals(rakeBean.getReason())) {
                            List<RakeBean.ResultBean.DataBean> data = rakeBean.getResult().getData();
                            for (int i = 0; i < data.size(); i++) {
                                rakeList.add(data.get(i));

                            }

                            adapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(ContentActivity.this, "找不到你输入的信息", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(ContentActivity.this, "找不到你输入的信息", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
