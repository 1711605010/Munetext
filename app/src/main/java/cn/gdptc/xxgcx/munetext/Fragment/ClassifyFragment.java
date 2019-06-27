package cn.gdptc.xxgcx.munetext.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Activity.ContentActivity;
import cn.gdptc.xxgcx.munetext.Adapter.ViewPagerAdapter;
import cn.gdptc.xxgcx.munetext.R;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends Fragment {
    private View inflate;
    private VerticalTabLayout vtb;
    private List<String> datas = new ArrayList<String>();
    private ViewPager vtbvp;
    public ClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = View.inflate(getActivity(), R.layout.fragment_classify, null);

        return inflate;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vtb = inflate.findViewById(R.id.vtb);
        vtbvp = inflate.findViewById(R.id.vtbvp);

        datas.add("菜式菜品");
        datas.add("菜系");
        datas.add("时令食材");
        datas.add("功效");
        datas.add("场景");
        datas.add("工艺口味");

        vpsp vpsp = new vpsp(getActivity().getSupportFragmentManager());
        vtbvp.setAdapter(vpsp);

        vtb.setupWithViewPager(vtbvp);

    }

    class vpsp extends FragmentPagerAdapter {

        public vpsp(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            Vcount vcount = new Vcount();
            Bundle bundle = new Bundle();
            bundle.putString("name",datas.get(position));
            vcount.setArguments(bundle);
            return vcount;        }

        @Override
        public int getCount() {
            return datas.size();
        }
    }

    public static class Vcount extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View inflate = View.inflate(getActivity(), R.layout.test_layout, null);
            View jiacai = inflate.findViewById(R.id.jiacai);
            View kuaishou = inflate.findViewById(R.id.kuaishou);
            View sucai = inflate.findViewById(R.id.sucai);
            View liangcai = inflate.findViewById(R.id.liangcai);
            View hongbei = inflate.findViewById(R.id.hongbei);
            View tang = inflate.findViewById(R.id.tang);
            View xiaochi = inflate.findViewById(R.id.xiaochi);
            View qingdan = inflate.findViewById(R.id.qingdan);
            View mianshi = inflate.findViewById(R.id.mianshi);



            jiacai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ContentActivity.class);
                    intent.putExtra("content","家常菜");
                    startActivity(intent);
                }
            });

            kuaishou.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","快手菜");
                    startActivity(intent);
                }
            });

            sucai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","素菜");
                    startActivity(intent);
                }
            });
            liangcai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","凉菜");
                    startActivity(intent);
                }
            });
            hongbei.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","烘焙");
                    startActivity(intent);
                }
            });
            tang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","汤");
                    startActivity(intent);
                }
            });
            xiaochi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","小吃");
                    startActivity(intent);
                }
            });
            mianshi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","面");
                    startActivity(intent);
                }
            });
            qingdan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),ContentActivity.class);
                    intent.putExtra("content","清淡");
                    startActivity(intent);
                }
            });

            return inflate;
        }
    }
}

