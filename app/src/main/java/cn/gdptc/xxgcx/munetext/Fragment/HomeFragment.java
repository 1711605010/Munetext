package cn.gdptc.xxgcx.munetext.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Activity.CakeActivity;
import cn.gdptc.xxgcx.munetext.Activity.ColdActivity;
import cn.gdptc.xxgcx.munetext.Activity.FoodActivity;
import cn.gdptc.xxgcx.munetext.Activity.RakeActivity;
import cn.gdptc.xxgcx.munetext.Adapter.ListViewAdapter;
import cn.gdptc.xxgcx.munetext.Adapter.MyRecyclerViewAdapter;
import cn.gdptc.xxgcx.munetext.R;

import cn.gdptc.xxgcx.munetext.uilt.ListViewInfo;
import cn.gdptc.xxgcx.munetext.uilt.RecyclerViewInfo;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private List<RecyclerViewInfo> infoList;
    private ListViewAdapter listViewAdapter;
    private List<ListViewInfo> listViewInfos;
    private Context context;
    private ListView listView;
    private ImageButton imageButton;
    private ArrayList<String> list;

    private LinearLayout ll_liangcai,ll_hongbei;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);
        imageButton= view.findViewById(R.id.img_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RakeActivity.class);
                startActivity(intent);
            }
        });


        ll_liangcai = view.findViewById(R.id.ll_liangcai);
        ll_hongbei = view.findViewById(R.id.ll_hongbei);
        ll_liangcai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ColdActivity.class);
                startActivity(intent);
            }
        });
        ll_hongbei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CakeActivity.class);
                startActivity(intent);
            }
        });
//        infoList = new ArrayList<RecyclerViewInfo>();
//        infoList.add(new RecyclerViewInfo(R.drawable.liangcai, "凉菜"));
//        infoList.add(new RecyclerViewInfo(R.drawable.hongbei, "烘培"));
//        infoList.add(new RecyclerViewInfo(R.drawable.sucai, "素菜"));
//        infoList.add(new RecyclerViewInfo(R.drawable.dangao, "蛋糕"));
//        infoList.add(new RecyclerViewInfo(R.drawable.xican, "西餐"));
//        infoList.add(new RecyclerViewInfo(R.drawable.cai, "下饭菜"));
//        infoList.add(new RecyclerViewInfo(R.drawable.chuancai, "川菜"));
//        infoList.add(new RecyclerViewInfo(R.drawable.mianshi, "面食"));
//        infoList.add(new RecyclerViewInfo(R.drawable.qingdan, "清淡"));
//        infoList.add(new RecyclerViewInfo(R.drawable.fenlei2, "全部分类"));
//        myRecyclerViewAdapter = new MyRecyclerViewAdapter(infoList, getActivity());
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setAdapter(myRecyclerViewAdapter);





        context = getActivity();
        listView = (ListView) view.findViewById(R.id.listView);
        listViewInfos = new LinkedList<ListViewInfo>();
        listViewInfos.add(new ListViewInfo(R.drawable.xiaren, "蒜香糖醋虾仁"));
        listViewInfos.add(new ListViewInfo(R.drawable.jikuai, "香辣炸鸡块"));
        listViewInfos.add(new ListViewInfo(R.drawable.danta, "栗子蛋挞"));
        listViewInfos.add(new ListViewInfo(R.drawable.pinggu, "干锅平菇"));
        listViewInfos.add(new ListViewInfo(R.drawable.jizhua, "鹌鹑蛋烧鸡爪"));
        listViewInfos.add(new ListViewInfo(R.drawable.jirou, "蔬菜鸡胸肉"));
        listViewInfos.add(new ListViewInfo(R.drawable.jizhengu, "爽口金针菇"));
        listViewInfos.add(new ListViewInfo(R.drawable.cai, "sss"));
        listViewInfos.add(new ListViewInfo(R.drawable.cai, "sss"));
        listViewAdapter = new ListViewAdapter((LinkedList<ListViewInfo>) listViewInfos, context);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getActivity(), FoodActivity.class);
                    startActivity(intent);
                }
            }
        });
        listView.setAdapter(listViewAdapter);


        list = new ArrayList<String>();
        return view;
    }
}


