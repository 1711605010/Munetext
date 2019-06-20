package cn.gdptc.xxgcx.munetext.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
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
public class ClassifyFragment extends Fragment {

    public ClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_classify,container,false);
        return view;
    }


}

