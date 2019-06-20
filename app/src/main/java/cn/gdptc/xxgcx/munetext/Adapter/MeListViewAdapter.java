package cn.gdptc.xxgcx.munetext.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.uilt.MeListViewInfo;

public class MeListViewAdapter extends BaseAdapter {
    private List<MeListViewInfo> listViewInfos;
    private Context context;
    public MeListViewAdapter(List<MeListViewInfo> listViewInfos, Context context) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MeListViewInfo listViewInfo = listViewInfos.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_me_item, null);
        MeListViewAdapter.ViewHolder viewHolder = new MeListViewAdapter.ViewHolder(convertView);
        viewHolder.title.setText(listViewInfo.getContent());
        viewHolder.img.setImageResource(listViewInfo.getImageId());
        viewHolder.right.setImageResource(listViewInfo.getRight());
        return convertView;
    }
    public static class ViewHolder {
        public View rootView;
        public TextView title;
        public ImageView img,right;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.tv_me_title);
            this.img = (ImageView) rootView.findViewById(R.id.img_me_title);
            this.right = (ImageView) rootView.findViewById(R.id.img_right);

        }
    }
}
