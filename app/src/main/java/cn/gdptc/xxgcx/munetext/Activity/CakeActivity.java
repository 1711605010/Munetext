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

public class CakeActivity extends AppCompatActivity {
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
        data1.logo= R.drawable.xiaren;
        data1.title= "微信";
        data1.content="微信 是腾讯公司推出的供即时通讯服务的免费应用程序。";
        mydata.add(data1);

        Software data2 = new Software();
        data2.logo=R.drawable. xiaren ;
        data2.title= "易信";
        data2.content="易信是由网易和中国电信联合开发的一款免费聊天软件。";
        mydata.add(data2);

        Software data3 = new Software();
        data3.logo=R.drawable. xiaren ;
        data3.title= "米聊";
        data3.content="米聊是小米科技出品的一款免费即时通讯工具。";
        mydata.add(data3);

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
                Intent intent = new Intent(CakeActivity.this, MainActivity.class);
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
            View itemView = LayoutInflater. from (arg2.getContext()).inflate(R.layout.list_cake_item , null);
            ImageView imgv = (ImageView) itemView.findViewById(R.id. img_cake );
            imgv.setImageResource(mydata.get(arg0).logo);
            TextView tvtitle = (TextView) itemView.findViewById(R.id. tv_cake_title );
            tvtitle.setText(mydata.get(arg0).title);
            TextView tvcontent = (TextView) itemView.findViewById(R.id. tv_cake_do );
            tvcontent.setText(mydata.get(arg0).content);
            return itemView;
        }
    }


    class Software {
        Integer logo;
        String  title,content;
    }

}




