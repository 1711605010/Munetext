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
        data1.logo= R.drawable.hongpei1;
        data1.title= "黑穗醋栗仙女蛋糕卷";
        data1.content="最近入了一个很神奇的宝贝，它叫黑穗醋栗，百度了一下，不仅有丰富的维生素，还能够增强孩子的免疫力，重点是颜值超高";
        mydata.add(data1);

        Software data2 = new Software();
        data2.logo=R.drawable. hongpei2 ;
        data2.title= "黄桃千层蛋糕卷";
        data2.content="一到夏天，就想吃些清凉的甜品，有什么既好吃，又不用烤箱，也不必打发鸡蛋，就能做的甜品吗？那就试试这款“黄桃千层”";
        mydata.add(data2);

        Software data3 = new Software();
        data3.logo=R.drawable.hongpei3 ;
        data3.title= "蛋挞";
        data3.content="蛋挞源于香港，在香港茶餐厅将之发扬光大。蛋挞自上世纪五十年代，开始进驻香港大小餐厅，成为香港人喜爱的美点。葡式";
        mydata.add(data3);

        Software data4 = new Software();
        data4.logo=R.drawable.hongpei4 ;
        data4.title= "马卡龙";
        data4.content="今天来一份誉满全球、超高人气、甜酥无比的小西点“马卡龙”。马卡龙，又称作玛卡龙、杏仁小圆饼，哪一个“称号”更具诱惑呢？";
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




