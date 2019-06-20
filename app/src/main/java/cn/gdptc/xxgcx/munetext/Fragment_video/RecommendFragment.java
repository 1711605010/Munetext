package cn.gdptc.xxgcx.munetext.Fragment_video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {


    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommend,container,false);
             return view;
    }

}
