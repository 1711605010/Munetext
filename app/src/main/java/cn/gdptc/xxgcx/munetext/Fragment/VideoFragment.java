package cn.gdptc.xxgcx.munetext.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Adapter.ViewPagerAdapter;
import cn.gdptc.xxgcx.munetext.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
    private View view,view1,view2,view3;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LayoutInflater layoutInflater;
    private List<String> mTitleList = new ArrayList<>();
    private List<View> mListView = new ArrayList<>();

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video,container,false);
        initView();
        initViewPager();
        return view;
    }
    private void initViewPager() {
        mTitleList.add("推荐");
        mTitleList.add("体验");
        mTitleList.add("快手菜");
        layoutInflater = LayoutInflater.from(getActivity());
        view1 = layoutInflater.inflate(R.layout.fragment_recommend,null);
        view2 = layoutInflater.inflate(R.layout.fragment_fride,null);
        view3 = layoutInflater.inflate(R.layout.fragment_rumeng,null);
        mListView.add(view1);
        mListView.add(view2);
        mListView.add(view3);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(mListView,mTitleList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(2)));
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initView() {
        tabLayout = (TabLayout) view.findViewById(R.id.myTabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_discovery);
    }

}
