package cn.gdptc.xxgcx.munetext.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.RakeBean;

public class StepAdapter extends BaseAdapter {
    private List<RakeBean.ResultBean.DataBean.StepsBean> stepList;
    private Context context;

    public StepAdapter(List<RakeBean.ResultBean.DataBean.StepsBean> stepList, Context context) {
        this.stepList = stepList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stepList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.lv_step_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.title.setText(stepList.get(position).getStep());
        Glide
                .with(context)
                .load(stepList.get(position).getImg())
                .into(viewHolder.img);
        return convertView;
    }
    public  class ViewHolder {
        public View rootView;
        public TextView title;
        public ImageView img;


        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.tv_step);
            this.img = (ImageView) rootView.findViewById(R.id.img_step);


        }
    }
}
