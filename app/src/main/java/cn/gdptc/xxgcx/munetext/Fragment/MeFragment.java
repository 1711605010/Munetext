package cn.gdptc.xxgcx.munetext.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;


import cn.gdptc.xxgcx.munetext.Adapter.MeListViewAdapter;
import cn.gdptc.xxgcx.munetext.Activity.LoginActivity;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.MeListViewInfo;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {
    private MeListViewAdapter listViewAdapter;
    private List<MeListViewInfo> listViewInfos;
    private Context context;
    private ListView listView;
    private LinearLayout linearLayout;


    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_me,container,false);
        linearLayout=view.findViewById(R.id.ll_login);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        context = getActivity();
        listView = (ListView) view.findViewById(R.id.listView_me);
        listViewInfos = new LinkedList<MeListViewInfo>();
        listViewInfos.add(new MeListViewInfo(R.drawable.shoucang,"我的收藏",R.drawable.youjiantou));
        listViewInfos.add(new MeListViewInfo(R.drawable.liulan,"浏览记录",R.drawable.youjiantou));
        listViewInfos.add(new MeListViewInfo(R.drawable.cai,"sss",R.drawable.youjiantou));
        listViewInfos.add(new MeListViewInfo(R.drawable.shezhi,"设置",R.drawable.youjiantou));
        listViewInfos.add(new MeListViewInfo(R.drawable.dianzan,"点赞",R.drawable.youjiantou));
        listViewInfos.add(new MeListViewInfo(R.drawable.lianxi,"联系我们",R.drawable.youjiantou));
        listViewAdapter = new MeListViewAdapter((LinkedList<MeListViewInfo>) listViewInfos,context);
        listView.setAdapter(listViewAdapter);

        if(islogin()){
            //登陆成功后跳转

        }else {
            //登陆失败
        }
        return view;
    }
    public boolean islogin(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("flag",Context.MODE_PRIVATE);
        boolean islogin = sharedPreferences.getBoolean("islogin", false);
        return islogin;
    }
}
