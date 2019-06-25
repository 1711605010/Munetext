package cn.gdptc.xxgcx.munetext.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.gdptc.xxgcx.munetext.Activity.StepActivity;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.RakeBean;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.RecyclerHolder> {
    private Context mContext;
    private List<RakeBean.ResultBean.DataBean> rakeList;


    public ContentAdapter(Context mContext, List<RakeBean.ResultBean.DataBean> rakeList) {
        this.mContext = mContext;
        this.rakeList = rakeList;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_item, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        RakeBean.ResultBean.DataBean dataBean = rakeList.get(position);
        holder.item_title.setText(dataBean.getTitle());
        Glide
                .with(mContext)
                .load(dataBean.getAlbums().get(0))
                .into(holder.iv_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,StepActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra("bean",dataBean);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return rakeList.size();
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        public TextView item_title;
        public ImageView iv_img;
        private RecyclerHolder(View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.content_title);
            iv_img = itemView.findViewById(R.id.content_img);
        }
    }
}