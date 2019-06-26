package cn.gdptc.xxgcx.munetext.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Adapter.ListViewAdapter;
import cn.gdptc.xxgcx.munetext.MainActivity;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.ListViewInfo;

public class ColdActivity extends AppCompatActivity {
    private List<Software> mydata;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);
        imageButton=findViewById(R.id.img_btn_back2);
        initView();
        mydata=new ArrayList<Software>();
        Software data1 = new Software();
        data1.logo= R.drawable.liangcai1;
        data1.title= "果仁菠菜";
        data1.content="1.菠切段菜";
        mydata.add(data1);

        Software data2 = new Software();
        data2.logo=R.drawable. liangcai2 ;
        data2.title= "花生酱拌面";
        data2.content="1.黄瓜切丝备用";
        mydata.add(data2);

        Software data3 = new Software();
        data3.logo=R.drawable.liangcai3 ;
        data3.title= "凉拌菜花";
        data3.content="1.青红椒切段，胡萝卜片";
        mydata.add(data3);

        Software data4 = new Software();
        data4.logo=R.drawable.liiangcai4 ;
        data4.title= "烤肉拌饭";
        data4.content="1.黄瓜40克、胡萝卜30克";
        mydata.add(data4);

        MylistAdpter mylistAdpter = new MylistAdpter();
        ListView  mylistview = (ListView)findViewById(R.id.list_cake);
        mylistview.setAdapter(mylistAdpter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            }
        });

    }

    private void initView() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColdActivity.this, MainActivity.class);
                intent.putExtra("PA","1");
                startActivity(intent);
            }
        });

    }

    class MylistAdpter extends BaseAdapter {
        @Override
        public int getCount() {
            return mydata.size();
        }

        @Override
        public Object getItem(int arg0) {
            return mydata.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }


        @Override
        public View getView(int arg0, View arg1, ViewGroup
                arg2) {
            View itemView = LayoutInflater. from (arg2.getContext()).inflate(R.layout.list_cold_item , null);
            ImageView imgv = (ImageView) itemView.findViewById(R.id. img_cold );
            imgv.setImageResource(mydata.get(arg0).logo);
            TextView tvtitle = (TextView) itemView.findViewById(R.id. tv_cold_title );
            tvtitle.setText(mydata.get(arg0).title);
            TextView tvcontent = (TextView) itemView.findViewById(R.id. tv_cold_do );
            tvcontent.setText(mydata.get(arg0).content);
            return itemView;
        }
    }


    class Software {
        Integer logo;
        String  title,content;
    }

}




