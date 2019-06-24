package cn.gdptc.xxgcx.munetext.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import cn.gdptc.xxgcx.munetext.Adapter.CakeListViewAdapter;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.ListViewInfo;

public class CakeActivity extends AppCompatActivity {
    private List<ListViewInfo> listViewInfos;
    private CakeListViewAdapter listViewAdapter;
    private ListView listView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);
        listView = (ListView)findViewById(R.id.list_cake);
        CakeListViewAdapter listViewAdapter=new  CakeListViewAdapter(listViewInfos,context);
        listView.setAdapter(listViewAdapter);

    }



}
