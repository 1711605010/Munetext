package cn.gdptc.xxgcx.munetext.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.RecyclerViewInfo;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewHolder>{
    private List<RecyclerViewInfo> infoList;
    private Context context;

    public MyRecyclerViewAdapter(List<RecyclerViewInfo> infoList, Context context) {
        this.infoList = infoList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,null);
        MyRecyclerViewHolder viewHolder = new MyRecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
        holder.logo.setImageResource(infoList.get(position).getLogo());
        holder.tvContext.setText(infoList.get(position).getContext());

    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView tvContext;


        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            logo = (ImageView) itemView.findViewById(R.id.img_title);
            tvContext = (TextView) itemView.findViewById(R.id.tv_title);


        }
    }
}
