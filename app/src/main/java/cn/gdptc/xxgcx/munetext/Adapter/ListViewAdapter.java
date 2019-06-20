package cn.gdptc.xxgcx.munetext.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.ListViewInfo;

public class ListViewAdapter  extends BaseAdapter {
    private List<ListViewInfo> listViewInfos;
    private Context context;

    public ListViewAdapter(List<ListViewInfo> listViewInfos, Context context) {
        this.listViewInfos = listViewInfos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listViewInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListViewInfo listViewInfo = listViewInfos.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_home_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.title.setText(listViewInfo.getContent());
        viewHolder.img.setImageResource(listViewInfo.getImageId());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView title;
        public ImageView img;


        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.tv_home_title);
            this.img = (ImageView) rootView.findViewById(R.id.img_home_title);

        }
    }
}
